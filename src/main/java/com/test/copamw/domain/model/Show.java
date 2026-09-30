package com.test.copamw.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Domain model representing a TV show.
 *
 * <p>This model is independent of external API representations
 * and is used internally by the application.</p>
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    private Long id;
    private String name;
    private String channel;
    private String summary;
    private List<String> genres;
}
