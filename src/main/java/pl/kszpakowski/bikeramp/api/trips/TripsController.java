package pl.kszpakowski.bikeramp.api.trips;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripsController {

    @PostMapping
    public void createTrip(){
      log.debug("Handling create trip request");
    }
}