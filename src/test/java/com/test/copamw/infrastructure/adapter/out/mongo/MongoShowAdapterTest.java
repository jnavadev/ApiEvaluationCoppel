package com.test.copamw.infrastructure.adapter.out.mongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowDetailDocument;
import com.test.copamw.infrastructure.adapter.out.mongo.mapper.ShowDetailDocumentMapper;
import com.test.copamw.infrastructure.adapter.out.mongo.repository.ShowDetailMongoRepository;

@ExtendWith(MockitoExtension.class)
class MongoShowAdapterTest {

    @Mock
    private ShowDetailMongoRepository repository;

    @Mock
    private ShowDetailDocumentMapper mapper;

    private MongoShowAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new MongoShowAdapter(repository, mapper);
    }

    @Test
    void shouldReturnShowWhenFoundById() {

        Long showId = 1L;

        ShowDetailDocument document = new ShowDetailDocument();
        ShowDetail expected = new ShowDetail();

        when(repository.findById(showId))
                .thenReturn(Optional.of(document));

        when(mapper.toDomain(document))
                .thenReturn(expected);

        Optional<ShowDetail> result =
                adapter.findById(showId);

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());

        verify(repository).findById(showId);
        verify(mapper).toDomain(document);
    }

    @Test
    void shouldReturnEmptyWhenShowIsNotFound() {

        Long showId = 999L;

        when(repository.findById(showId))
                .thenReturn(Optional.empty());

        Optional<ShowDetail> result =
                adapter.findById(showId);

        assertTrue(result.isEmpty());

        verify(repository).findById(showId);
    }

    @Test
    void shouldSaveShow() {

        ShowDetail showDetail = new ShowDetail();

        ShowDetailDocument document =
                new ShowDetailDocument();

        ShowDetailDocument savedDocument =
                new ShowDetailDocument();

        ShowDetail expected =
                new ShowDetail();

        when(mapper.toDocument(showDetail))
                .thenReturn(document);

        when(repository.save(document))
                .thenReturn(savedDocument);

        when(mapper.toDomain(savedDocument))
                .thenReturn(expected);

        ShowDetail result =
                adapter.save(showDetail);

        assertEquals(expected, result);

        verify(mapper).toDocument(showDetail);
        verify(repository).save(document);
        verify(mapper).toDomain(savedDocument);
    }
}
