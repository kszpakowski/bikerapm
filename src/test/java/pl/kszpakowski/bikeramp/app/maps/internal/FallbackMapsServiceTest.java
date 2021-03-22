package pl.kszpakowski.bikeramp.app.maps.internal;

import org.junit.jupiter.api.Test;
import pl.kszpakowski.bikeramp.app.vo.Distance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FallbackMapsServiceTest {

    @Test
    void shouldReturnGoogleValueByDefault(){

        //given
        GoogleMapsService gms = mock(GoogleMapsService.class);
        Distance expectedDistance = Distance.of(1L);
        when(gms.getDistance(anyString(),anyString())).thenReturn(expectedDistance);

        OSMapsService osm = new OSMapsService();
        FallbackMapsService fms = new FallbackMapsService(gms,osm);

        //when
        Distance distance = fms.getDistance("A", "B");

        //then
        assertEquals(expectedDistance, distance);
    }

    @Test
    void shouldFallBackToOSMValueWhenGoogleIsNotAvailable(){

        //given
        GoogleMapsService gms = mock(GoogleMapsService.class);
        when(gms.getDistance(anyString(),anyString())).thenThrow(new RuntimeException("Unexpected"));

        OSMapsService osm = mock(OSMapsService.class);
        Distance expectedDistance = Distance.of(2L);
        when(osm.getDistance(anyString(),anyString())).thenReturn(expectedDistance);
        FallbackMapsService fms = new FallbackMapsService(gms,osm);

        //when
        Distance distance = fms.getDistance("A", "B");

        //then
        assertEquals(expectedDistance, distance);
    }

    @Test
    void shouldThrowExceptionWhenBothProvidersAreNotAvailable(){

        //given
        GoogleMapsService gms = mock(GoogleMapsService.class);
        when(gms.getDistance(anyString(),anyString())).thenThrow(new RuntimeException("GM is not available"));

        OSMapsService osm = mock(OSMapsService.class);
        when(osm.getDistance(anyString(),anyString())).thenThrow(new RuntimeException("OSM is not available"));
        FallbackMapsService fms = new FallbackMapsService(gms,osm);

        //then

        assertThrows(RuntimeException.class,() -> fms.getDistance("A", "B"));
    }
}