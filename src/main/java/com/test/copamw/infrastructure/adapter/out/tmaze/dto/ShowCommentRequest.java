package com.test.copamw.infrastructure.adapter.out.tmaze.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request used to create a comment and rating for a TV show.
 *
 * @param showId identifier of the TV show
 * @param comment comment associated with the show
 * @param rating rating assigned to the show, from 0 to 5
 */
public record ShowCommentRequest(@NotNull
                                 Long showId,
                                 @NotBlank
                                 String comment,
                                 @NotNull
                                 @Min(0)
                                 @Max(5)
                                 Integer rating) {
}
