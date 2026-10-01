package com.test.copamw.infrastructure.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document representing a TV show rating.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDocument {
    private Double average;
}
