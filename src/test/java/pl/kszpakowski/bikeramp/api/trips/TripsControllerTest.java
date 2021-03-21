package pl.kszpakowski.bikeramp.api.trips;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import pl.kszpakowski.bikeramp.api.trips.dto.CreateTripRequest;

import java.math.BigDecimal;
import java.time.Instant;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TripsControllerTest {

    @Value("${local.server.port}")
    private int serverPort;

    @Test
    public void whenRequestPOST_thenOK() {
        given()
                .port(serverPort)
                .contentType(ContentType.JSON)
                .body(new CreateTripRequest(
                        "a",
                        "b",
                        BigDecimal.valueOf(75),
                        Instant.now()))
                .request(Method.POST, "trips")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", notNullValue())
                .body("distance", equalTo(1))
                .body("price", equalTo(75));
    }
}