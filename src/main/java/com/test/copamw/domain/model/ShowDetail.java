package com.test.copamw.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Domain model representing the complete information of a TV show.
 *
 * <p>This model is independent of the external TV Maze API and is used
 * by the application when retrieving show details.</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowDetail {
    private Long id;
    private String url;
    private String name;
    private String type;
    private String language;
    private List<String> genres;
    private String status;
    private Integer runtime;
    private Integer averageRuntime;
    private LocalDate premiered;
    private LocalDate ended;
    private String officialSite;
    private Schedule schedule;
    private Rating rating;
    private Integer weight;
    private Network network;
    private WebChannel webChannel;
    private Country dvdCountry;
    private Externals externals;
    private Image image;
    private String summary;
    private Long updated;
}
