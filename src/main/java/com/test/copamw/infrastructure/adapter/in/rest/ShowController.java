package com.test.copamw.infrastructure.adapter.in.rest;

import java.util.List;

import com.test.copamw.application.service.ShowCommentService;
import com.test.copamw.domain.model.ShowComment;

import com.test.copamw.infrastructure.adapter.out.tmaze.dto.ShowCommentRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.test.copamw.application.service.ShowDetailService;
import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowDetailResponseDto;
import com.test.copamw.infrastructure.adapter.in.rest.mapper.ShowDetailResponseMapper;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.test.copamw.application.service.ShowSearchService;
import com.test.copamw.domain.model.Show;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowRespDto;
import com.test.copamw.infrastructure.adapter.in.rest.mapper.ShowRespMapper;

import static com.test.copamw.constants.GlobalConstants.*;

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
    private final ShowDetailService showDetailService;
    private final ShowDetailResponseMapper showDetailResponseMapper;
    private final ShowCommentService showCommentService;

public ShowController(
            ShowSearchService showSearchService,
            ShowRespMapper showRespMapper,
            ShowDetailService showDetailService,
            ShowDetailResponseMapper showDetailResponseMapper,
            ShowCommentService showCommentService) {
        this.showSearchService = showSearchService;
        this.showRespMapper = showRespMapper;
        this.showDetailService = showDetailService;
        this.showDetailResponseMapper = showDetailResponseMapper;
        this.showCommentService = showCommentService;
    }

    /**
     * Searches TV shows using the provided search criteria.
     *
     * @param searchQuery search criteria; must not be blank
     * @return list of matching shows
     */
    @GetMapping(ENDPOINT_SEARCH)
    public List<ShowRespDto> searchShows(
            @RequestParam(SEARCH_QUERY_PARAM)
            @NotBlank(message = SEARCH_QUERY_EMPTY)String searchQuery) {

        List<Show> shows = showSearchService.searchShows(searchQuery);

        return shows.stream()
        .map(showRespMapper::toResponse)
        .toList();
    }

    /**
     * Retrieves the complete information of a show by its identifier.
     *
     * @param showId TV Maze show identifier
     * @return complete show information
     */
    @GetMapping(ENDPOINT_SHOW_ID)
    public ShowDetailResponseDto getShow(
            @PathVariable Long showId) {

        ShowDetail showDetail = showDetailService.getShow(showId);

        return showDetailResponseMapper.toResponse(showDetail);
    }

    /**
     * Saves a comment and rating associated with a TV show.
     *
     * @param request request containing the show identifier, comment and rating
     * @return HTTP status indicating the result of the operation
     */
    @PostMapping("/comments")
    public ResponseEntity<Void> saveComment(
            @Valid @RequestBody ShowCommentRequest request) {

        ShowComment showComment = new ShowComment(
                request.showId(),
                request.comment(),
                request.rating()
        );

        showCommentService.saveComment(showComment);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
