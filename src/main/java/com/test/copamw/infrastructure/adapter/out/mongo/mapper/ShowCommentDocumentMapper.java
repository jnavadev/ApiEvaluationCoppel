package com.test.copamw.infrastructure.adapter.out.mongo.mapper;

import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowCommentDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Maps show comments between the domain model and MongoDB document.
 */
@Mapper(componentModel = "spring")
public interface ShowCommentDocumentMapper {

    /**
     * Maps a domain show comment to a MongoDB document.
     *
     * @param source show comment domain model
     * @return MongoDB document
     */
    @Mapping(target = "id", ignore = true)
    ShowCommentDocument toDocument(ShowComment source);

    /**
     * Maps a MongoDB document to a domain show comment.
     *
     * @param source MongoDB document
     * @return show comment domain model
     */
    ShowComment toDomain(ShowCommentDocument source);
}
