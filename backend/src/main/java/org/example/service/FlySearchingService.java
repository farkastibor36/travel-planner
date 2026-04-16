package org.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FlySearchingService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private static final String BASE_URL = "https://tequila-api.kiwi.com";

    public FlySearchingService(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${tequila.api.key:}") String apiKey
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = apiKey;
    }

    public String searchFlights(String flyFrom, String flyTo, String dateFrom, String dateTo, Integer adults, String curr, Integer limit, Integer maxStopovers) {
        String url = UriComponentsBuilder
                .fromHttpUrl(BASE_URL + "/v2/search")
                .queryParam("fly_from", flyFrom)
                .queryParam("fly_to", flyTo)
                .queryParam("date_from", dateFrom)
                .queryParam("date_to", dateTo)
                .queryParam("adults", adults != null ? adults : 1)
                .queryParam("curr", curr != null ? curr : "EUR")
                .queryParam("limit", limit != null ? limit : 10)
                .queryParam("max_stopovers", maxStopovers != null ? maxStopovers : 0)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiKey);
        headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getLocationCode(String cityName) {
        String url = UriComponentsBuilder
                .fromHttpUrl(BASE_URL + "/locations/query")
                .queryParam("term", cityName)
                .queryParam("location_types", "city")
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiKey);
        headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}