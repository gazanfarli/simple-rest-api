package com.api.simplerestapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name should not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name should not be empty")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
