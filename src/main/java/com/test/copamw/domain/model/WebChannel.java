package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain model representing the web channel associated with a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebChannel {
    private Long id;
    private String name;
}
