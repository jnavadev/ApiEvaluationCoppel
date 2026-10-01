package com.test.copamw.infrastructure.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document containing external TV show identifiers.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExternalsDocument {
    private Integer tvrage;
    private Integer thetvdb;
    private String imdb;
}
