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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AgentTest {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static  Map<String, String> cookies;

    @BeforeAll
    static void login() {
        cookies = HttpUtil.login(Contact.USER_NAME, Contact.PASSWORD);
        Response response = HttpUtil.post("", Info.USER_INFO);
        assertEquals(Contact.USER_NAME,response.path("data.account"));
        Allure.addAttachment("login results", response.asString());


    }

    @DisplayName("list User Packages")
    @Test
    void listPackages() {
        Response listResponse = HttpUtil.get(Info.LIST_PACKAGE);
        Allure.addAttachment("list all Packages", listResponse.asString());
    }

    @DisplayName("list all users")
    @Test
    void listUsers() {
        Response listResponse = HttpUtil.get(Info.LIST_USER);
        Allure.addAttachment("list all users", listResponse.asString());
    }

    @DisplayName("list all provinces")
    @Test
    void listProvinces() {
        Response listResponse = HttpUtil.get(Info.LIST_PROVINCE);
        Allure.addAttachment("list all provinces", listResponse.asString());
    }

    @DisplayName("list all area for cabinetList")
    @Test
    void listCabineArea() {
        Response listResponse = HttpUtil.get(Info.LIST_AREA);
        Allure.addAttachment("list all area for cabinetList", listResponse.asString());
    }

    @DisplayName("list all city for cabinetList")
    @Test
    void listCabineCity() {
        Response listResponse = HttpUtil.get(Info.LIST_CITY);
        Allure.addAttachment("list all city for cabinetList", listResponse.asString());
    }


}