package com.test.copamw.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
