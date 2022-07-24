package performance;


import AI.Test.AgentTest.AgentTest;
import AI.resources.Contact;
import AI.resources.Info;
import AI.resources.InfoYi;
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
    static String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc1ZlcmlmeVBob25lIjp0cnVlLCJ0aGlyZEFjY291bnRJZCI6IjM3MzY1NzQwODMyNjU0MTMxMiIsImV4cCI6MTY1ODY1NDYxMCwidXVpZCI6ImU0OWY3YTVjZGIwNjQwYTM4NzYyNTBmYzA4N2RkZjQzIiwidXNlcklkIjoiMzczNjU3NDA4MzA5NzY0MDk2In0.9UJ-eMJBIgV8tPAn3-eOQhifIiH30JofpwpVmbwYPhU";

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
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 100000000)
//    @Test()
    public void userStatus() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get(InfoYi.YI_HOST + "/ecommerce/rental/order/contract/time/countdown?limit=1000&queryStatuses=0%2C1%2C2")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //钱包信息
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 4000000)
//    @Test()
    public void walletDetail() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get(InfoYi.YI_HOST + "/charging/api/wallet/detail")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //换电桩列表
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
//    @Test()
    public void outletList() {
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("page", "1");
        map.put("limit","20");

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response response = given()
                .headers(cookie)
                .contentType("application/json")
                .body(map)
                .post(InfoYi.YI_HOST + "/merchant/outlet/list")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //换电记录
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
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
        Response response = given()
                .headers(cookie)
                .contentType("application/json")
                .body(map)
                .post(InfoYi.YI_HOST + "/charging/api/cabinet/order/list")
                .then()
                .log().body()
                .extract()
                .response();

        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //租赁合约
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
//    @Test()
    public void rentalList() {
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("page", "1");
        map.put("limit","10");


        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response response = given()
                .headers(cookie)
                .contentType("application/json")
                .body(map)
                .post(InfoYi.YI_HOST + "/ecommerce/rental/order/contract/current")
                .then()
                .log().body()
                .extract()
                .response();

        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //电柜列表
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
//    @Test()
    public void rangeList() {
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("latitude", "30.23696834676159");
        map.put("longitude","120.19938217413683");


        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response response = given()
                .headers(cookie)
                .contentType("application/json")
                .body(map)
                .post(InfoYi.YI_HOST + "/merchant/outlet/listInRange")
                .then()
                .log().body()
                .extract()
                .response();

        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //电池信息
    @Test(threadPoolSize = 3001     , invocationCount = 300,  timeOut = 1000000)
//    @Test()
    public void equipmentDetail() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("authorization",token);
        Response responseGet = given().log().all()
                .when()
                .headers(cookie)
                .get(InfoYi.YI_HOST + "/charging/api/equipment/user/all")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }
}
