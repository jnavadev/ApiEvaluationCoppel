package com.test.copamw.infrastructure.adapter.in.rest.mapper;

import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowCommentResponseDto;
import org.mapstruct.Mapper;

import com.test.copamw.domain.model.Show;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowRespDto;

@Mapper(componentModel = "spring")
public interface ShowRespMapper {

	ShowRespDto toResponse(Show show);
	ShowCommentResponseDto toCommentResponse(ShowComment showComment);

}
