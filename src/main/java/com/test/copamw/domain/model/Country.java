package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain model representing country information associated with a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private String name;
    private String code;
    private String timezone;
}
