package backend.spec;

import common.CredentialsConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static backend.spec.CustomAllureRestListener.withCustomTemplates;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.URI;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class Specification {

    private static final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    private static final String baseUri = config.BaseUri();

    private static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(JSON)
                .addHeader("type-shop", "rzd")
                .build()
                .filters(
                        new RequestLoggingFilter(URI),
                        new RequestLoggingFilter(BODY),
                        new ResponseLoggingFilter(BODY)
                );
    }

    private static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(
                        anyOf(
                                is(200),
                                is(201)
                        ))
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    private static void installSpec(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    public static void installSpecification200() {
        installSpec(requestSpec(), responseSpec200());

        if (RestAssured.filters().isEmpty()) {
            RestAssured.filters(withCustomTemplates());
        }
    }
}
