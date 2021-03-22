package pl.kszpakowski.bikeramp.app.stats;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kszpakowski.bikeramp.app.trip.Trip;
import pl.kszpakowski.bikeramp.app.trip.TripService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final TripService tripService;
    private final DateUtils dateUtils;

    public WeeklyStatistics getWeeklyStats() {
        Instant firstDayOfAWeek = dateUtils.firstDayOfAWeek(Instant.now());
        Collection<Trip> trips = tripService.getTrips(firstDayOfAWeek);

        return trips.stream()
                .reduce(WeeklyStatistics.empty(), (stats, trip) -> WeeklyStatistics.builder()
                        .totalDistance(stats.getTotalDistance().add(trip.getDistance()))
                        .totalPrice(stats.getTotalPrice().add(trip.getPrice()))
                        .build(), (statistics, statistics2) -> null);
    }

    public Collection<MonthlyStatistics> getMonthlyStats() {
        Instant firstDayOfAWeek = dateUtils.firstDayOfAMonth(Instant.now());
        Collection<Trip> trips = tripService.getTrips(firstDayOfAWeek);

        return trips.stream()
                .collect(Collectors.groupingBy(trip -> trip.getDate().truncatedTo(ChronoUnit.DAYS)))
                .values()
                .stream()
                .map(tripsOfDay -> tripsOfDay.stream().reduce(MonthlyStatistics.empty(), (stats, trip) -> MonthlyStatistics.builder()
                        .day(LocalDate.ofInstant(trip.getDate(), ZoneId.systemDefault()))
                        .totalDistance(stats.getTotalDistance().add(trip.getDistance()))
                        .totalPrice(stats.getTotalPrice().add(trip.getPrice()))
                        .totalRides(stats.getTotalRides()+1)
                        .build(),
                        (monthlyStatistics, monthlyStatistics2) -> null))
                .collect(Collectors.toList());
    }
}
