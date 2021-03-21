package pl.kszpakowski.bikeramp.api.trips.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class TripDto {

    private final String id;
    private final long distance;
    private final BigDecimal price;
    private final Instant date;
}
