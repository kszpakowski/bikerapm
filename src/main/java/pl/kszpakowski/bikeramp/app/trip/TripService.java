package pl.kszpakowski.bikeramp.app.trip;

import java.time.Instant;
import java.util.Collection;

public interface TripService {

    Trip createTrip(CreateTripCommand command);
    Collection<Trip> getTrips(Instant after);
}
