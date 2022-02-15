import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Main {
    public static void main(String[] args) {
        Response response = given()
                .config(restAssuredConfig())
                .get("http://google.com");
        System.out.println("response.statusCode()=" + response.statusCode());
    }

    private static RestAssuredConfig restAssuredConfig() {
        int connectTimeoutMilliseconds = 5000;

        return RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", connectTimeoutMilliseconds)
                        .setParam("http.connection.timeout", connectTimeoutMilliseconds));
    }
}
