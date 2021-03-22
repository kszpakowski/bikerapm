package pl.kszpakowski.bikeramp.api.stats;

import org.springframework.stereotype.Component;
import pl.kszpakowski.bikeramp.api.stats.dto.MonthlyStatsDto;
import pl.kszpakowski.bikeramp.api.stats.dto.WeeklyStatsDto;
import pl.kszpakowski.bikeramp.app.stats.MonthlyStatistics;
import pl.kszpakowski.bikeramp.app.stats.WeeklyStatistics;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.vo.Price;

import java.time.format.DateTimeFormatter;

@Component
public class StatsMapper {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("LLLL, dd");

    MonthlyStatsDto map(MonthlyStatistics stats) {
        return MonthlyStatsDto.builder()
                .day(stats.getDay().format(DATE_TIME_FORMATTER))
                .avgPrice(formatPrice(stats.getAvgPrice()))
                .avgRide(formatDistance(stats.getAvgRide()))
                .totalDistance(formatDistance(stats.getTotalDistance()))
                .build();
    }

    WeeklyStatsDto map(WeeklyStatistics stats){
        return WeeklyStatsDto.builder()
                .distance(formatDistance(stats.getTotalDistance()))
                .price(formatPrice(stats.getTotalPrice()))
                .build();
    }

    private String formatDistance(Distance distance) {
        return String.format("%skm", distance.getValue());
    }

    private String formatPrice(Price price){
        return String.format("%sPLN", price.getValue());
    }
}
