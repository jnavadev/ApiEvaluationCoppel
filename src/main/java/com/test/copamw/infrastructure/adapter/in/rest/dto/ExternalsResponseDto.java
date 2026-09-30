package com.test.copamw.infrastructure.adapter.in.rest.dto;

/**
 * Response DTO containing external identifiers of a TV show.
 */
public record ExternalsResponseDto(Integer tvrage,
       Integer thetvdb,
        String imdb) {
}
