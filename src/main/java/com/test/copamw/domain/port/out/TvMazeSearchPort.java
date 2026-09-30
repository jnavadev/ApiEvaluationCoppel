package com.test.copamw.domain.port.out;

import java.util.List;

import com.test.copamw.domain.model.Show;

/**
 * Output port used to search TV shows.
 *
 * <p>The application depends on this abstraction instead of directly
 * depending on the external TV Maze API.</p>
 */
public interface TvMazeSearchPort {

    /**
     * Searches TV shows using the provided query.
     *
     * @param query search criteria
     * @return list of shows matching the query
     */
    List<Show> searchShows(String query);
}
