package com.test.copamw.infrastructure.adapter.out.mongo.document;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MongoDB document representing the complete information of a TV show.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "shows")
public class ShowDetailDocument {
    @Id
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
    private ScheduleDocument schedule;
    private RatingDocument rating;
    private Integer weight;
    private NetworkDocument network;
    private WebChannelDocument webChannel;
    private CountryDocument dvdCountry;
    private ExternalsDocument externals;
    private ImageDocument image;
    private String summary;
    private Long updated;
}
