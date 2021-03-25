package pl.kszpakowski.bikeramp.maps.osm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.maps.MapsService;

@Slf4j
@Service
public
class OSMapsService implements MapsService {
    @Override
    public Distance getDistance(String startAddress, String destinationAddress) {
        log.debug("Getting distance from {} to {} using Open Street Maps", startAddress, destinationAddress);
        return Distance.of(2L);
    }
}
