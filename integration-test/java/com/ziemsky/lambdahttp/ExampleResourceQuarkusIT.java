package com.ziemsky.lambdahttp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ExampleResourceQuarkusIT {

    @Test
    void testHelloEndpoint() {
        given()
        .when()
            .get("/helloIntegrationTest")
        .then()
            .statusCode(200)
            .body(is("Hello integration test."));
    }

}