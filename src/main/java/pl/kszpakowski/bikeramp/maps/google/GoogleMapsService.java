package pl.kszpakowski.bikeramp.maps.google;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kszpakowski.bikeramp.app.vo.Distance;
import pl.kszpakowski.bikeramp.maps.MapsService;

import java.util.Arrays;


@Slf4j
@Service
@RequiredArgsConstructor
public class GoogleMapsService implements MapsService {

    private final GeoApiContext apiContext;

    @Override
    public Distance getDistance(String startAddress, String destinationAddress) {
        log.debug("Getting distance from {} to {} using Google Maps", startAddress, destinationAddress);

        try {
            DistanceMatrix distanceMatrix = DistanceMatrixApi.getDistanceMatrix(apiContext,
                    new String[]{startAddress},
                    new String[]{destinationAddress})
                    .await();

            return Arrays.stream(distanceMatrix.rows).findFirst()
                    .map(row -> row.elements[0].distance.inMeters)
                    .map(Distance::of)
                    .orElseThrow(() -> new RuntimeException("Unable to get distance"));
        } catch (Exception e) {
            log.warn("Unable to get distance from google Api", e);
            throw new RuntimeException("Unable to get distance", e);
        }


    }
}
