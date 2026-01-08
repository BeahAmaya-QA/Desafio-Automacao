package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AccountUser {

    private static final String BASE = "/Account/v1";

    static {
        RestAssured.baseURI = "https://demoqa.com";
    }

    public Response createUser(String username, String password) {
        return given()
                .contentType("application/json")
                .body("{\"userName\":\"" + username + "\", \"password\":\"" + password + "\"}")
                .post(BASE + "/User");
    }

    public Response generateToken(String username, String password) {
        return given()
                .contentType("application/json")
                .body("{\"userName\":\"" + username + "\", \"password\":\"" + password + "\"}")
                .post(BASE + "/GenerateToken");
    }

    public Response checkAuthorized(String username, String password) {
        return given()
                .contentType("application/json")
                .body("{\"userName\":\"" + username + "\", \"password\":\"" + password + "\"}")
                .post(BASE + "/Authorized");
    }

    public Response getUser(String userId, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .get(BASE + "/User/" + userId);
    }
}
