package mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.matching.ContainsPattern;
import com.github.tomakehurst.wiremock.matching.PathPattern;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WireMockStubTest {
    @Test
    public void stubTest() throws IOException {
        //config wiremock
        WireMockServer wireMockServer = new WireMockServer(
            wireMockConfig()
                    .port(8888)
                    .extensions(new ResponseTemplateTransformer(true))

        );
        wireMockServer.start();
        System.out.println();
        //client配置
        configureFor("localhost",8888);

        //stub设置
        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(
                        aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("hello Mars!")
                )

        );

        stubFor(get(anyUrl())
                .withQueryParam("site", new ContainsPattern("ceshiren.com")).atPriority(100)
                .willReturn(
                        aResponse().withBody("site={{request.query.site}}")
                ));

        stubFor(get(urlPathEqualTo("/a/b/c"))
                .withQueryParam("id", equalTo("1")).atPriority(1)
                .willReturn(aResponse()
                        .withBody("files/{{request.query.id}}.png")
//                        .withBody("token:{{request.query.id}}")
                )
        );

        stubFor(get(urlMatching("/ceshiren.*"))
                .willReturn(aResponse().proxiedFrom("https://ceshiren.com/"))
        );

        stubFor(get(urlMatching("/s\\?.*"))
                .withQueryParam("wd", new ContainsPattern("Moso"))
                .willReturn(aResponse().proxiedFrom("https://www.baidu.com/"))
        );



        System.in.read();


        WireMock.reset();

// Finish doing stuff

        wireMockServer.stop();





    }
}
