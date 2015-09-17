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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
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
    public void testThymeleaf() {
        goTo("http://127.0.0.1:" + port + "/greeting?name=Sam");
        assertThat(pageSource()).contains("Hello, Sam!");

        goTo("http://127.0.0.1:" + port + "/greeting?name=Bob");
        assertThat(pageSource()).contains("Hello, Bob!");
    }

    @Test
    public void testJavascript() throws InterruptedException {
        goTo("http://127.0.0.1:" + port + "/greeting?name=Sam");
        Thread.sleep(1000); // There's probably a better way to wait for $(document).ready
        assertThat(pageSource()).contains("Hello from javascript!");
    }
}
