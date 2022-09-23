package performance;


import AI.Test.AgentTest.AgentTest;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 代理端测试类
 */
public class TCPPerf {
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
                .post("https://wemp.yichio.com/console/sys/admin/login")
                .then()
                .log().body()
                .extract()
                .response().path("token");
        Assert.assertNotNull(tokenStr);
        return tokenStr;
    }

    //开仓
//    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
    @Test
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
                .post("https://wemp.yichio.com/console/asset/cabinet/instr/turnOn")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //启用舱门
//    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
    @Test
    public void enableSlotTest() {

        String body = "{\"remark\": \"仓门故障恢复\", \"cabinetId\": \"307988096627438888\", \"slotSeq\": 2}";
        Map<String, String> token = new LinkedHashMap<String,String>();
        token.put("token",tokenStr);

        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .body(body)
                .headers(token)
                .post("https://wemp.yichio.com/console/asset/cabinet/instr/enableSlot")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }



    //禁用舱门
//    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
    @Test
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
                .post("https://wemp.yichio.com/console/asset/cabinet/instr/disableSlot")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //切换网关
//    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
    @Test
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
                .post("https://wemp.yichio.com/console/asset/cabinet/instr/modifyServerAddress")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }

    //更新二维码
//    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
    @Test
    public void updateQrCodeTest() {

        String body = "{\"t\": 1658137652420, \"id\": \"6012419465472\", \"type\": \"SLOT\", \"targetId\": \"420662171820175360\"}";
        Map<String, String> token = new LinkedHashMap<String,String>();
        token.put("token",tokenStr);

        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .body(body)
                .headers(token)
                .post("https://wemp.yichio.com/console/asset/qrCode/update")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());
    }


    //get Cabinet
//    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
    @Test
    public void  getCabinetTest(){
        Map<String, String> token = new LinkedHashMap<String,String>();
        token.put("token",tokenStr);

        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .headers(token)
                .get("https://wemp.yichio.com/console/asset/cabinet/runtime/info/421066265294614528")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());

    }

    //get Battery
//    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
    @Test
    public void  getBatteryTest(){
        Map<String, String> token = new LinkedHashMap<String,String>();
        token.put("token",tokenStr);

        Response response = given().log().all()
                .contentType("application/json")
                .when()
                .headers(token)
                .get("https://wemp.yichio.com/console/asset/battery/runtime/info/421073434341617664")
                .then()
                .extract()
                .response();
        assertEquals("0",response.path("code").toString());
        Allure.addAttachment("list:", response.asString());

    }
}