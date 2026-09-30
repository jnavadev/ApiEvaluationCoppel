package com.test.copamw.infrastructure.adapter.out.tmaze.dto;

import java.time.LocalDate;
import java.util.List;

public record TvMazeShowDetailRespDto(
        Long id,
        String url,
        String name,
        String type,
        String language,
        List<String> genres,
        String status,
        Integer runtime,
        Integer averageRuntime,
        LocalDate premiered,
        LocalDate ended,
        String officialSite,
        TvMazeScheduleRespDto schedule,
        TvMazeRatingRespDto rating,
        Integer weight,
        TvMazeNetworkRespDto network,
        TvMazeWebChannelRespDto webChannel,
        TvMazeCountryRespDto dvdCountry,
        TvMazeExternalsRespDto externals,
        TvMazeImageRespDto image,
        String summary,
        Long updated
) {
}
