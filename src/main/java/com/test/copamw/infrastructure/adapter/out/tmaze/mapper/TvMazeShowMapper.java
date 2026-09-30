package com.test.copamw.infrastructure.adapter.out.tmaze.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.test.copamw.domain.model.Show;
import com.test.copamw.infrastructure.adapter.out.tmaze.dto.TvMazeShowRespDto;

/**
 * Maps TV Maze show responses to the application domain model.
 *
 * <p>The channel is resolved from the network when available.
 * If no network is provided, the web channel is used.</p>
 */
@Mapper(componentModel = "spring")
public interface TvMazeShowMapper {

    @Mapping(target = "channel", expression ="java(resolveChannel(source))")
    Show toDomain(TvMazeShowRespDto source);

    /**
     * Resolves the channel name from the available TV Maze channel information.
     *
     * @param source TV Maze show response
     * @return network name, web channel name, or {@code null} when neither
     *         is available
     */
    default String resolveChannel(TvMazeShowRespDto source) {
        if (source.network() != null) {
            return source.network().name();
        } else if (source.webChannel() != null) {
            return source.webChannel().name();
        } else {
            return null;
        }
    }


}
