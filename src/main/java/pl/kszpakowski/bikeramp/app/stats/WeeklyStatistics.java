package pl.kszpakowski.bikeramp.app.stats;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.vo.Price;

import java.math.BigDecimal;

@Data
@Builder
@Getter
public class WeeklyStatistics {
    private final Distance totalDistance;
    private final Price totalPrice;

    public static WeeklyStatistics empty() {
        return new WeeklyStatistics(Distance.of(0L), Price.of(BigDecimal.ZERO));
    }
}
