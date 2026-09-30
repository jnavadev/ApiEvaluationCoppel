package com.test.copamw.infrastructure.adapter.out.tmaze.dto;

import java.util.List;

public record TvMazeShowRespDto(Long id,
        String name,
        List<String> genres,
        TvMazeNetworkRespDto network,
        TvMazeWebChannelRespDto webChannel,
        String summary) {

}
