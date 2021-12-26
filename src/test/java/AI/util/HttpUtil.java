package AI.util;

import AI.Test.AgentTest;
import AI.resources.Contact;
import AI.resources.Info;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static  Map<String, String> cookies;
    static String token;
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

    public static String loginYi(String user, String password, String captcha){
        String time = System.currentTimeMillis() +"";
        Map<String, String> map = new LinkedHashMap<String,String>();
        map.put("t",time);
        map.put("username",user);
        map.put("password",password);
        map.put("uuid", UUID.randomUUID().toString());
        map.put("captcha",captcha);


        Response response = given()
                .contentType("application/json")
                .body(map)
                .post(Info.YI_LOGIN)
                .then()
                .log().body()
                .extract()
                .response();
        assertAll("check response info",
                ()->assertEquals("0",response.path("code").toString()),
                ()->assertNotNull(response.path("token").toString()),
                ()->assertEquals("success",response.path("msg"))
        );
        token = response.path("token").toString();
        System.out.println(token);
        Allure.addAttachment("login results-->token:", token);
        return token;
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
                ()->assertEquals("SUCCESS",response.path("message").toString())
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
