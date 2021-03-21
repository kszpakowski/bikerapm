package pl.kszpakowski.bikeramp.app.trip;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Getter
public class CreateTripCommand {

    private final String startAddress;
    private final String destinationAddress;
    private final BigDecimal price;
    private final Instant date;
}
