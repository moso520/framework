package AI.util;

import AI.Test.AgentTest;
import AI.resources.Contact;
import AI.resources.Info;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static  Map<String, String> cookies;
    public static Map<String, String> login(String userName, String password) {

        String body = "{\n" +
                "   \"userName\": \"" + userName + "\",\n" +
                "   \"password\": \"" + password + "\"" +
                "}\n";
        cookies = given().log().all()
                .contentType("application/json")
                .body(body)
                .post(Info.LOGIN)
                .then()
                .log().body()
                .extract()
                .response().getCookies();
        Assert.assertNotNull(cookies);
        logger.info(cookies.toString());
        return cookies;
    }

    public static Response get(Map<String, Object> map, String url){
        Response response = given().log().all()
                .when()
                .params(map)
                .cookies(cookies)
                .get(url)
                .then()
                .extract()
                .response();
        assertAll("check response info",
                ()->assertEquals("200",response.path("code").toString()),
                ()->assertEquals("SUCCESS",response.path("message"))
        );
        logger.info(response.toString());
        return response;
    }

    public static Response get(String url){
        Response response = given().log().all()
                .when()
                .cookies(cookies)
                .get(url)
                .then()
                .extract()
                .response();
        assertAll("check response info",
                ()->assertEquals("200",response.path("code").toString()),
                ()->assertEquals("SUCCESS",response.path("message"))
        );
        logger.info(response.toString());
        return response;
    }

    public static Response post(Object object, String url, String contentType){
        Response response = given().log().all()
                .contentType(contentType)
                .when()
                .body(object)
                .cookies(cookies)
                .post(url)
                .then()
                .extract()
                .response();
        assertAll("check response info",
                ()->assertEquals("200",response.path("code").toString()),
                ()->assertEquals("SUCCESS",response.path("message"))
        );
        logger.info(response.toString());
        return response;
    }

    public static Response post(Object object, String url){
        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .body(object)
                .cookies(cookies)
                .post(url)
                .then()
                .extract()
                .response();
        logger.info(response.toString());
        assertAll("check response info",
                ()->assertEquals("200",response.path("code").toString()),
                ()->assertEquals("SUCCESS",response.path("message"))
        );
        return response;
    }
}
