package com.test.copamw.application.service;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.domain.port.out.TvMazeShowPort;
import org.springframework.stereotype.Service;

/**
 * Application service responsible for retrieving detailed information
 * about TV shows.
 *
 * <p>This service coordinates the application flow between the input
 * layer and the TV Maze show output port.</p>
 */
@Service
public class ShowDetailService {

    private final TvMazeShowPort tvMazeShowPort;

    /**
     * Creates a new show detail service.
     *
     * @param tvMazeShowPort output port used to retrieve show information
     */
    public ShowDetailService(TvMazeShowPort tvMazeShowPort) {
        this.tvMazeShowPort = tvMazeShowPort;
    }

    /**
     * Retrieves the complete information of a show.
     *
     * @param showId TV Maze show identifier
     * @return complete show information
     */
    public ShowDetail getShow(Long showId) {
        return tvMazeShowPort.getShow(showId);
    }
}
