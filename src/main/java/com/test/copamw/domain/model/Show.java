package com.test.copamw.domain.model;

import java.util.List;

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
@NoArgsConstructor
public class Show {

    private Long id;
    private String name;
    private String channel;
    private String summary;
    private List<String> genres;
    private List<ShowComment> comments;

    /**
     * Creates a show without comments.
     *
     * @param id show identifier
     * @param name show name
     * @param channel show channel
     * @param summary show summary
     * @param genres show genres
     */
    public Show(
            Long id,
            String name,
            String channel,
            String summary,
            List<String> genres) {

        this.id = id;
        this.name = name;
        this.channel = channel;
        this.summary = summary;
        this.genres = genres;
        this.comments = List.of();
    }

}
