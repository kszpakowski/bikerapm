package pl.kszpakowski.bikeramp.api.trips;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kszpakowski.bikeramp.api.trips.dto.CreateTripRequest;
import pl.kszpakowski.bikeramp.api.trips.dto.Trip;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripsController {

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody CreateTripRequest request) {
        log.debug("Handling create trip request");
        Trip trip = new Trip("1");
        return ResponseEntity.created(URI.create(String.format("/trips/%s", trip.getId()))).body(trip);
    }
}
