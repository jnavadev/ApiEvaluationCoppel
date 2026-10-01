package com.test.copamw.infrastructure.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document containing TV show images.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDocument {
    private String medium;
    private String original;
}
