package com.test.copamw.infrastructure.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document representing a TV show network.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NetworkDocument {
    private Long id;
    private String name;
    private CountryDocument country;
    private String officialSite;
}
