package performance;


import AI.Test.AgentTest.AgentTest;
import AI.resources.Contact;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 代理端测试类
 */
public class AgentPerf {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static Map<String, String> cookies;
    static String token;

    @BeforeMethod
    public void login(){
        String time = System.currentTimeMillis() +"";
        Map<String, String> map = new LinkedHashMap<String,String>();
        map.put("t",time);
        map.put("username",Contact.TEST_YICHIO_NAME);
        map.put("password",Contact.TEST_YICHIO_PASSWORD);
        map.put("uuid", UUID.randomUUID().toString());
        map.put("captcha",Contact.TEST_CAPTCHA);


        Response response = given()
                .contentType("application/json")
                .body(map)
                .post("https://test-wemp.yichio.com/console/sys/admin/login")
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
    }

    //充电桩部署
    @Test(threadPoolSize = 1, invocationCount = 200,  timeOut = 1000000)
    public void equipmentList() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("token",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://test-wemp.yichio.com/console/equipment/pile/list?page=1&limit=10&includeDescendant=true&deleted=false&t=" + System.currentTimeMillis())
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //用户列表
    @Test(threadPoolSize = 1, invocationCount = 200,  timeOut = 1000000)
    public void userList() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("token",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://test-wemp.yichio.com/console/biz/user/list?page=1&limit=10&t=" + System.currentTimeMillis())
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }
}
