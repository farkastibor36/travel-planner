package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "username")
    private String userName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Past
    @Column(name = "birth_date")
    private Date birthDate;
    @Email
    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "email")
    private String email;
    @Size(min = 6, max = 40)
    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+]).{8,}$")
    @Column(name = "password")
    private String password;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = Timestamp.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        }
    }
}