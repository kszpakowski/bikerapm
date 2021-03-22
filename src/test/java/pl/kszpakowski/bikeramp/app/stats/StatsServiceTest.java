package pl.kszpakowski.bikeramp.app.stats;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pl.kszpakowski.bikeramp.app.trip.Trip;
import pl.kszpakowski.bikeramp.app.trip.TripService;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.vo.Price;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
class StatsServiceTest {

    @Test
    void shouldComputeWeeklyStats() {

        //given
        Trip trip1 = Trip.builder()
                .distance(Distance.of(3L))
                .price(Price.of(BigDecimal.valueOf(2L)))
                .build();

        Trip trip2 = Trip.builder()
                .distance(Distance.of(4L))
                .price(Price.of(BigDecimal.valueOf(2L)))
                .build();

        TripService tripService = mock(TripService.class);
        when(tripService.getTrips(any())).thenReturn(List.of(trip1, trip2));
        StatsService statsService = new StatsService(tripService, new DateUtils());

        //when
        WeeklyStatistics weeklyStats = statsService.getWeeklyStats();

        //then
        log.info(weeklyStats.toString());
        assertNotNull(weeklyStats);
        assertEquals(7, weeklyStats.getTotalDistance().getValue());
        assertEquals(BigDecimal.valueOf(4), weeklyStats.getTotalPrice().getValue());
    }

    @Test
    void shouldComputeMonthlyStats() {

        //given
        Trip trip1 = Trip.builder()
                .date(Instant.parse("2021-03-21T11:00:00Z"))
                .distance(Distance.of(3L))
                .price(Price.of(BigDecimal.valueOf(2L)))
                .build();

        Trip trip2 = Trip.builder()
                .date(Instant.parse("2021-03-21T12:00:00Z"))
                .distance(Distance.of(5L))
                .price(Price.of(BigDecimal.valueOf(2L)))
                .build();

        Trip trip3 = Trip.builder()
                .date(Instant.parse("2021-03-24T11:00:00Z"))
                .distance(Distance.of(2L))
                .price(Price.of(BigDecimal.valueOf(2L)))
                .build();

        TripService tripService = mock(TripService.class);
        when(tripService.getTrips(any())).thenReturn(List.of(trip1, trip2, trip3));
        StatsService statsService = new StatsService(tripService, new DateUtils());

        //when
        Collection<MonthlyStatistics> monthlyStatistics = statsService.getMonthlyStats();

        //then
        log.info(monthlyStatistics.toString());
        assertNotNull(monthlyStatistics);
        assertThat(monthlyStatistics, hasItems(
                MonthlyStatistics.builder()
                    .day(LocalDate.of(2021,3,24))
                    .totalDistance(Distance.of(2L))
                    .totalPrice(Price.of(BigDecimal.valueOf(2)))
                    .totalRides(1)
                    .build(),
                MonthlyStatistics.builder()
                        .day(LocalDate.of(2021,3,21))
                        .totalDistance(Distance.of(8L))
                        .totalPrice(Price.of(BigDecimal.valueOf(4)))
                        .totalRides(2)
                        .build()
        ));
    }

}