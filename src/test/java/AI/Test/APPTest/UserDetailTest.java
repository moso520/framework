package AI.Test.APPTest;

import AI.resources.Contact;
import AI.resources.Info;
import AI.resources.InfoApp;
import AI.resources.JsonBody;
import AI.util.AppHttpUtil;
import AI.util.HttpUtil;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * APP测试类
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDetailTest {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailTest.class);
     Map<String, String> cookies = new HashMap<String, String>();

    @DisplayName("login App")
    @Test
    void loginApp() {
        Response response = AppHttpUtil.loginApp();
        Assert.assertEquals(response.path("data.message"),"success");
        Allure.addAttachment("login results", response.asString());
    }

    @DisplayName("get User Detail")
    @Test
    void getUserDetail() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",InfoApp.USER_ID);
        Response response = AppHttpUtil.get(map,InfoApp.USER_DETAIL);
        Assert.assertEquals(response.path("suc").toString(),"true");
        Allure.addAttachment("get User Detail", response.asString());
    }

    @DisplayName("upload Basic Info")
    @Test
    void uploadBasicInfo() {
        Response response = AppHttpUtil.post(JsonBody.uploadBasicInfo,InfoApp.UPLOAD_BASIC_INFO);
        Assert.assertEquals(response.path("suc").toString(),"true");
        Allure.addAttachment("upload Basic Info", response.asString());
    }

    @DisplayName("get Cabinet List")
    @Test
    void getCabinetList() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",InfoApp.USER_ID);
        map.put("lat","22.52840785367011");
        map.put("lng","113.94402757287025");
        Response response = AppHttpUtil.get(map,InfoApp.CABINET_LIST);
        Assert.assertEquals(response.path("suc").toString(),"true");
        Allure.addAttachment("get Cabinet List", response.asString());
    }

    @DisplayName("group Grcode")
    @Test
    void groupGrcode() {
        Response response = AppHttpUtil.post(JsonBody.groupGrcode,InfoApp.GROUP_GRCODE);
        Assert.assertEquals(response.path("suc").toString(),"true");
        Allure.addAttachment("group Grcode", response.asString());
    }

    @DisplayName("get Deposit Amount")
    @Test
    void depositAmount() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("areaCode","440304");
        Response response = AppHttpUtil.get(map,InfoApp.DEPOSIT_AMOUNT);
        Assert.assertEquals(response.path("suc").toString(),"true");
        Allure.addAttachment("get Deposit Amount", response.asString());
    }

    @DisplayName("submit Certification")
    @Test
    void submitCertification() {
        Response response = AppHttpUtil.post(JsonBody.submitCertification,InfoApp.SUBMIT_CERTIFICATION);
        Assert.assertEquals(response.path("suc").toString(),"false");
        Allure.addAttachment("submit Certification", response.asString());
    }

    @DisplayName("submit SWAP")
    @Test
    void swap() {
        Response response = AppHttpUtil.post(JsonBody.swapCabine,InfoApp.SWAP);
        String s = response.asString();
        logger.info(s);
        Assert.assertEquals(response.path("suc").toString(),"false");
        Allure.addAttachment("submit Certification", response.asString());
    }


}
