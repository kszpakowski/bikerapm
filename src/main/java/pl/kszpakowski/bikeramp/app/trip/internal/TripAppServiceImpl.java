package pl.kszpakowski.bikeramp.app.trip.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.maps.MapsService;
import pl.kszpakowski.bikeramp.app.trip.CreateTripCommand;
import pl.kszpakowski.bikeramp.app.vo.Price;
import pl.kszpakowski.bikeramp.app.trip.Trip;
import pl.kszpakowski.bikeramp.app.trip.TripService;

import java.time.Instant;
import java.util.Collection;

@Service
@RequiredArgsConstructor
class TripAppServiceImpl implements TripService {

    private final MapsService mapsService;
    private final TripRepository tripRepository;

    @Override
    public Trip createTrip(CreateTripCommand command) {

        Distance distance = mapsService.getDistance(command.getStartAddress(), command.getDestinationAddress());
        Trip trip = Trip.builder()
                .distance(distance)
                .price(Price.of(command.getPrice()))
                .date(command.getDate())
                .build();

        return tripRepository.save(trip);
    }

    @Override
    public Collection<Trip> getTrips(Instant after) {
        return tripRepository.findAllByDateAfter(after);
    }
}
