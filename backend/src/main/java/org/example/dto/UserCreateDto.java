package org.example.dto;

import java.sql.Date;

public record UserCreateDto(String userName, String firstName, String lastName, Date birthDate, String email,
                            String password) {
}