package com.test.copamw.infrastructure.adapter.out.tmaze;

import static com.test.copamw.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClient;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.TvMazeShowDetailRespDto;
import com.test.copamw.infrastructure.adapter.out.tmaze.mapper.TvMazeShowDetailMapper;

@ExtendWith(MockitoExtension.class)
class TvMazeShowAdapterTest {

    @Mock
    private RestClient restClient;

    @Mock
    private TvMazeShowDetailMapper tvMazeShowDetailMapper;

    @Mock
    private RestClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private RestClient.ResponseSpec responseSpec;

    private TvMazeShowAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new TvMazeShowAdapter(
                restClient,
                tvMazeShowDetailMapper);
    }

    @Test
    void shouldReturnShowDetail() {

        Long showId = SHOW_ID;

        TvMazeShowDetailRespDto response =
                new TvMazeShowDetailRespDto(
                        showId,
                        "https://api.tvmaze.com/shows/1",
                        "Under the Dome",
                        "Scripted",
                        LANGUAGE_ENGLISH,
                        null,
                        "Ended",
                        60,
                        60,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        "A summary",
                        123456L);

        ShowDetail expected = new ShowDetail();

        when(restClient.get())
                .thenReturn(requestHeadersUriSpec);

        when(requestHeadersUriSpec.uri("/shows/{showId}", showId))
                .thenReturn(requestHeadersUriSpec);

        when(requestHeadersUriSpec.retrieve())
                .thenReturn(responseSpec);

        when(responseSpec.body(TvMazeShowDetailRespDto.class))
                .thenReturn(response);

        when(tvMazeShowDetailMapper.toDomain(response))
                .thenReturn(expected);

        ShowDetail result = adapter.getShow(showId);

        assertSame(expected, result);

        verify(restClient).get();
        verify(requestHeadersUriSpec)
                .uri("/shows/{showId}", showId);
        verify(requestHeadersUriSpec).retrieve();
        verify(responseSpec)
                .body(TvMazeShowDetailRespDto.class);
        verify(tvMazeShowDetailMapper)
                .toDomain(response);
    }
}
