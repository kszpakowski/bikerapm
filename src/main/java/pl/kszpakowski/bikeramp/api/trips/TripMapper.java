package pl.kszpakowski.bikeramp.api.trips;

import org.springframework.stereotype.Component;
import pl.kszpakowski.bikeramp.api.trips.dto.TripDto;
import pl.kszpakowski.bikeramp.app.trip.Trip;

@Component
class TripMapper {

    public TripDto map(Trip trip) {
        return new TripDto(trip.getId(),
                trip.getDistance().getValue(),
                trip.getPrice().getValue(),
                trip.getDate());
    }
}
