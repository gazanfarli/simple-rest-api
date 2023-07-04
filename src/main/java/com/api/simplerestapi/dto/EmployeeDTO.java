package com.api.simplerestapi.dto;


import lombok.Builder;

@Builder
public record EmployeeDTO(
        Long id,
        String firstName,
        String lastName,
        String email
) {}
