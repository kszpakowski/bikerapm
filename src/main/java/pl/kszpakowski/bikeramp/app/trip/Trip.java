package pl.kszpakowski.bikeramp.app.trip;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.vo.Price;

import java.time.Instant;

@Builder
@Getter
@Document
public class Trip {

    @Id
    private String id;
    private Distance distance;
    private Price price;
    private Instant date;
}

