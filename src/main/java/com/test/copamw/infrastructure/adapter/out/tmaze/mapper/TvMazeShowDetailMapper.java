package com.test.copamw.infrastructure.adapter.out.tmaze.mapper;

import com.test.copamw.domain.model.*;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.*;
import org.mapstruct.Mapper;

/**
 * Maps TV Maze show detail responses to domain models.
 *
 * <p>This mapper isolates the domain layer from the external
 * TV Maze API representation.</p>
 */
@Mapper(componentModel = "spring")
public interface TvMazeShowDetailMapper {

    /**
     * Maps a complete TV Maze show response to the domain model.
     *
     * @param source TV Maze show detail response
     * @return mapped show detail domain model
     */
    ShowDetail toDomain(TvMazeShowDetailRespDto source);
    Country toDomain(TvMazeCountryRespDto source);
    Schedule toDomain(TvMazeScheduleRespDto source);
    Rating toDomain(TvMazeRatingRespDto source);
    Externals toDomain(TvMazeExternalsRespDto source);
    Image toDomain(TvMazeImageRespDto source);
    Network toDomain(TvMazeNetworkRespDto source);
    WebChannel toDomain(TvMazeWebChannelRespDto source);
}
