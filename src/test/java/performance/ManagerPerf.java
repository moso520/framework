package performance;


import AI.Test.AgentTest.AgentTest;
import AI.resources.Contact;
import AI.resources.Info;
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
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 代理端测试类
 */
public class ManagerPerf {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static Map<String, String> cookies;
    static String token;

    @BeforeClass
    public static Map<String, String> login() {
        String userName = "13261616956";
        String password = "495E96059AFE031B55F30240F9AD47AF66081B9B";
        String body = "{\n" +
                "   \"username\": \"" + userName + "\",\n" +
                "   \"password\": \"" + password + "\"" +
                "}\n";
        cookies = given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://app.aihuandian.net/platform/permission/user/login")
                .then()
                .log().body()
                .extract()
                .response().getCookies();
        Assert.assertNotNull(cookies);
        return cookies;
    }

    /**
     * threadPoolSize线程数
     * invocationCount执行次数
     * timeOut时间内需要执行完成，单位是ms
     * 如果在测试环境，需要修改app.aihuandian.net为测试环境域名，上面的login也需要替换
     */
    @Test(threadPoolSize = 4, invocationCount = 4,  timeOut = 50000)
    public void  performanceTest(){
        Response response = given().log().all()
                .when()
                .cookies(cookies)
                .get("https://172.20.146.157:8183/platform/record/exchangeBattery/v2?countPerPage=50&city=&state=&startTime=&endTime=&userId=157&msg=&curPage=0")
                .then()
                .extract()
                .response();
        assertEquals("true",response.path("suc").toString());
        Allure.addAttachment("list:", response.asString());
        System.out.println(response);
    }


}
