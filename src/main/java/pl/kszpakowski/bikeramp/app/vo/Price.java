package pl.kszpakowski.bikeramp.app.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    private final BigDecimal value;

    public static Price of(BigDecimal value){
        return new Price(value);
    }

    public Price add(Price price){
        return new Price(this.value.add(price.value));
    }
}
