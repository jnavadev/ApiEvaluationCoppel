package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain model containing external identifiers associated with a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Externals {
    private Integer tvrage;
    private Integer thetvdb;
    private String imdb;
}
