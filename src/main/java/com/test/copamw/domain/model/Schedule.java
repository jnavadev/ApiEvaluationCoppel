package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Domain model representing the broadcast schedule of a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private String time;
    private List<String> days;
}
