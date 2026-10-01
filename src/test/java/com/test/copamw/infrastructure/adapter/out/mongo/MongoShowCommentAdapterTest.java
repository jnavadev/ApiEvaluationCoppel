package com.test.copamw.infrastructure.adapter.out.mongo;

import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowCommentDocument;
import com.test.copamw.infrastructure.adapter.out.mongo.mapper.ShowCommentDocumentMapper;
import com.test.copamw.infrastructure.adapter.out.mongo.repository.ShowCommentMongoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.test.copamw.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MongoShowCommentAdapterTest {

    @Mock
    private ShowCommentMongoRepository repository;

    @Mock
    private ShowCommentDocumentMapper mapper;

    private MongoShowCommentAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new MongoShowCommentAdapter(repository, mapper);
    }

    @Test
    void shouldSaveShowComment() {

        ShowComment showComment =
                new ShowComment(
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                );

        ShowCommentDocument document =
                new ShowCommentDocument(
                        null,
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                );

        ShowCommentDocument savedDocument =
                new ShowCommentDocument(
                        "comment-id",
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                );

        ShowComment expected =
                new ShowComment(
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                );

        when(mapper.toDocument(showComment))
                .thenReturn(document);

        when(repository.save(document))
                .thenReturn(savedDocument);

        when(mapper.toDomain(savedDocument))
                .thenReturn(expected);

        ShowComment result = adapter.save(showComment);

        assertEquals(expected, result);

        verify(mapper).toDocument(showComment);
        verify(repository).save(document);
        verify(mapper).toDomain(savedDocument);
    }

    @Test
    void shouldFindCommentsByShowId() {

        ShowCommentDocument document =
                new ShowCommentDocument(
                        "comment-id",
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                );

        ShowComment expected =
                new ShowComment(
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                );

        when(repository.findByShowId(SHOW_ID))
                .thenReturn(List.of(document));

        when(mapper.toDomain(document))
                .thenReturn(expected);

        List<ShowComment> result =
                adapter.findByShowId(SHOW_ID);

        assertEquals(1, result.size());
        assertEquals(expected, result.get(0));

        verify(repository).findByShowId(SHOW_ID);
        verify(mapper).toDomain(document);
    }
}
