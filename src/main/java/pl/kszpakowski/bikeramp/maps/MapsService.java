package pl.kszpakowski.bikeramp.maps;

import pl.kszpakowski.bikeramp.app.vo.Distance;

public interface MapsService {

    Distance getDistance(String startAddress, String destinationAddress);
}
