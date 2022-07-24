package performance;


import AI.Test.AgentTest.AgentTest;
import AI.resources.Contact;
import AI.resources.InfoYi;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 管理端测试类
 */
public class YiManagerPerf {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static Map<String, String> cookies;
    static String token;

    @BeforeMethod
    public void login() {
        String time = System.currentTimeMillis() + "";
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("t", time);
        map.put("username", Contact.TEST_YICHIO_NAME);
        map.put("password", Contact.TEST_YICHIO_PASSWORD);
        map.put("uuid", UUID.randomUUID().toString());
        map.put("captcha", Contact.TEST_CAPTCHA);


        Response response = given()
                .contentType("application/json")
                .body(map)
                .post(InfoYi.YI_HOST + "/console/sys/admin/login")
                .then()
                .log().body()
                .extract()
                .response();
        assertAll("check response info",
                () -> assertEquals("0", response.path("code").toString()),
                () -> assertNotNull(response.path("token").toString()),
                () -> assertEquals("success", response.path("msg"))
        );
        token = response.path("token").toString();
        System.out.println(token);
        Allure.addAttachment("login results-->token:", token);
    }

    //电池列表
    @Test(threadPoolSize = 1, invocationCount = 300,  timeOut = 100000000)
//    @Test
    public void batteryList() {

        Map<String, String> cookie = new LinkedHashMap<String, String>();
        cookie.put("token", token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get(InfoYi.YI_HOST + "/console/asset/battery/list?page=1&limit=10&keyword=&status=&bizId=&includeDescendant=true&t=" + System.currentTimeMillis())
                .then()
                .extract()
                .response();
        assertEquals("0", responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }


    //充电桩部署
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
//    @Test
    public void equipmentList() {

        Map<String, String> cookie = new LinkedHashMap<String, String>();
        cookie.put("token", token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get(InfoYi.YI_HOST + "/console/equipment/pile/list?page=1&limit=10&includeDescendant=true&deleted=false&t=" + System.currentTimeMillis())
                .then()
                .extract()
                .response();
        assertEquals("0", responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //用户列表
    @Test(threadPoolSize = 100, invocationCount = 300, timeOut = 1000000)
//    @Test
    public void userList() {

        Map<String, String> cookie = new LinkedHashMap<String, String>();
        cookie.put("token", token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get(InfoYi.YI_HOST + "/console/biz/user/list?page=1&limit=10&t=" + System.currentTimeMillis())
                .then()
                .extract()
                .response();
        assertEquals("0", responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //租赁合约管理
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
//    @Test
    public void descendantsList() {

        Map<String, String> cookie = new LinkedHashMap<String, String>();
        cookie.put("token", token);
        Response responseGet = given()
                .when()
                .headers(cookie)
                .get(InfoYi.YI_HOST + "/console/merchants/business/descendants/list?page=1&limit=20&includeSelf=true&t=" + System.currentTimeMillis())
                .then()
                .extract()
                .response();
        assertEquals("0", responseGet.path("code").toString());
        Allure.addAttachment("list:", responseGet.asString());
    }

    //租赁合约update
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
//    @Test
    public void update(){
        Map<String, String> cookie = new LinkedHashMap<String, String>();
        cookie.put("token", token);
        String time = System.currentTimeMillis() +"";
        Map<String, String> map = new LinkedHashMap<String,String>();
        map.put("t",time);
        map.put("contractId","422397470677344256");
        map.put("expireDate","2023-08-01 00:00:00");


        Response response = given()
                .contentType("application/json")
                .headers(cookie)
                .body(map)
                .post(InfoYi.YI_HOST + "/console/merchants/contract/rent/update")
                .then()
                .log().body()
                .extract()
                .response();
        assertAll("check response info",
                ()->assertEquals("0",response.path("code").toString()),
                ()->assertEquals("成功",response.path("msg"))
        );
    }

    //门店管理
    @Test(threadPoolSize = 300, invocationCount = 300,  timeOut = 1000000)
//    @Test
    public void outletList() {

        Map<String, String> cookie = new LinkedHashMap<String, String>();
        cookie.put("token", token);
        String time = System.currentTimeMillis() +"";
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("t",time);
        map.put("keyword","");

        Response response = given()
                .contentType("application/json")
                .headers(cookie)
                .body(map)
                .post(InfoYi.YI_HOST + "/console/merchants/outlet/b/list")
                .then()
                .log().body()
                .extract()
                .response();
        assertAll("check response info",
                ()->assertEquals("0",response.path("code").toString()),
                ()->assertEquals("成功",response.path("msg"))
        );
    }


}
