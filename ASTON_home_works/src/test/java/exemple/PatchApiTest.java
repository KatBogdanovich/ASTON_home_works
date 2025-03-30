package exemple;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PatchApiTest {

    private static final String BASE_URI = "https://postman-echo.com";
    private static final String PATCH_ENDPOINT = "/patch";

    private ResponseSpecification patchResponseSpec = expect().log().all()
            .statusCode(HttpStatus.SC_OK)
            .and().body("headers", notNullValue())
            .and().body("files", notNullValue())
            .and().body("form", notNullValue())
            .and().body("args", notNullValue())
            .and().body("url", equalTo(BASE_URI + PATCH_ENDPOINT));

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void patchApi() {
        String dataString = "Hello!";
        given().log().all()
                .contentType(ContentType.TEXT)
                .body(dataString)
                .expect().spec(patchResponseSpec)
                .when()
                .patch(PATCH_ENDPOINT)
                .then().log().all()
                .and().body("data", equalTo(dataString))
                .and().body("json", nullValue());
    }

    @Test
    public void patchApiJson() {
        given().log().all()
                .contentType(ContentType.JSON)
                .body("{\"test3\" : \"Point\"}")
                .expect().spec(patchResponseSpec)
                .when()
                .patch(PATCH_ENDPOINT)
                .then().log().all()
                .and().body("data.test3", equalTo("Point"))
                .and().body("json.test3", equalTo("Point"));
    }
}
