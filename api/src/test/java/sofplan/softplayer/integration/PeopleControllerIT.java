package sofplan.softplayer.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import sofplan.softplayer.domain.repository.PeopleRepository;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.yml")
public class PeopleControllerIT {
    private String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiaWJvcCIsImV4cCI6MTYwNzM1NDM1M30.W3RK4lFhCt-fRLMKCAy80tlN_UFXx9VTZATUnQ0nmXXfdPznJzXX2PdVGFqAxcJCHfEMAOD9HxxRA8-S31Iw1Q";

    @LocalServerPort
    private int port;

    @Autowired
    private PeopleRepository peopleRepository;

    @BeforeEach
    void setUp() {
        // Habilita os logs quando falha o teste
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/v1/admin/people";
    }

    @Test
    void should_return_status_200_when_find_people() {
        given()
            .auth()
            .oauth2(token)
            .accept(ContentType.JSON)
        .when()
            .get()
        .then()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    void should_return_status_200_when_find_a_people() {
        given()
            .pathParam("peopleId", 1)
            .auth()
            .oauth2(token)
            .accept(ContentType.JSON)
        .when()
            .get("/{peopleId}")
        .then()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    void should_return_status_401_when_find_a_people_not_found() {
        given()
            .pathParam("peopleId", 99999)
            .auth()
            .oauth2(token)
            .accept(ContentType.JSON)
        .when()
            .get("/{peopleId}")
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void should_return_status_204_when_update_people() {
        given()
            .pathParam("peopleId", 1)
            .auth()
            .oauth2(token)
            .body("{\"email\": \"bibop@gmail.com\"}")
            .accept(ContentType.JSON)
        .when()
            .delete("/{peopleId}")
        .then()
            .statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    void should_return_status_204_when_delete_people() {
        given()
            .pathParam("peopleId", 1)
            .auth()
            .oauth2(token)
            .accept(ContentType.JSON)
        .when()
            .put("/{peopleId}")
            .then()
            .statusCode(HttpStatus.NO_CONTENT.value());
    }
}
