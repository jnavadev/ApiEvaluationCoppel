package com.test.copamw.infrastructure.adapter.out.mongo.mapper;

import com.test.copamw.domain.model.*;
import com.test.copamw.infrastructure.adapter.out.mongo.document.*;
import org.mapstruct.Mapper;

/**
 * Maps TV show domain models to MongoDB documents and vice versa.
 */
@Mapper(componentModel = "spring")
public interface ShowDetailDocumentMapper {

    /**
     * Maps a domain show detail to a MongoDB document.
     *
     * @param source show detail domain model
     * @return MongoDB document
     */
    ShowDetailDocument toDocument(ShowDetail source);

    /**
     * Maps a MongoDB document to a domain show detail.
     *
     * @param source MongoDB document
     * @return show detail domain model
     */
    ShowDetail toDomain(ShowDetailDocument source);

    ScheduleDocument toDocument(Schedule source);

    Schedule toDomain(ScheduleDocument source);

    RatingDocument toDocument(Rating source);

    Rating toDomain(RatingDocument source);

    NetworkDocument toDocument(Network source);

    Network toDomain(NetworkDocument source);

    WebChannelDocument toDocument(WebChannel source);

    WebChannel toDomain(WebChannelDocument source);

    CountryDocument toDocument(Country source);

    Country toDomain(CountryDocument source);

    ExternalsDocument toDocument(Externals source);

    Externals toDomain(ExternalsDocument source);

    ImageDocument toDocument(Image source);

    Image toDomain(ImageDocument source);

}
