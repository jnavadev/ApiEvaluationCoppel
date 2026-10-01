package com.test.copamw.infrastructure.adapter.in.rest.mapper;

import com.test.copamw.domain.model.*;
import com.test.copamw.infrastructure.adapter.in.rest.dto.*;
import org.mapstruct.Mapper;

/**
 * Maps domain show detail models to API response DTOs.
 */
@Mapper(componentModel = "spring")
public interface ShowDetailResponseMapper {

    /**
     * Maps a complete show detail domain model to its API response DTO.
     *
     * @param source show detail domain model
     * @return show detail response DTO
     */
    ShowDetailResponseDto toResponse(ShowDetail source);
    ScheduleResponseDto toResponse(Schedule source);
    RatingResponseDto toResponse(Rating source);
    NetworkResponseDto toResponse(Network source);
    WebChannelResponseDto toResponse(WebChannel source);
    CountryResponseDto toResponse(Country source);
    ExternalsResponseDto toResponse(Externals source);
    ImageResponseDto toResponse(Image source);
    ShowCommentResponseDto toResponse(ShowComment source);
}
