package com.test.copamw.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.test.copamw.application.exception.ServiceException;
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

    private ShowDetailService service;

    @BeforeEach
    void setUp() {
        service = new ShowDetailService(
                tvMazeShowPort,
                mongoShowPort);
    }

    @Test
    void shouldReturnShowFromCacheWhenShowExistsInMongo() {

        Long showId = 1L;
        ShowDetail cachedShow = new ShowDetail();

        when(mongoShowPort.findById(showId))
                .thenReturn(Optional.of(cachedShow));

        ShowDetail result = service.getShow(showId);

        assertEquals(cachedShow, result);

        verify(mongoShowPort).findById(showId);
        verify(tvMazeShowPort, never()).getShow(showId);
        verify(mongoShowPort, never()).save(cachedShow);
    }

    @Test
    void shouldGetShowFromTvMazeAndSaveWhenNotFoundInMongo() {

        Long showId = 1L;
        ShowDetail showDetail = new ShowDetail();

        when(mongoShowPort.findById(showId))
                .thenReturn(Optional.empty());

        when(tvMazeShowPort.getShow(showId))
                .thenReturn(showDetail);

        when(mongoShowPort.save(showDetail))
                .thenReturn(showDetail);

        ShowDetail result = service.getShow(showId);

        assertEquals(showDetail, result);

        verify(mongoShowPort).findById(showId);
        verify(tvMazeShowPort).getShow(showId);
        verify(mongoShowPort).save(showDetail);
    }

    @Test
    void shouldNotSaveShowWhenTvMazeFails() {

        Long showId = 1L;
        ServiceException exception =
                new ServiceException(
                        "TV Maze service error",
                        new RuntimeException("TV Maze unavailable"));

        when(mongoShowPort.findById(showId))
                .thenReturn(Optional.empty());

        when(tvMazeShowPort.getShow(showId))
                .thenThrow(exception);

        assertThrows(
                ServiceException.class,
                () -> service.getShow(showId));

        verify(mongoShowPort).findById(showId);
        verify(tvMazeShowPort).getShow(showId);
        verify(mongoShowPort, never()).save(org.mockito.ArgumentMatchers.any());
    }
}
