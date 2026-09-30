package com.test.copamw.infrastructure.adapter.out.tmaze.dto;

import java.util.List;

public record TvMazeScheduleRespDto(String time,
                                    List<String> days) {
}
