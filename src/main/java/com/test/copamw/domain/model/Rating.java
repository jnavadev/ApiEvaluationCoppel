package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain model representing the rating of a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private Double average;
}
