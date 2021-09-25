
package AI.Test.APPTest;


import AI.resources.InfoApp;
import AI.resources.JsonBody;
import AI.util.AppHttpUtil;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmsTest {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailTest.class);
    Map<String, String> cookies = new HashMap<String, String>();

    @DisplayName("send Sms")
    @Test
    void sendSms() {
        Response response = AppHttpUtil.post(JsonBody.sendSms,InfoApp.SEND_SMS);
        Assert.assertEquals(response.path("suc").toString(),"true");
        Allure.addAttachment("send Sms", response.asString());
    }

    @DisplayName("check Sms")
    @Test
    void checkSms() {
        Response response = AppHttpUtil.post(JsonBody.checkSms,InfoApp.CHECK_SMS);
        Assert.assertEquals(response.path("suc").toString(),"true");
        Allure.addAttachment("check Sms", response.asString());
    }

}
