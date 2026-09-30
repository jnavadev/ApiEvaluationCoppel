package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain model containing the available images for a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String medium;
    private String original;
}
