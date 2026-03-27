package org.example.dto;

import java.sql.Date;
import java.sql.Timestamp;

public record UserDto(Long id, String userName, String firstName, String lastName, Date birthDate, String email,
                      Timestamp createdAt) {
}