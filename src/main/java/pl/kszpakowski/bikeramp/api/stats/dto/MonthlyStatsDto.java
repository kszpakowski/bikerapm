package pl.kszpakowski.bikeramp.api.stats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class MonthlyStatsDto {

    @ApiModelProperty(name = "Day", example = "July, 4th")
    private final String day;

    @ApiModelProperty(name = "Total distance", example = "12km")
    @JsonProperty("total_distance")
    private final String totalDistance;

    @ApiModelProperty(name = "Average ride", example = "4km")
    @JsonProperty("avg_ride")
    private final String avgRide;

    @ApiModelProperty(name = "Average price", example = "22.75PLN")
    @JsonProperty("avg_price")
    private final String avgPrice;
}
