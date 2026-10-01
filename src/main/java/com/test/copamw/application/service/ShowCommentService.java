package com.test.copamw.application.service;

import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.domain.port.out.ShowCommentPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.test.copamw.constants.GlobalConstants.INIT_SAVE_COMMENT;

/**
 * Service responsible for processing comments and ratings associated
 * with TV shows.
 */
@Slf4j
@Service
public class ShowCommentService {

    private final ShowCommentPort showCommentPort;

    /**
     * Creates a new show comment service.
     *
     * @param showCommentPort output port used to store comments
     */
    public ShowCommentService(ShowCommentPort showCommentPort) {
        this.showCommentPort = showCommentPort;
    }

    /**
     * Stores a comment and rating associated with a TV show.
     *
     * @param showComment comment and rating to store
     * @return the stored comment
     */
    public ShowComment saveComment(ShowComment showComment) {
        log.info(INIT_SAVE_COMMENT, showComment);
        return showCommentPort.save(showComment);
    }
}
