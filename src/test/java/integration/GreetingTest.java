package integration;

import hello.Application;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class GreetingTest extends FluentTest {
    @Value("${local.server.port}")
    private int port;

    private DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
    private WebDriver driver = new PhantomJSDriver(capabilities);

    @Override
    public WebDriver getDefaultDriver() {
        return driver;
    }

    @Test
    public void testGetIndex() {
        goTo("http://127.0.0.1:" + port + "/greeting?name=Sam");
        assertThat(pageSource()).contains("Hello, Sam!");

        goTo("http://127.0.0.1:" + port + "/greeting?name=Bob");
        assertThat(pageSource()).contains("Hello, Bob!");
    }
}
