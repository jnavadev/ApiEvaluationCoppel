package com.test.copamw.application.service;

import static com.test.copamw.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.test.copamw.application.exception.ServiceException;
import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.domain.port.out.ShowCommentPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.copamw.domain.model.ShowDetail;
import com.test.copamw.domain.port.out.MongoShowPort;
import com.test.copamw.domain.port.out.TvMazeShowPort;

@ExtendWith(MockitoExtension.class)
class ShowDetailServiceTest {

    @Mock
    private TvMazeShowPort tvMazeShowPort;

    @Mock
    private MongoShowPort mongoShowPort;

    @Mock
    private ShowCommentPort showCommentPort;

    private ShowDetailService service;

    @BeforeEach
    void setUp() {
        service = new ShowDetailService(
                tvMazeShowPort,
                mongoShowPort,
                showCommentPort);
    }

    List<ShowComment> comments = List.of(
            new ShowComment(
                    SHOW_ID,
                    MESSAGE_MAX_RATING,
                    RATING
            )
    );

    @Test
    void shouldReturnShowFromCacheWhenShowExistsInMongo() {

        ShowDetail cachedShow = new ShowDetail();

        when(mongoShowPort.findById(SHOW_ID))
                .thenReturn(Optional.of(cachedShow));
        when(showCommentPort.findByShowId(SHOW_ID))
                .thenReturn(comments);

        ShowDetail result = service.getShow(SHOW_ID);

        assertEquals(cachedShow, result);
        assertEquals(comments, result.getComments());

        verify(mongoShowPort).findById(SHOW_ID);
        verify(tvMazeShowPort, never()).getShow(SHOW_ID);
        verify(mongoShowPort, never()).save(cachedShow);
        verify(showCommentPort).findByShowId(SHOW_ID);
    }

    @Test
    void shouldGetShowFromTvMazeAndSaveWhenNotFoundInMongo() {

        ShowDetail showDetail = new ShowDetail();


        when(mongoShowPort.findById(SHOW_ID))
                .thenReturn(Optional.empty());

        when(tvMazeShowPort.getShow(SHOW_ID))
                .thenReturn(showDetail);

        when(mongoShowPort.save(showDetail))
                .thenReturn(showDetail);

        when(showCommentPort.findByShowId(SHOW_ID))
                .thenReturn(comments);

        ShowDetail result = service.getShow(SHOW_ID);

        assertEquals(showDetail, result);
        assertEquals(comments, result.getComments());

        verify(mongoShowPort).findById(SHOW_ID);
        verify(tvMazeShowPort).getShow(SHOW_ID);
        verify(mongoShowPort).save(showDetail);
        verify(showCommentPort).findByShowId(SHOW_ID);
    }

    @Test
    void shouldNotSaveShowWhenTvMazeFails() {

        ServiceException exception =
                new ServiceException(
                        "TV Maze service error",
                        new RuntimeException("TV Maze unavailable"));

        when(mongoShowPort.findById(SHOW_ID))
                .thenReturn(Optional.empty());

        when(tvMazeShowPort.getShow(SHOW_ID))
                .thenThrow(exception);

        assertThrows(
                ServiceException.class,
                () -> service.getShow(SHOW_ID));

        verify(mongoShowPort).findById(SHOW_ID);
        verify(tvMazeShowPort).getShow(SHOW_ID);
        verify(mongoShowPort, never()).save(any());
        verify(showCommentPort, never()).findByShowId(SHOW_ID);
    }
}
