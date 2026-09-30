package com.test.copamw.infrastructure.adapter.in.rest.mapper;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.*;
import com.test.copamw.infrastructure.adapter.out.tmaze.mapper.TvMazeShowDetailMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

import static com.test.copamw.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TvMazeShowDetailMapperTest {

    private final TvMazeShowDetailMapper mapper =
            Mappers.getMapper(TvMazeShowDetailMapper.class);

    @Test
    void shouldMapCompleteShowDetail() {

        TvMazeCountryRespDto country = new TvMazeCountryRespDto(
                UNITED_STATE,
                CODE_US,
                "America/New_York");

        TvMazeNetworkRespDto network = new TvMazeNetworkRespDto(
                NETWORK_ID,
                CHANNEL_ABC,
                country,
                "https://abc.com");

        TvMazeWebChannelRespDto webChannel =
                new TvMazeWebChannelRespDto(WEB_CHANNEL_ID, CHANNEL_NETFLIX);

        TvMazeScheduleRespDto schedule =
                new TvMazeScheduleRespDto(
                        "20:00",
                        List.of("Monday", "Wednesday"));

        TvMazeRatingRespDto rating =
                new TvMazeRatingRespDto(8.5);

        TvMazeExternalsRespDto externals =
                new TvMazeExternalsRespDto(
                        100,
                        200,
                        "tt1234567");

        TvMazeImageRespDto image =
                new TvMazeImageRespDto(
                        "https://image-medium.jpg",
                        "https://image-original.jpg");

        TvMazeShowDetailRespDto source =
                new TvMazeShowDetailRespDto(
                        NETWORK_ID,
                        "https://api.tvmaze.com/shows/1",
                        SHOW_NAME,
                        "Scripted",
                        LANGUAGE_ENGLISH,
                        List.of(GENRE_ACTION, GENRE_ADVENTURE),
                        "Running",
                        60,
                        60,
                        LocalDate.of(2020, 1, 1),
                        null,
                        "https://official-site.com",
                        schedule,
                        rating,
                        99,
                        network,
                        webChannel,
                        country,
                        externals,
                        image,
                        SHOW_SUMMARY,
                        123456789L);

        ShowDetail result = mapper.toDomain(source);

        assertNotNull(result);

        assertEquals(source.id(), result.getId());
        assertEquals(source.url(), result.getUrl());
        assertEquals(source.name(), result.getName());
        assertEquals(source.type(), result.getType());
        assertEquals(source.language(), result.getLanguage());
        assertEquals(source.genres(), result.getGenres());
        assertEquals(source.status(), result.getStatus());
        assertEquals(source.runtime(), result.getRuntime());
        assertEquals(source.averageRuntime(), result.getAverageRuntime());
        assertEquals(source.premiered(), result.getPremiered());
        assertEquals(source.ended(), result.getEnded());
        assertEquals(source.officialSite(), result.getOfficialSite());
        assertEquals(source.weight(), result.getWeight());
        assertEquals(source.summary(), result.getSummary());
        assertEquals(source.updated(), result.getUpdated());

        assertNotNull(result.getSchedule());
        assertEquals(
                source.schedule().time(),
                result.getSchedule().getTime());
        assertEquals(
                source.schedule().days(),
                result.getSchedule().getDays());

        assertNotNull(result.getRating());
        assertEquals(
                source.rating().average(),
                result.getRating().getAverage());

        assertNotNull(result.getNetwork());
        assertEquals(
                source.network().id(),
                result.getNetwork().getId());
        assertEquals(
                source.network().name(),
                result.getNetwork().getName());
        assertEquals(
                source.network().officialSite(),
                result.getNetwork().getOfficialSite());

        assertNotNull(result.getNetwork().getCountry());
        assertEquals(
                source.network().country().name(),
                result.getNetwork().getCountry().getName());

        assertNotNull(result.getWebChannel());
        assertEquals(
                source.webChannel().id(),
                result.getWebChannel().getId());
        assertEquals(
                source.webChannel().name(),
                result.getWebChannel().getName());

        assertNotNull(result.getDvdCountry());
        assertEquals(
                source.dvdCountry().name(),
                result.getDvdCountry().getName());

        assertNotNull(result.getExternals());
        assertEquals(
                source.externals().tvrage(),
                result.getExternals().getTvrage());
        assertEquals(
                source.externals().thetvdb(),
                result.getExternals().getThetvdb());
        assertEquals(
                source.externals().imdb(),
                result.getExternals().getImdb());

        assertNotNull(result.getImage());
        assertEquals(
                source.image().medium(),
                result.getImage().getMedium());
        assertEquals(
                source.image().original(),
                result.getImage().getOriginal());
    }
}
