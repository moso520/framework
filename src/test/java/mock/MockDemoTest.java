package mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class MockDemoTest {

    @Test
    void mockDemo() throws IOException {
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8888)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();

// Do some stuff

        WireMock.reset();

// Finish doing stuff

//        wireMockServer.stop();

        System.in.read();
    }

}
