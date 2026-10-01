package com.test.copamw.domain.port.out;

import com.test.copamw.domain.model.ShowDetail;

import java.util.Optional;

/**
 * Output port for accessing cached TV show details.
 */
public interface MongoShowPort {

    /**
     * Finds a show by its identifier in the cache.
     *
     * @param showId show identifier
     * @return the cached show when it exists
     */
    Optional<ShowDetail> findById(Long showId);

    /**
     * Stores a show in the cache.
     *
     * @param showDetail show detail to store
     * @return the stored show
     */
    ShowDetail save(ShowDetail showDetail);
}
