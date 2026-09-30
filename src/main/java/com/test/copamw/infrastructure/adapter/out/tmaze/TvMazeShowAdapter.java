package com.test.copamw.infrastructure.adapter.out.tmaze;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.domain.port.out.TvMazeShowPort;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.TvMazeShowDetailRespDto;
import com.test.copamw.infrastructure.adapter.out.tmaze.mapper.TvMazeShowDetailMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import static com.test.copamw.constants.GlobalConstants.TVMAZE_SHOW_PATH_ID;

/**
 * Adapter responsible for retrieving show details from the TV Maze API.
 *
 * <p>This class implements the {@link TvMazeShowPort} output port and
 * isolates the domain layer from the external TV Maze API.</p>
 */
@Component
public class TvMazeShowAdapter implements TvMazeShowPort {

    private final RestClient restClient;
    private final TvMazeShowDetailMapper tvMazeShowDetailMapper;

    /**
     * Creates a new TV Maze show adapter.
     *
     * @param restClient client used to communicate with TV Maze
     * @param tvMazeShowDetailMapper mapper used to convert TV Maze responses
     *                               into domain models
     */
    public TvMazeShowAdapter(
            RestClient restClient,
            TvMazeShowDetailMapper tvMazeShowDetailMapper) {
        this.restClient = restClient;
        this.tvMazeShowDetailMapper = tvMazeShowDetailMapper;
    }

    /**
     * Retrieves a show from TV Maze using its identifier.
     *
     * @param showId TV Maze show identifier
     * @return complete show information
     */
    @Override
    public ShowDetail getShow(Long showId) {

        TvMazeShowDetailRespDto response = restClient
                .get()
                .uri(TVMAZE_SHOW_PATH_ID, showId)
                .retrieve()
                .body(TvMazeShowDetailRespDto.class);

        if (response == null) {
            return null;
        }

        return tvMazeShowDetailMapper.toDomain(response);
    }
}
