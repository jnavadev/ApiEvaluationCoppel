package com.test.copamw.application.service;
import java.util.List;

import com.test.copamw.domain.port.out.TvMazeSearchPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.test.copamw.domain.model.Show;

import static com.test.copamw.constants.GlobalConstants.EXECUTE_SEARCH_SHOW_MESSAGE;

/**
 * Application service responsible for searching TV shows.
 *
 * <p>The service coordinates the search operation through the
 * {@link TvMazeSearchPort} output port.</p>
 */
@Slf4j
@Service
public class ShowSearchService {

    private final TvMazeSearchPort tvMazeSearchPort;

    public ShowSearchService(TvMazeSearchPort tvMazeSearchPort) {
        this.tvMazeSearchPort = tvMazeSearchPort;
    }

    /**
     * Searches shows using the configured output port.
     *
     * @param query search criteria
     * @return list of matching shows
     */
    public List<Show> searchShows(String query) {
        log.info(EXECUTE_SEARCH_SHOW_MESSAGE, query);
        return tvMazeSearchPort.searchShows(query);
    }
}
