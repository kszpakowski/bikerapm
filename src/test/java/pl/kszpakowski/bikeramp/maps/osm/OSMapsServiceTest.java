package pl.kszpakowski.bikeramp.maps.osm;

import org.junit.jupiter.api.Test;
import pl.kszpakowski.bikeramp.app.vo.Distance;

import static org.junit.jupiter.api.Assertions.*;

class OSMapsServiceTest {

    @Test
    void shouldReturnFixedValueFromMockImpl(){
        //given
        OSMapsService osMapsService = new OSMapsService();

        //when
        Distance distance = osMapsService.getDistance("a", "b");

        //then
        assertEquals(Distance.of(2L),distance);
    }
}