package pl.kszpakowski.bikeramp.app.stats;

import org.springframework.stereotype.Component;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

@Component
class DateUtils {

    Instant firstDayOfAWeek(Instant date) {
        return LocalDate.ofInstant(date, ZoneId.systemDefault())
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC);
    }

    Instant firstDayOfAMonth(Instant date) {
        return LocalDate.ofInstant(date, ZoneId.systemDefault())
                .with(TemporalAdjusters.firstDayOfMonth())
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC);
    }
}
