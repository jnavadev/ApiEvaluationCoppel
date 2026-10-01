package com.test.copamw.infrastructure.adapter.in.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import com.test.copamw.domain.model.*;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowDetailResponseDto;

import static com.test.copamw.constants.TestConstants.*;

class ShowDetailResponseMapperTest {

    private final ShowDetailResponseMapper mapper =
            Mappers.getMapper(ShowDetailResponseMapper.class);

    @Test
    void shouldMapCompleteShowDetailToResponse() {

        Country country = new Country(
                UNITED_STATE,
                CODE_US,
                "America/New_York");

        Network network = new Network(
                NETWORK_ID,
                CHANNEL_ABC,
                country,
                "https://abc.com");

        WebChannel webChannel = new WebChannel(
                WEB_CHANNEL_ID,
                CHANNEL_NETFLIX);

        Schedule schedule = new Schedule(
                "20:00",
                List.of("Monday", "Wednesday"));

        Rating rating = new Rating(8.5);

        Externals externals = new Externals(
                100,
                200,
                "tt1234567");

        Image image = new Image(
                "https://image-medium.jpg",
                "https://image-original.jpg");

        ShowDetail source = new ShowDetail(
                1L,
                "https://api.tvmaze.com/shows/1",
                "Under the Dome",
                "Scripted",
                LANGUAGE_ENGLISH,
                List.of("Drama", "Science-Fiction"),
                "Ended",
                60,
                60,
                LocalDate.of(2013, 6, 24),
                LocalDate.of(2015, 9, 10),
                "https://official-site.com",
                schedule,
                rating,
                99,
                network,
                webChannel,
                country,
                externals,
                image,
                "A show summary",
                123456789L,
                List.of(new ShowComment(
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                )));

        ShowDetailResponseDto result = mapper.toResponse(source);

        assertNotNull(result);

        assertEquals(source.getId(), result.id());
        assertEquals(source.getUrl(), result.url());
        assertEquals(source.getName(), result.name());
        assertEquals(source.getType(), result.type());
        assertEquals(source.getLanguage(), result.language());
        assertEquals(source.getGenres(), result.genres());
        assertEquals(source.getStatus(), result.status());
        assertEquals(source.getRuntime(), result.runtime());
        assertEquals(source.getAverageRuntime(), result.averageRuntime());
        assertEquals(source.getPremiered(), result.premiered());
        assertEquals(source.getEnded(), result.ended());
        assertEquals(source.getOfficialSite(), result.officialSite());
        assertEquals(source.getWeight(), result.weight());
        assertEquals(source.getSummary(), result.summary());
        assertEquals(source.getUpdated(), result.updated());

        assertNotNull(result.comments());
        assertEquals(source.getComments().size(), result.comments().size());

        assertEquals(
                source.getComments().get(0).getComment(),
                result.comments().get(0).comment());
        assertEquals(
                source.getComments().get(0).getRating(),
                result.comments().get(0).rating());

        assertNotNull(result.schedule());
        assertEquals(
                source.getSchedule().getTime(),
                result.schedule().time());
        assertEquals(
                source.getSchedule().getDays(),
                result.schedule().days());

        assertNotNull(result.rating());
        assertEquals(
                source.getRating().getAverage(),
                result.rating().average());

        assertNotNull(result.network());
        assertEquals(
                source.getNetwork().getId(),
                result.network().id());
        assertEquals(
                source.getNetwork().getName(),
                result.network().name());
        assertEquals(
                source.getNetwork().getOfficialSite(),
                result.network().officialSite());

        assertNotNull(result.network().country());
        assertEquals(
                source.getNetwork().getCountry().getName(),
                result.network().country().name());
        assertEquals(
                source.getNetwork().getCountry().getCode(),
                result.network().country().code());
        assertEquals(
                source.getNetwork().getCountry().getTimezone(),
                result.network().country().timezone());

        assertNotNull(result.webChannel());
        assertEquals(
                source.getWebChannel().getId(),
                result.webChannel().id());
        assertEquals(
                source.getWebChannel().getName(),
                result.webChannel().name());

        assertNotNull(result.dvdCountry());
        assertEquals(
                source.getDvdCountry().getName(),
                result.dvdCountry().name());

        assertNotNull(result.externals());
        assertEquals(
                source.getExternals().getTvrage(),
                result.externals().tvrage());
        assertEquals(
                source.getExternals().getThetvdb(),
                result.externals().thetvdb());
        assertEquals(
                source.getExternals().getImdb(),
                result.externals().imdb());

        assertNotNull(result.image());
        assertEquals(
                source.getImage().getMedium(),
                result.image().medium());
        assertEquals(
                source.getImage().getOriginal(),
                result.image().original());
    }
}
