package healthcare.api;

import healthcare.api.payload.AuthRequestPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {

    public static Response createToken(AuthRequestPayload authRequestPayload, String authRoute) {
        return given().contentType(ContentType.JSON)
                .body(authRequestPayload)
                .when()
                .post(authRoute);
    }
}
