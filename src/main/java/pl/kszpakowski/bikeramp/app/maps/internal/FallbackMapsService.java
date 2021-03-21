package pl.kszpakowski.bikeramp.app.maps.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.kszpakowski.bikeramp.app.maps.Distance;
import pl.kszpakowski.bikeramp.app.maps.MapsService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Primary
@RequiredArgsConstructor
class FallbackMapsService implements MapsService {

    private final GoogleMapsService googleMapsService;
    private final OSMapsService osMapsService;

    @Override
    public Distance getDistance(String startAddress, String destinationAddress) {

        try {
            return CompletableFuture.supplyAsync(() -> googleMapsService.getDistance(startAddress, destinationAddress))
                    .exceptionally((e) -> googleMapsService.getDistance(startAddress, destinationAddress))
                    .exceptionally((e) -> osMapsService.getDistance(startAddress, destinationAddress))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Error while getting distance", e);
        }
    }
}
