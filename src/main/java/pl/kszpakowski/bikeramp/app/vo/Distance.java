package pl.kszpakowski.bikeramp.app.vo;

import lombok.Data;

@Data
public class Distance {
    private final Long value;

    public static Distance of(Long distance) {
        return new Distance(distance);
    }

    public Distance add(Distance distance) {
        return new Distance(this.value + distance.getValue());

    }
}
