package pl.kszpakowski.bikeramp.api.stats;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StatsControllerTest {

    @Value("${local.server.port}")
    private int serverPort;

    @Test
    public void whenRequestGET_pathStatsWeekly_thenOK() {
        given()
                .port(serverPort)
                .contentType(ContentType.JSON)
                .request(Method.GET, "stats/weekly")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void whenRequestGET_pathStatsMonthly_thenOK() {
        given()
                .port(serverPort)
                .contentType(ContentType.JSON)
                .request(Method.GET, "stats/monthly")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());
    }
}