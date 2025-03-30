package exemple;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostApiTest {
    private static final String BASE_URI = "https://postman-echo.com";
    private static final String POST_ENDPOINT = "/post";
    private static final String BODY_JSON = "{\"test1\" : 1}";

    private ResponseSpecification postResponseSpec = expect().log().all()
            .statusCode(HttpStatus.SC_OK)
            .and().body("headers", notNullValue())
            .and().body("files", notNullValue())
            .and().body("form", notNullValue())
            .and().body("json", nullValue())
            .and().body("url", equalTo(BASE_URI + POST_ENDPOINT));

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void postApi() {
        String emptyString = "";
        given().log().all().body(emptyString)
                .expect().spec(postResponseSpec)
                .when()
                .post(POST_ENDPOINT)
                .then().log().all()
                .and().body("args", notNullValue())
                .and().body("data", equalTo(emptyString));
    }

    @Test
    public void postApiJson() {
        given().log().all().body(BODY_JSON)
                .expect().spec(postResponseSpec)
                .when()
                .post(POST_ENDPOINT)
                .then().log().all()
                .and().body("args", notNullValue())
                .and().body("data", equalTo(BODY_JSON));
    }
}
