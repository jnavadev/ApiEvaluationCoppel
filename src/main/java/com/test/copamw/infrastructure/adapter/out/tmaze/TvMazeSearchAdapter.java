package com.test.copamw.infrastructure.adapter.out.tmaze;

import java.util.Arrays;
import java.util.List;

import com.test.copamw.application.exception.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import com.test.copamw.domain.model.Show;
import com.test.copamw.domain.port.out.TvMazeSearchPort;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.TvMazeSearchRespDto;
import com.test.copamw.infrastructure.adapter.out.tmaze.mapper.TvMazeShowMapper;
import org.springframework.web.client.RestClientResponseException;

import static com.test.copamw.constants.GlobalConstants.*;

/**
 * Adapter responsible for communicating with the TV Maze API.
 *
 * <p>This class implements the {@link TvMazeSearchPort} output port
 * and translates external TV Maze responses into domain models.</p>
 */
@Component
public class TvMazeSearchAdapter implements TvMazeSearchPort{

    private final RestClient restClient;
    private final TvMazeShowMapper tvMazeShowMapper;

    public TvMazeSearchAdapter(
            RestClient restClient,
            TvMazeShowMapper tvMazeShowMapper) {
        this.restClient = restClient;
        this.tvMazeShowMapper = tvMazeShowMapper;
    }

    /**
     * Searches TV Maze shows and maps the external response to domain models.
     *
     * @param query search criteria
     * @return list of matching shows
     * @throws ServiceException when TV Maze cannot be reached or returns
     *         an error response
     */
    @Override
    public List<Show> searchShows(String query) {
        try {
            TvMazeSearchRespDto[] response = restClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path(TVMAZE_SEARCH_PATH)
                            .queryParam(TVMAZE_QUERY_PARAM, query)
                            .build())
                    .retrieve()
                    .body(TvMazeSearchRespDto[].class);

            if (response == null) {
                return List.of();
            }

            return Arrays.stream(response)
                    .map(TvMazeSearchRespDto::show)
                    .map(tvMazeShowMapper::toDomain)
                    .toList();

        } catch (RestClientResponseException | ResourceAccessException exception) {
            throw new ServiceException(
                    TVMAZE_SERVICE_ERROR,
                    exception);
        }
    }

}
