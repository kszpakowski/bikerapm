package pl.kszpakowski.bikeramp.app.stats;

import org.junit.jupiter.api.Test;
import pl.kszpakowski.bikeramp.app.trip.Trip;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.vo.Price;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class MonthlyStatisticsTest {


    @Test
    void shouldAddTrip() {
        //given
        Trip trip1 = Trip.builder()
                .date(Instant.parse("2021-03-21T11:00:00Z"))
                .distance(Distance.of(3L))
                .price(Price.of(BigDecimal.valueOf(2L)))
                .build();

        Trip trip2 = Trip.builder()
                .date(Instant.parse("2021-03-21T11:00:00Z"))
                .distance(Distance.of(5L))
                .price(Price.of(BigDecimal.valueOf(4L)))
                .build();

        MonthlyStatistics empty = MonthlyStatistics.empty();

        //when
        MonthlyStatistics monthlyStatistics = empty.addTrip(trip1);

        //then
        assertEquals(1, monthlyStatistics.getTotalRides());
        assertEquals(Distance.of(3L), monthlyStatistics.getAvgRide());
        assertEquals(Price.of(BigDecimal.valueOf(2)), monthlyStatistics.getAvgPrice());
        assertEquals(Distance.of(3L), monthlyStatistics.getTotalDistance());

        //and when
        MonthlyStatistics secondMonthlyStatistics = monthlyStatistics.addTrip(trip2);

        //then
        assertEquals(2, secondMonthlyStatistics.getTotalRides());
        assertEquals(Distance.of(4L), secondMonthlyStatistics.getAvgRide());
        assertEquals(Price.of(BigDecimal.valueOf(3)), secondMonthlyStatistics.getAvgPrice());
        assertEquals(Distance.of(8L), secondMonthlyStatistics.getTotalDistance());
        assertEquals(Price.of(BigDecimal.valueOf(6)), secondMonthlyStatistics.getTotalPrice());
    }

}