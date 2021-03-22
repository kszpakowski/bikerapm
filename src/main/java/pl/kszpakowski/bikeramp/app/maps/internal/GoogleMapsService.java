package pl.kszpakowski.bikeramp.app.maps.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.app.maps.MapsService;

@Slf4j
@Service
class GoogleMapsService implements MapsService {
    @Override
    public Distance getDistance(String startAddress, String destinationAddress) {
        log.debug("Getting distance from {} to {} using Google Maps", startAddress, destinationAddress);
        return new Distance(1L); //todo implement
    }
}
