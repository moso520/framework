package AI.util;

import AI.Test.AgentTest;
import AI.resources.Info;
import AI.resources.InfoApp;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppHttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static Map<String, String> cookies = new HashMap<String, String>();


    public static Response get(Map<String, Object> map, String url){
        cookies.put("a","a");
        Response response = given().log().all()
                .when()
                .params(map)
                .cookies(cookies)
                .get(url)
                .then()
                .extract()
                .response();
//        assertAll("check response info",
//                ()->assertEquals("200",response.path("code").toString()),
//                ()->assertEquals("SUCCESS",response.path("message"))
//        );
        logger.info(response.toString());
        return response;
    }


    public static Response get(String url){
        cookies.put("a","a");
        Response response = given().log().all()
                .when()
                .cookies(cookies)
                .get(url)
                .then()
                .extract()
                .response();
//        assertAll("check response info",
//                ()->assertEquals("200",response.path("code").toString()),
//                ()->assertEquals("SUCCESS",response.path("message"))
//        );
        logger.info(response.toString());
        return response;
    }


    public static Response post(Object object, String url, String contentType){
        cookies.put("a","a");
        Response response = given().log().all()
                .contentType(contentType)
                .when()
                .body(object)
                .cookies(cookies)
                .post(url)
                .then()
                .extract()
                .response();
//        assertAll("check response info",
//                ()->assertEquals("200",response.path("code").toString()),
//                ()->assertEquals("SUCCESS",response.path("message"))
//        );
        logger.info(response.toString());
        return response;
    }

    public static Response post(Object object, String url){
        cookies.put("a","a");
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
//        assertAll("check response info",
//                ()->assertEquals("200",response.path("code").toString()),
//                ()->assertEquals("SUCCESS",response.path("message"))
//        );
        return response;
    }


    public static Response loginApp() {

        String body = "{\n" +
                "    \"objectId\": \"13989898989c06bd4ea7fb34\",\n" +
                "    \"phone\": \"13989898989\",\n" +
                "    \"city\": \"深圳市\",\n" +
                "    \"deviceId\": \"70f059078a0a97225240a99395adc54\"\n" +
                "}";
        Response response = given().log().all()
                .contentType("application/json")
                .body(body)
                .post(InfoApp.LOGIN)
                .then()
                .log().body()
                .extract()
                .response();
        logger.info(response.toString());
        return response;
    }
}
