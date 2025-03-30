package exemple;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetApiTest {

    private static final String BASE_URI = "https://postman-echo.com";
    private static final String GET_ENDPOINT = "/get";
    private static final String FIRST_PARAMETER_NAME = "foo1";
    private static final String FIRST_PARAMETER_VALUE = "bar1";
    private static final String SECOND_PARAMETER_NAME = "foo2";
    private static final String SECOND_PARAMETER_VALUE = "bar2";

    private ResponseSpecification getResponseSpec = expect().log().all()
            .statusCode(HttpStatus.SC_OK)
            .and().body("headers.host", equalTo("postman-echo.com"))
            .and().body("headers.x-request-start", notNullValue())
            .and().body("headers.connection", equalTo("close"))
            .and().body("headers.x-forwarded-proto", equalTo("https"))
            .and().body("headers.x-forwarded-port", equalTo("443"))
            .and().body("headers.x-amzn-trace-id", notNullValue())
            .and().body("headers.accept", equalTo("*/*"))
            .and().body("headers.user-agent", notNullValue());

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void getApi() {
        given().log().all()
                .expect().spec(getResponseSpec)
                .when()
                .get(GET_ENDPOINT)
                .then().log().all()
                .body("url", equalTo(BASE_URI + GET_ENDPOINT));
    }

    @Test
    public void getApiQuery() {
        given().log().all()
                .params(Map.of(FIRST_PARAMETER_NAME, FIRST_PARAMETER_VALUE,
                        SECOND_PARAMETER_NAME, SECOND_PARAMETER_VALUE))
                .expect().spec(getResponseSpec)
                .when()
                .get(GET_ENDPOINT)
                .then().log().all()
                .body("args." + FIRST_PARAMETER_NAME, equalTo(FIRST_PARAMETER_VALUE))
                .and().body("args." + SECOND_PARAMETER_NAME, equalTo(SECOND_PARAMETER_VALUE))
                .and().body("url", equalTo(
                        String.format("%s%s?%s=%s&%s=%s", BASE_URI, GET_ENDPOINT, FIRST_PARAMETER_NAME, FIRST_PARAMETER_VALUE, SECOND_PARAMETER_NAME, SECOND_PARAMETER_VALUE)));
    }

    @Test
    public void getApiQuery1() {
        given().log().all()
                .params(Map.of(FIRST_PARAMETER_NAME, FIRST_PARAMETER_VALUE))
                .expect().spec(getResponseSpec)
                .when()
                .get(GET_ENDPOINT)
                .then().log().all()
                .body("args." + FIRST_PARAMETER_NAME, equalTo(FIRST_PARAMETER_VALUE))
                .and().body("url", equalTo(
                        String.format("%s%s?%s=%s", BASE_URI, GET_ENDPOINT, FIRST_PARAMETER_NAME, FIRST_PARAMETER_VALUE)));
    }

}
