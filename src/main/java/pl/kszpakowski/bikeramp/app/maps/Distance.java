package pl.kszpakowski.bikeramp.app.maps;

import lombok.Data;

@Data
public class Distance {
    private final Long value;

    public static Distance of(Long distance){
        return new Distance(distance);
    }
}
