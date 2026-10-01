package com.test.copamw.infrastructure.adapter.out.mongo.repository;

import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowCommentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MongoDB repository for show comments.
 */
public interface ShowCommentMongoRepository extends MongoRepository<ShowCommentDocument, String> {

    /**
     * Retrieves all comments associated with a show.
     *
     * @param showId TV Maze show identifier
     * @return list of comments associated with the show
     */
    List<ShowCommentDocument> findByShowId(Long showId);
}
