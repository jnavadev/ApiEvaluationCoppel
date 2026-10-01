package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a comment and rating associated with a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowComment {

    private Long showId;
    private String comment;
    private Integer rating;
}
