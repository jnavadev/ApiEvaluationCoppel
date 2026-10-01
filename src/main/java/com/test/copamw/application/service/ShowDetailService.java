package com.test.copamw.application.service;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.domain.port.out.MongoShowPort;
import com.test.copamw.domain.port.out.ShowCommentPort;
import com.test.copamw.domain.port.out.TvMazeShowPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.test.copamw.constants.GlobalConstants.*;

/**
 * Application service responsible for retrieving detailed information
 * about TV shows.
 *
 * <p>This service coordinates the application flow between the input
 * layer and the TV Maze show output port.</p>
 */
@Slf4j
@Service
public class ShowDetailService {

    private final TvMazeShowPort tvMazeShowPort;
    private final MongoShowPort mongoShowPort;
    private final ShowCommentPort showCommentPort;

    /**
     * Creates a new show detail service.
     *
     * @param tvMazeShowPort output port used to retrieve show information
     */
    public ShowDetailService(TvMazeShowPort tvMazeShowPort,
                             MongoShowPort mongoShowPort,
                             ShowCommentPort showCommentPort) {

        this.tvMazeShowPort = tvMazeShowPort;
        this.mongoShowPort = mongoShowPort;
        this.showCommentPort = showCommentPort;
    }

    /**
     * Retrieves the complete information of a show.
     *
     * @param showId TV Maze show identifier
     * @return complete show information
     */
    public ShowDetail getShow(Long showId) {

        Optional<ShowDetail> cachedShow =
                mongoShowPort.findById(showId);

        ShowDetail showDetail;

        if (cachedShow.isPresent()) {
            log.info(FOUND_MONGO, showId);
            showDetail = cachedShow.get();
        } else {

            log.info(FOUND_TVMAZE, showId);

            showDetail = tvMazeShowPort.getShow(showId);

            mongoShowPort.save(showDetail);

            log.info(SAVE_MONGO, showId);
        }

        log.info(FOUND_TVMAZE, showId);
        showDetail.setComments(
                showCommentPort.findByShowId(showId)
        );
        return showDetail;
    }
}
