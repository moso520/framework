package AI.Test;

import AI.resources.Contact;
import AI.resources.Info;
import AI.util.HttpUtil;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 代理端用户报告模块测试类
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserReportTest {
    private static final Logger logger = LoggerFactory.getLogger(UserReportTest.class);
    static Map<String, String> cookies;

    @BeforeAll
    static void login() {
        cookies = HttpUtil.login(Contact.USER_NAME, Contact.PASSWORD);
        Response response = HttpUtil.post("", Info.USER_INFO);
        assertEquals(Contact.USER_NAME,response.path("data.account"));
        Allure.addAttachment("login results", response.asString());


    }

    @DisplayName("list All User Report")
    @Test
    void listAllUser() {
        Response listResponse = HttpUtil.get(Info.LIST_ALL_USER);
        Allure.addAttachment("list All User Report", listResponse.asString());
    }

    @DisplayName("list Cooperation User Report")
    @Test
    void listCoopUsers() {
        Response listResponse = HttpUtil.get(Info.LIST_CO_USER);
        Allure.addAttachment("list Cooperation User Report", listResponse.asString());
    }

    @DisplayName("list Owe User Report")
    @Test
    void listOweUsers() {
        Response listResponse = HttpUtil.get(Info.LIST_OWE_USER);
        Allure.addAttachment("list Owe User Report", listResponse.asString());
    }

    @DisplayName("list New User Report")
    @Test
    void listNewUsers() {
        Response listResponse = HttpUtil.get(Info.LIST_NEW_USER);
        Allure.addAttachment("list New User Report", listResponse.asString());
    }

    @DisplayName("list Exchange Time Report")
    @Test
    void listExchange() {
        Response listResponse = HttpUtil.get(Info.LIST_EXCHANGE_USER);
        Allure.addAttachment("list Exchange Time Report", listResponse.asString());
    }


}
