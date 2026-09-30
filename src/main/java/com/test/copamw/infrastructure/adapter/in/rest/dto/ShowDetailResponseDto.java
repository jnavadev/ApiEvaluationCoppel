package com.test.copamw.infrastructure.adapter.in.rest.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * Response DTO containing the complete information of a TV show.
 *
 * @param id show identifier
 * @param url TV Maze show URL
 * @param name show name
 * @param type show type
 * @param language show language
 * @param genres show genres
 * @param status show status
 * @param runtime show runtime in minutes
 * @param averageRuntime average runtime in minutes
 * @param premiered premiere date
 * @param ended end date
 * @param officialSite official website
 * @param schedule broadcast schedule
 * @param rating show rating
 * @param weight TV Maze weight
 * @param network associated network
 * @param webChannel associated web channel
 * @param dvdCountry DVD country
 * @param externals external identifiers
 * @param image show images
 * @param summary show summary
 * @param updated last update timestamp
 */
public record ShowDetailResponseDto(
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
        ScheduleResponseDto schedule,
        RatingResponseDto rating,
        Integer weight,
        NetworkResponseDto network,
        WebChannelResponseDto webChannel,
        CountryResponseDto dvdCountry,
        ExternalsResponseDto externals,
        ImageResponseDto image,
        String summary,
        Long updated) {
}
