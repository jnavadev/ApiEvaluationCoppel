package com.test.copamw.infrastructure.adapter.in.rest.dto;

/**
 * Response DTO representing a comment associated with a TV show.
 *
 * @param comment comment text
 * @param rating rating assigned to the show
 */
public record ShowCommentResponseDto(
        String comment,
        Integer rating
) {
}
