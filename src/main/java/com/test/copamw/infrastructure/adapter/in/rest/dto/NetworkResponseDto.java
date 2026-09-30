package com.test.copamw.infrastructure.adapter.in.rest.dto;

/**
 * Response DTO representing the network associated with a TV show.
 *
 * @param id network identifier
 * @param name network name
 * @param country network country
 * @param officialSite network official website
 */
public record NetworkResponseDto(Long id,
                                 String name,
                                 CountryResponseDto country,
                                 String officialSite) {
}
