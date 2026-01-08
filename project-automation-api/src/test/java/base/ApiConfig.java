package base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class ApiConfig {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://demoqa.com";
    }
}
