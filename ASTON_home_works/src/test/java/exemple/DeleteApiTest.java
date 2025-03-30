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

public class DeleteApiTest {
    private static final String BASE_URI = "https://postman-echo.com";
    private static final String DELETE_ENDPOINT = "/delete";

    private ResponseSpecification deleteResponseSpec = expect().log().all()
            .statusCode(HttpStatus.SC_OK)
            .and().body("headers", notNullValue())
            .and().body("files", notNullValue())
            .and().body("form", notNullValue())
            .and().body("args", notNullValue())
            .and().body("url", equalTo(BASE_URI + DELETE_ENDPOINT));

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void deleteApi() {
        String dataString = "Hello!";
        given().log().all()
                .contentType(ContentType.TEXT)
                .body(dataString)
                .expect().spec(deleteResponseSpec)
                .when()
                .delete(DELETE_ENDPOINT)
                .then().log().all()
                .and().body("data", equalTo(dataString))
                .and().body("json", nullValue());
    }

    @Test
    public void deleteApiJson() {
        given().log().all()
                .contentType(ContentType.JSON)
                .body("{\"test4\" : \"Point3\"}")
                .expect().spec(deleteResponseSpec)
                .when()
                .delete(DELETE_ENDPOINT)
                .then().log().all()
                .and().body("data.test4", equalTo("Point3"))
                .and().body("json.test4", equalTo("Point3"));
    }
}
