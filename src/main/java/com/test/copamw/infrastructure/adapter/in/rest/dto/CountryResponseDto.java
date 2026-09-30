package com.test.copamw.infrastructure.adapter.in.rest.dto;

/**
 * Response DTO representing country information.
 */
public record CountryResponseDto(String name,
        String code,
        String timezone) {
}
