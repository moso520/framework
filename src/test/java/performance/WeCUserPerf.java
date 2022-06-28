package performance;


import AI.Test.AgentTest.AgentTest;
import AI.resources.Contact;
import AI.resources.Info;
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
public class WeCUserPerf {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static Map<String, String> cookies;
    static String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc1ZlcmlmeVBob25lIjp0cnVlLCJ0aGlyZEFjY291bnRJZCI6IjM3MzY1NzQwODMyNjU0MTMxMiIsImV4cCI6MTY1NjUzOTkxMiwidXVpZCI6IjdlMGVkZjFiMDA2YTQ3YWE4ZTE2Yzg4YzZlMTkwMDhjIiwidXNlcklkIjoiMzczNjU3NDA4MzA5NzY0MDk2In0.RIZn-N3PzScxYCrfbtlpA8kcHxDQpIj7AtzK_X3hk84";

//    @BeforeMethod
//    public void login(){
//        String time = System.currentTimeMillis() +"";
//        Map<String, String> map = new LinkedHashMap<String,String>();
//        map.put("t",time);
//        map.put("username",Contact.TEST_YICHIO_NAME);
//        map.put("password",Contact.TEST_YICHIO_PASSWORD);
//        map.put("uuid", UUID.randomUUID().toString());
//        map.put("captcha",Contact.TEST_CAPTCHA);
//
//
//        Response response = given()
//                .contentType("application/json")
//                .body(map)
//                .post("https://test-wemp.yichio.com/console/sys/admin/login")
//                .then()
//                .log().body()
//                .extract()
//                .response();
//        assertAll("check response info",
//                ()->assertEquals("0",response.path("code").toString()),
//                ()->assertNotNull(response.path("token").toString()),
//                ()->assertEquals("success",response.path("msg"))
//        );
//        token = response.path("token").toString();
//        System.out.println(token);
//        Allure.addAttachment("login results-->token:", token);
//    }

    //当前用户状态
//    @Test(threadPoolSize = 4, invocationCount = 200,  timeOut = 1000000)
    @Test()
    public void userStatus() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://wemp.ycyd.aihuandian.net/ecommerce/rental/order/contract/time/countdown?limit=1000&queryStatuses=0%2C1%2C2")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //钱包信息
    @Test(threadPoolSize = 4, invocationCount = 200,  timeOut = 1000000)
//    @Test()
    public void walletDetail() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://wemp.ycyd.aihuandian.net/charging/api/wallet/detail")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //换电桩列表
    @Test(threadPoolSize = 4, invocationCount = 200,  timeOut = 1000000)
//    @Test()
    public void outletList() {
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("page", "1");
        map.put("limit","20");

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response responseGet = given()
                .headers(cookie)
                .contentType("application/json")
                .body(map)
                .post("https://wemp.ycyd.aihuandian.net/merchant/outlet/list")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //换电记录
    @Test(threadPoolSize = 4, invocationCount = 200,  timeOut = 1000000)
//    @Test()
    public void orderList() {
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("status",0);
        map.put("startTime", "2022-06-01 00:00:00");
        map.put("endTime","2022-06-30 23:59:59");
        map.put("page", "1");
        map.put("limit","20");


        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response responseGet = given()
                .headers(cookie)
                .contentType("application/json")
                .body(map)
                .post("https://wemp.ycyd.aihuandian.net/charging/api/cabinet/order/list")
                .then()
                .log().body()
                .extract()
                .response();

        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

}
