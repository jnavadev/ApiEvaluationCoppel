package com.test.copamw.infrastructure.adapter.out.mongo.document;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document representing a TV show schedule.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDocument {
    private String time;
    private List<String> days;
}
