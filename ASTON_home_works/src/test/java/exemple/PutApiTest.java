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

public class PutApiTest {

    private static final String BASE_URI = "https://postman-echo.com";
    private static final String PUT_ENDPOINT = "/put";

    private ResponseSpecification putResponseSpec = expect().log().all()
            .statusCode(HttpStatus.SC_OK)
            .and().body("headers", notNullValue())
            .and().body("files", notNullValue())
            .and().body("form", notNullValue());

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void putApi() {
        String dataString = "Hello, Wold!";
        given().log().all()
                .contentType(ContentType.TEXT)
                .body(dataString)
                .expect().spec(putResponseSpec)
                .when()
                .put(PUT_ENDPOINT)
                .then().log().all()
                .and().body("args", notNullValue())
                .and().body("data", equalTo(dataString))
                .and().body("json", nullValue())
                .and().body("url", equalTo(BASE_URI + PUT_ENDPOINT));
    }

    @Test
    public void putApiJson() {
        given().log().all()
                .contentType(ContentType.JSON)
                .body("{\"test2\" : \"value2\"}")
                .expect().spec(putResponseSpec)
                .when()
                .put(PUT_ENDPOINT)
                .then().log().all()
                .and().body("args", notNullValue())
                .and().body("data.test2", equalTo("value2"))
                .and().body("url", equalTo(BASE_URI + PUT_ENDPOINT))
                .and().body("json.test2", equalTo("value2"));
    }
}
