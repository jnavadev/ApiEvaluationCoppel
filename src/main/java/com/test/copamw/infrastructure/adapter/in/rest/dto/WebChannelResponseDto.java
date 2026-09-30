package com.test.copamw.infrastructure.adapter.in.rest.dto;

/**
 * Response DTO representing the web channel associated with a TV show.
 *
 * @param id web channel identifier
 * @param name web channel name
 */
public record WebChannelResponseDto(Long id,
                                    String name) {
}
