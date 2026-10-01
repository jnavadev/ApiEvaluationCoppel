package com.test.copamw.domain.port.out;

import com.test.copamw.domain.model.ShowComment;

import java.util.List;

/**
 * Output port for storing comments and ratings associated with a TV show.
 */
public interface ShowCommentPort {

    /**
     * Stores a comment and rating for a TV show.
     *
     * @param showComment comment and rating to store
     * @return the stored comment
     */
    ShowComment save(ShowComment showComment);

    /**
     * Retrieves all comments associated with a TV show.
     *
     * @param showId TV Maze show identifier
     * @return list of comments associated with the show
     */
    List<ShowComment> findByShowId(Long showId);
}
