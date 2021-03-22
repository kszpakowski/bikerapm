package pl.kszpakowski.bikeramp.app.maps;

import pl.kszpakowski.bikeramp.app.vo.Distance;

public interface MapsService {

    Distance getDistance(String startAddress, String destinationAddress);
}
