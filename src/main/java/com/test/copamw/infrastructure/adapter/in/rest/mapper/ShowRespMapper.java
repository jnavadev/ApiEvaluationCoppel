package com.test.copamw.infrastructure.adapter.in.rest.mapper;

import org.mapstruct.Mapper;

import com.test.copamw.domain.model.Show;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowRespDto;

@Mapper(componentModel = "spring")
public interface ShowRespMapper {

	ShowRespDto toResponse(Show show);

}
