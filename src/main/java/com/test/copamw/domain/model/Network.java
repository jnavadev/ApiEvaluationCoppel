package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain model representing the network associated with a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Network {

    private Long id;
    private String name;
    private Country country;
    private String officialSite;
}
