package com.test.copamw.infrastructure.adapter.in.rest.dto;

public record ErrorResponseDto(int status,
                               String error,
                               String message) {
}
