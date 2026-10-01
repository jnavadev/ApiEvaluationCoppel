package com.test.copamw.infrastructure.adapter.out.mongo;

import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.domain.port.out.ShowCommentPort;
import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowCommentDocument;
import com.test.copamw.infrastructure.adapter.out.mongo.mapper.ShowCommentDocumentMapper;
import com.test.copamw.infrastructure.adapter.out.mongo.repository.ShowCommentMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.test.copamw.constants.GlobalConstants.SAVE_COMMENT;

/**
 * MongoDB adapter for storing show comments.
 */
@Slf4j
@Component
public class MongoShowCommentAdapter implements ShowCommentPort {
    private final ShowCommentMongoRepository repository;
    private final ShowCommentDocumentMapper mapper;

    /**
     * Creates a MongoDB adapter for show comments.
     *
     * @param repository MongoDB repository
     * @param mapper mapper between domain and MongoDB document
     */
    public MongoShowCommentAdapter(
            ShowCommentMongoRepository repository,
            ShowCommentDocumentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Stores a comment and rating associated with a TV show.
     *
     * @param showComment comment and rating to store
     * @return the stored comment
     */
    @Override
    public ShowComment save(ShowComment showComment) {
        ShowCommentDocument document =
                mapper.toDocument(showComment);

        ShowCommentDocument savedDocument =
                repository.save(document);

        log.info(
                SAVE_COMMENT,
                showComment.getShowId(),
                showComment.getRating()
        );
        return mapper.toDomain(savedDocument);
    }
}
