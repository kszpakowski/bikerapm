package pl.kszpakowski.bikeramp.api.trips.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class CreateTripRequest {

    /*start_address	Start address in format: "Plac Europejski 2, Warszawa, Polska"
    destination_address	Destination address in format: "Plac Europejski 2, Warszawa, Polska"
    price	Package price in PLN
    date	Date of delivery*/

    @JsonProperty("start_address")
    private final String startAddress;

    @JsonProperty("destination_address")
    private final String destinationAddress;
    private final BigDecimal price;
    private final Instant date;

}
