package com.test.copamw.application.service;

import com.test.copamw.domain.model.Show;
import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.domain.port.out.ShowCommentPort;
import com.test.copamw.domain.port.out.TvMazeSearchPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static com.test.copamw.constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class ShowSearchServiceTest {

    @Mock
    private TvMazeSearchPort tvMazeSearchPort;

    @Mock
    private ShowCommentPort showCommentPort;

    private ShowSearchService showSearchService;

    @BeforeEach
    void setUp() {
        showSearchService = new ShowSearchService(tvMazeSearchPort, showCommentPort);
    }

    @Test
    void ShowsFromPortOk() {

        String query = SEARCH_QUERY;

        Show show = new Show(
                SHOW_ID,
                SHOW_NAME,
                CHANNEL_ABC,
                SHOW_SUMMARY,
                List.of(GENRE_ACTION, GENRE_ADVENTURE)
        );

        List<Show> expectedShows = List.of(show);

        ShowComment comment = new ShowComment(
                SHOW_ID,
                MESSAGE_MAX_RATING,
                RATING
        );

        List<ShowComment> comments = List.of(comment);

        when(tvMazeSearchPort.searchShows(query))
                .thenReturn(expectedShows);

        when(showCommentPort.findByShowId(SHOW_ID))
                .thenReturn(comments);

        List<Show> result = showSearchService.searchShows(query);

        assertEquals(expectedShows, result);
        assertSame(expectedShows, result);

        assertEquals(comments, result.get(0).getComments());

        verify(tvMazeSearchPort).searchShows(query);
        verify(showCommentPort).findByShowId(SHOW_ID);
    }
}
