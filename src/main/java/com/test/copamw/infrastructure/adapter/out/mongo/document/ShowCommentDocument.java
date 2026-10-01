package com.test.copamw.infrastructure.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB document representing a comment and rating associated with a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "show_comments")
public class ShowCommentDocument {

    @Id
    private String id;
    private Long showId;
    private String comment;
    private Integer rating;
}
