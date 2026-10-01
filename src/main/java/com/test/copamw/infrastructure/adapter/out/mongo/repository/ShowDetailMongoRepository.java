package com.test.copamw.infrastructure.adapter.out.mongo.repository;

import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowDetailDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for accessing TV show details stored in MongoDB.
 */
public interface ShowDetailMongoRepository extends MongoRepository<ShowDetailDocument, Long> {
}
