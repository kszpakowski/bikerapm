package pl.kszpakowski.bikeramp.api.trips.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@ApiModel("Create new trip properties")
@Data
public class CreateTripRequest {

    @ApiModelProperty(value = "Start address in format: \"Plac Europejski 2, Warszawa, Polska\"", example = "Plac Europejski 2, Warszawa, Polska")
    @JsonProperty("start_address")
    private final String startAddress;

    @ApiModelProperty(value = "Destination address in format: \"Plac Europejski 2, Warszawa, Polska\"", example = "Plac Europejski 2, Warszawa, Polska")
    @JsonProperty("destination_address")
    private final String destinationAddress;

    @ApiModelProperty("Package price in PLN")
    private final BigDecimal price;

    @ApiModelProperty("Date of delivery")
    private final Instant date;

}
