package com.ziemsky.lambdahttp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
@ToString
@EqualsAndHashCode
public class ExampleResource {

    @GET
    @Path("/helloIntegrationTest")
    public String helloIntegrationTest() {
        return "Hello integration test.";
    }

    @GET
    @Path("/helloUnitTest")
    public String helloUnitTest() {
        return "Hello unit test.";
    }
}
