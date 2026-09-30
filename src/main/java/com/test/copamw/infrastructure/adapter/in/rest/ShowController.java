package com.test.copamw.infrastructure.adapter.in.rest;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.copamw.application.service.ShowSearchService;
import com.test.copamw.domain.model.Show;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowRespDto;
import com.test.copamw.infrastructure.adapter.in.rest.mapper.ShowRespMapper;

/**
 * REST controller exposing TV show search operations.
 *
 * <p>This controller acts as the inbound adapter of the application
 * and exposes the search functionality through HTTP.</p>
 */
@RestController
@RequestMapping("/shows")
@Validated
public class ShowController {
    private final ShowSearchService showSearchService;
    private final ShowRespMapper showRespMapper;

public ShowController(
            ShowSearchService showSearchService,
            ShowRespMapper showRespMapper) {
        this.showSearchService = showSearchService;
        this.showRespMapper = showRespMapper;
    }

    /**
     * Searches TV shows using the provided search criteria.
     *
     * @param searchQuery search criteria; must not be blank
     * @return list of matching shows
     */
    @GetMapping("/search")
    public List<ShowRespDto> searchShows(
            @RequestParam("search_query")
            @NotBlank(message = "search_query not empty")String searchQuery) {

        List<Show> shows = showSearchService.searchShows(searchQuery);

        return shows.stream()
        .map(showRespMapper::toResponse)
        .toList();
    }

}
