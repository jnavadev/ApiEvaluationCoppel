package com.test.copamw.infrastructure.adapter.in.rest.mapper;

import com.test.copamw.domain.model.Show;
import com.test.copamw.domain.model.ShowComment;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ShowRespDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static com.test.copamw.constants.TestConstants.*;

class ShowRespMapperTest {

    private final ShowRespMapper mapper =
            Mappers.getMapper(ShowRespMapper.class);

    @Test
    void shouldRespOK() {

        ShowComment comment = new ShowComment(
                SHOW_ID,
                MESSAGE_MAX_RATING,
                RATING
        );

        Show show = new Show(
                SHOW_ID,
                SHOW_NAME,
                CHANNEL_ABC,
                SHOW_SUMMARY,
                List.of(GENRE_ACTION, GENRE_ADVENTURE)
        );

        show.setComments(List.of(comment));

        ShowRespDto response = mapper.toResponse(show);

        assertNotNull(response);
        assertEquals(show.getId(), response.id());
        assertEquals(show.getName(), response.name());
        assertEquals(show.getChannel(), response.channel());
        assertEquals(show.getSummary(), response.summary());
        assertEquals(show.getGenres(), response.genres());

        assertNotNull(response.comments());
        assertEquals(1, response.comments().size());
        assertEquals(
                comment.getComment(),
                response.comments().get(0).comment()
        );
        assertEquals(
                comment.getRating(),
                response.comments().get(0).rating()
        );
    }
}
