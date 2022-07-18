package performance;


import AI.Test.AgentTest.AgentTest;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * tcp测试类
 */
public class WeAgentPerf {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static String tokenStr;

    @BeforeClass
    public static String login() {
        String userName = "13261616956";
        String password = "495E96059AFE031B55F30240F9AD47AF66081B9B";
        String body = "{\n" +
                "    \"captcha\": \"3bcd8\",\n" +
                "    \"password\": \"123456\",\n" +
                "    \"t\": 1653378196025,\n" +
                "    \"username\": \"eric\",\n" +
                "    \"uuid\": \"3e4d7a8a-d650-4489-88f7-45332cd3e34f\"\n" +
                "}";
        tokenStr = given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://test-wemp.yichio.com/console/sys/admin/login")
                .then()
                .log().body()
                .extract()
                .response().path("token");
        Assert.assertNotNull(tokenStr);
        return tokenStr;
    }

    //开仓
    @Test(threadPoolSize = 20, invocationCount = 2000,  timeOut = 1000000)
//    @Test()
    public void turnOnTest() {

        String body = "{\n" +
                "    \"remark\": \"电池故障取电\",\n" +
                "    \"cabinetId\": \"307988096627438888\",\n" +
                "    \"slotSeq\": 2,\n" +
                "    \"changeOrderId\": null\n" +
                "}";
        Map<String, String> token = new LinkedHashMap<String,String>();
        token.put("token",tokenStr);

        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .body(body)
                .headers(token)
                .post("https://test-wemp.yichio.com/console/asset/cabinet/instr/turnOn")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //禁用舱门
    @Test(threadPoolSize = 4, invocationCount = 200,  timeOut = 1000000)
//    @Test()
    public void disableSlotTest() {

        String body = "{\n" +
                "    \"remark\": \"其它原因:dadsadasdsa\",\n" +
                "    \"cabinetId\": \"307988096627438888\",\n" +
                "    \"slotSeq\": 6\n" +
                "}";
        Map<String, String> token = new LinkedHashMap<String,String>();
        token.put("token",tokenStr);

        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .body(body)
                .headers(token)
                .post("https://test-wemp.yichio.com/console/asset/cabinet/instr/disableSlot")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //切换网关
    @Test(threadPoolSize = 4, invocationCount = 2000,  timeOut = 1000000)
//    @Test()
    public void modifyServerAddressTest() {

        String body = "{\n" +
                "    \"ids\": [\n" +
                "        \"307988096627438888\"\n" +
                "    ],\n" +
                "    \"ip\": \"192.168.0.47\",\n" +
                "    \"port\": \"5097\"\n" +
                "}";
        Map<String, String> token = new LinkedHashMap<String,String>();
        token.put("token",tokenStr);

        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .body(body)
                .headers(token)
                .post("https://test-wemp.yichio.com/console/asset/cabinet/instr/modifyServerAddress")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }
}
