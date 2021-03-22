package pl.kszpakowski.bikeramp.app.stats;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kszpakowski.bikeramp.app.trip.Trip;
import pl.kszpakowski.bikeramp.app.trip.TripService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatsService {

    private final TripService tripService;
    private final DateUtils dateUtils;

    public WeeklyStatistics getWeeklyStats() {
        Instant firstDayOfAWeek = dateUtils.firstDayOfAWeek(Instant.now());
        Collection<Trip> trips = tripService.getTrips(firstDayOfAWeek);

        return trips.stream()
                .reduce(WeeklyStatistics.empty(),
                        WeeklyStatistics::addTrip,
                        (statistics, statistics2) -> null);
    }

    public Collection<MonthlyStatistics> getMonthlyStats() {
        Instant firstDayOfAWeek = dateUtils.firstDayOfAMonth(Instant.now());
        Collection<Trip> trips = tripService.getTrips(firstDayOfAWeek);

        Collection<List<Trip>> tripsGroupedByDay = trips.stream()
                .collect(Collectors.groupingBy(trip -> trip.getDate().truncatedTo(ChronoUnit.DAYS)))
                .values();

        return tripsGroupedByDay
                .stream()
                .map(tripsOfDay -> tripsOfDay.stream().reduce(MonthlyStatistics.empty(),
                        MonthlyStatistics::addTrip,
                        (monthlyStatistics, monthlyStatistics2) -> null))
                .peek(stat -> log.debug("Mapped stats {}", stat))
                .collect(Collectors.toList());
    }
}
