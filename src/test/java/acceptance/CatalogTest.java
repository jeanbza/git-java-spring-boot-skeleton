// Based on Mattias Severson's EXCELLENT post, 'Integration Testing a Spring Boot Application'
// http://www.jayway.com/2014/07/04/integration-testing-a-spring-boot-application/

package acceptance;

import com.jayway.restassured.RestAssured;
import hello.Application;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class CatalogTest {
    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testGreeting() {

        when()
            .get("/greeting").
        then().
            statusCode(HttpStatus.SC_OK).
            body("id", Matchers.is(1)).
            body("content", Matchers.is("Hello, World!"));
    }
}
