package performance;


import AI.Test.AgentTest.AgentTest;
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
 * 商家端测试类
 */
public class WeAgentPerf {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static Map<String, String> cookies;
    static String token;

    @BeforeMethod
    public void login(){
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("username","13168789729");
        map.put("password","12345678");
        map.put("loginedMonth",true);


        Response response = given()
                .contentType("application/json")
                .body(map)
                .post("https://wemp.ycyd.aihuandian.net/console/sys/login")
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

    //换电订单
//    @Test(threadPoolSize = 1, invocationCount = 200,  timeOut = 1000000)
    @Test
    public void userOrderList() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("token",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://wemp.ycyd.aihuandian.net/console/biz/changeOrder/list?page=1&limit=10")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //电池列表
//    @Test(threadPoolSize = 1, invocationCount = 200,  timeOut = 1000000)
    @Test
    public void batteryList() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("token",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://wemp.ycyd.aihuandian.net/console/asset/battery/list?keyword=&page=1&limit=10")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //用户列表
//    @Test(threadPoolSize = 1, invocationCount = 200,  timeOut = 1000000)
    @Test
    public void userList() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("token",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://wemp.ycyd.aihuandian.net/console/biz/user/place/rent/contract/list?keyword=&page=1&limit=10")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //商家信息
//    @Test(threadPoolSize = 1, invocationCount = 200,  timeOut = 1000000)
    @Test
    public void profitList() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("token",token);
        Response response = given()
                .when()
                .headers(cookie)
                .post("https://wemp.ycyd.aihuandian.net/console/operator/order/report/profit/summary")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //首页信息
//    @Test(threadPoolSize = 1, invocationCount = 200,  timeOut = 1000000)
    @Test
    public void menuList() {

        Map<String, String> cookie = new LinkedHashMap<String,String>();
        cookie.put("token",token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get("https://wemp.ycyd.aihuandian.net/console/sys/menu/nav")
                .then()
                .extract()
                .response();
        assertEquals("0",responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }
}