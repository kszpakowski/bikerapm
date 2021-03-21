package pl.kszpakowski.bikeramp.api.trips;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;

class TripsControllerTest {

    @Test
    public void whenRequestPOST_thenOK() {
        when()
                .request("POST", "trips")
                .then()
                .statusCode(200);
    }
}