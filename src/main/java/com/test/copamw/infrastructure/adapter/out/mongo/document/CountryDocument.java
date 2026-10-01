package com.test.copamw.infrastructure.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document representing country information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDocument {
    private String name;
    private String code;
    private String timezone;
}
