package com.test.copamw.infrastructure.adapter.in.rest.mapper;

import com.test.copamw.domain.model.Show;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.TvMazeNetworkRespDto;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.TvMazeShowRespDto;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.TvMazeWebChannelRespDto;
import com.test.copamw.infrastructure.adapter.out.tmaze.mapper.TvMazeShowMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static com.test.copamw.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TvMazeShowMapperTest {

    private final TvMazeShowMapper mapper =
            Mappers.getMapper(TvMazeShowMapper.class);

    @Test
    void shouldMapNetworkAsChannel() {

        TvMazeNetworkRespDto network =
                new TvMazeNetworkRespDto(SHOW_ID, CHANNEL_ABC);

        TvMazeShowRespDto source = new TvMazeShowRespDto(
                SHOW_ID,
                SHOW_NAME,
                List.of(GENRE_ACTION, GENRE_ADVENTURE),
                network,
                null,
                SHOW_SUMMARY);

        Show result = mapper.toDomain(source);

        assertEquals(SHOW_ID, result.getId());
        assertEquals(SHOW_NAME, result.getName());
        assertEquals(CHANNEL_ABC, result.getChannel());
        assertEquals(SHOW_SUMMARY, result.getSummary());
        assertEquals(
                List.of(GENRE_ACTION, GENRE_ADVENTURE),
                result.getGenres());
    }

    @Test
    void shouldMapWebChannelWhenNetworkIsNull() {

        TvMazeWebChannelRespDto webChannel =
                new TvMazeWebChannelRespDto(WEB_CHANNEL_ID, CHANNEL_NETFLIX);

        TvMazeShowRespDto source = new TvMazeShowRespDto(
                SHOW_ID,
                SHOW_NAME,
                List.of(GENRE_ACTION),
                null,
                webChannel,
                SHOW_SUMMARY);

        Show result = mapper.toDomain(source);

        assertEquals(CHANNEL_NETFLIX, result.getChannel());
    }

    @Test
    void shouldReturnNullChannelWhenNetworkAndWebChannelAreNull() {

        TvMazeShowRespDto source = new TvMazeShowRespDto(
                SHOW_ID,
                SHOW_NAME,
                List.of(GENRE_ACTION),
                null,
                null,
                SHOW_SUMMARY);

        Show result = mapper.toDomain(source);

        assertNull(result.getChannel());
    }
}
