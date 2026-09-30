package com.test.copamw.domain.port.out;

import com.test.copamw.domain.model.ShowDetail;

/**
 * Output port for retrieving detailed information about TV shows.
 *
 * <p>The application layer uses this port to obtain show details
 * without depending on the external TV Maze API implementation.</p>
 */
public interface TvMazeShowPort {

    /**
     * Retrieves a show by its TV Maze identifier.
     *
     * @param showId TV Maze show identifier
     * @return complete show information
     */
    ShowDetail getShow(Long showId);
}
