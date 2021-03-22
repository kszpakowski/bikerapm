package pl.kszpakowski.bikeramp.app.stats;

import lombok.Builder;
import lombok.Data;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.vo.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Data
@Builder
public class MonthlyStatistics {

    private final LocalDate day;
    private final Distance totalDistance;
    private final Price totalPrice;
    private final long totalRides;

    public static MonthlyStatistics empty() {
        return new MonthlyStatistics(null,
                Distance.of(0L),
                Price.of(BigDecimal.ZERO),
                0);
    }

    public Distance getAvgRide() {
        return Distance.of(totalDistance.getValue() / totalRides);
    }

    public Price getAvgPrice() {
        return Price.of(totalPrice.getValue().divide(BigDecimal.valueOf(totalRides), RoundingMode.HALF_UP));
    }
}
