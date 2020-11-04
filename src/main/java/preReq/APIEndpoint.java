package preReq;

import general.EnvGlobals;
import io.restassured.response.Response;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.IsNot.not;

public class APIEndpoint {
    public APIEndpoint(){}

//    **********************************************    API Calls   **********************************************

    public static Response saveAsSystems(String name, String randName, int systemId) throws SQLException {
        EnvGlobals.response =
                given()
                        .headers("Authorization", "exampleAuth", "Content-Type", "content", "referer", "reference")
                        .body(RequestPayloads.saveAsSystem(name, randName, systemId))
//                        .log().all()
                .when()
                        .post("/save-as-system")
                .then()
//                        .log().all()
                        .assertThat().statusCode(200)
                        .body("system", hasKey("id"))
                .extract()
                        .response();

        return EnvGlobals.response;
    }

    public static Response getSystems() {
        EnvGlobals.response =
                given()
                        .headers("Authorization", "exampleAuth", "referer", "reference")
//                        .log().all()
                .when()
                        .get("/app/systems")
                .then()
//                        .log().all()
                        .assertThat().statusCode(200).and()
                .extract()
                        .response();

        return EnvGlobals.response;
    }


}
