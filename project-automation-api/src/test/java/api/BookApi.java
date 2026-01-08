package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookApi {

    private static final String BASE = "/BookStore/v1";

    public Response listBooks() {
        return given()
                .get(BASE + "/Books");
    }

    public Response rentBooks(String userId, String token, String[] isbns) {

        StringBuilder json = new StringBuilder("{\"userId\":\"" + userId + "\",\"collectionOfIsbns\":[");

        for (String isbn : isbns) {
            json.append("{\"isbn\":\"").append(isbn).append("\"},");
        }
        json.deleteCharAt(json.length() - 1);
        json.append("]}");

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(json.toString())
                .post(BASE + "/Books");
    }
}
