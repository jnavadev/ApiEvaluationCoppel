package com.test.copamw.infrastructure.adapter.in.rest.dto;

import java.util.List;

/**
 * Response DTO representing the broadcast schedule of a TV show.
 *
 * @param time broadcast time
 * @param days broadcast days
 */
public record ScheduleResponseDto(String time,
                                  List<String> days) {
}
