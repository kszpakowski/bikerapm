package pl.kszpakowski.bikeramp.app.stats;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DateUtilsTest {

    private final DateUtils dateUtils  = new DateUtils();

    @Test
    void shouldReturnFirstDayOfAWeek(){
        //given
        Instant date = Instant.parse("2021-03-21T11:00:00Z");

        //when
        Instant firstDayOfAWeek = dateUtils.firstDayOfAWeek(date);

        //then
        log.info(firstDayOfAWeek.toString());
        assertEquals(Instant.parse("2021-03-15T00:00:00Z"), firstDayOfAWeek);
    }

    @Test
    void shouldReturnFirstDayOfAMonth(){
        //given
        Instant date = Instant.parse("2021-03-21T11:00:00Z");

        //when
        Instant firstDayOfAMonth = dateUtils.firstDayOfAMonth(date);

        //then
        assertEquals(Instant.parse("2021-03-01T00:00:00Z"), firstDayOfAMonth);
    }

}