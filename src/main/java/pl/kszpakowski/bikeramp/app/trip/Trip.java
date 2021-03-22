package pl.kszpakowski.bikeramp.app.trip;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.vo.Price;

import java.time.Instant;

@ToString
@Builder
@Getter
@Document
public class Trip {

    @Id
    private final String id;
    private final Distance distance;
    private final Price price;
    private final Instant date;
}

