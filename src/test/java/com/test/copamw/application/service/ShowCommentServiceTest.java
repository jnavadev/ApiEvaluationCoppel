package com.test.copamw.application.service;

import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.domain.port.out.ShowCommentPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.test.copamw.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShowCommentServiceTest {

    @Mock
    private ShowCommentPort showCommentPort;

    private ShowCommentService service;

    @BeforeEach
    void setUp() {
        service = new ShowCommentService(showCommentPort);
    }

    @Test
    void shouldSaveComment() {

        ShowComment comment =
                new ShowComment(
                        SHOW_ID,
                        MESSAGE_MAX_RATING,
                        RATING
                );

        when(showCommentPort.save(comment))
                .thenReturn(comment);

        ShowComment result =
                service.saveComment(comment);

        assertEquals(comment, result);

        verify(showCommentPort).save(comment);
    }
}
