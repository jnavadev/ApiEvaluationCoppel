package com.test.copamw.infrastructure.adapter.out.mongo;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.domain.port.out.MongoShowPort;
import com.test.copamw.infrastructure.adapter.out.mongo.document.ShowDetailDocument;
import com.test.copamw.infrastructure.adapter.out.mongo.mapper.ShowDetailDocumentMapper;
import com.test.copamw.infrastructure.adapter.out.mongo.repository.ShowDetailMongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MongoDB adapter responsible for persisting and retrieving TV show details
 * from the application cache.
 */
@Component
public class MongoShowAdapter implements MongoShowPort {

    private final ShowDetailMongoRepository repository;
    private final ShowDetailDocumentMapper mapper;

    /**
     * Creates a MongoDB show adapter.
     *
     * @param repository MongoDB repository
     * @param mapper mapper between domain and MongoDB documents
     */
    public MongoShowAdapter(
            ShowDetailMongoRepository repository,
            ShowDetailDocumentMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Finds a show by its identifier in MongoDB.
     *
     * @param showId show identifier
     * @return the show when it exists in MongoDB
     */
    @Override
    public Optional<ShowDetail> findById(Long showId) {

        return repository.findById(showId)
                .map(mapper::toDomain);
    }

    /**
     * Stores a show detail in MongoDB.
     *
     * @param showDetail show detail to store
     * @return the stored show detail
     */
    @Override
    public ShowDetail save(ShowDetail showDetail) {

        ShowDetailDocument document =
                mapper.toDocument(showDetail);

        ShowDetailDocument savedDocument =
                repository.save(document);

        return mapper.toDomain(savedDocument);
    }
}
