package pl.kszpakowski.bikeramp.api.trips;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kszpakowski.bikeramp.api.trips.dto.CreateTripRequest;
import pl.kszpakowski.bikeramp.api.trips.dto.TripDto;
import pl.kszpakowski.bikeramp.app.trip.CreateTripCommand;
import pl.kszpakowski.bikeramp.app.trip.TripAppService;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripsController {

    private final TripAppService tripAppService;
    private final TripMapper mapper;

    @ApiOperation(value = "Create trip", notes="This endpoint logs the trip and automatically calculates the distance between start and destination addresses.")
    @PostMapping
    public ResponseEntity<TripDto> createTrip(@RequestBody CreateTripRequest request) {
        log.debug("Handling create trip request");
        CreateTripCommand createTripCommand = CreateTripCommand.builder()
                .startAddress(request.getStartAddress())
                .destinationAddress(request.getDestinationAddress())
                .date(request.getDate())
                .price(request.getPrice())
                .build();

        TripDto dto = mapper.map(tripAppService.createTrip(createTripCommand));
        return ResponseEntity.created(URI.create(String.format("/trips/%s", dto.getId()))).body(dto);
    }
}
