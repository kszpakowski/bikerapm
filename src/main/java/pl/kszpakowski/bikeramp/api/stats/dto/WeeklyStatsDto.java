package pl.kszpakowski.bikeramp.api.stats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WeeklyStatsDto {

    @ApiModelProperty(name = "Total distance", example = "40km")
    @JsonProperty("total_distance")
    private final String distance;

    @ApiModelProperty(name = "Total price", example = "49.75PLN")
    @JsonProperty("total_price")
    private final String price;
}
