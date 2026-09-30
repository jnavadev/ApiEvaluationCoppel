package com.test.copamw.infrastructure.adapter.in.rest.dto;

import java.util.List;

public record ShowRespDto(
        Long id,
        String name,
        String channel,
        String summary,
        List<String> genres) {

}
