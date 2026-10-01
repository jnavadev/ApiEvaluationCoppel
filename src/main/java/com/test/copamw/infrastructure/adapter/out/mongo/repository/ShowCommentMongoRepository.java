package com.test.copamw.infrastructure.adapter.out.mongo.repository;

import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowCommentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB repository for show comments.
 */
public interface ShowCommentMongoRepository extends MongoRepository<ShowCommentDocument, String> {
}
