package com.test.copamw.infrastructure.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document representing a web channel.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebChannelDocument {
    private Long id;
    private String name;
}
