package pl.kszpakowski.bikeramp.app.trip.internal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    private final BigDecimal value;

    public static Price of(BigDecimal value){
        return new Price(value);
    }
}
