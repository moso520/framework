package AI.Test;

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

/**
 * Devices测试类
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DevicesTest {
    private static final Logger logger = LoggerFactory.getLogger(DevicesTest.class);
     Map<String, String> cookies = new HashMap<String, String>();

    /**
     * 查看Cabinet的版本
     */
    @DisplayName("check Cabinet Version")
    @Test
    void checkCabinetVersion() {
        String body = "{\n" +
                "   \"agentId\":12,\n" +
                "   \"imei\":\"865501047918249\",\n" +
                "   \"cmd\":{\n" +
                "      \"c\": 81,\n" +
                "      \"param\": {\n" +
                "          \"cabinetsn\":\"H8ANBCB5L600112C\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
        Response response = AppHttpUtil.post(body,InfoApp.CHECK_DEVICES_VERSION);
        Assert.assertEquals(response.path("code").toString(),"109");
        Allure.addAttachment("check Cabinet Version", response.asString());
    }

    /**
     * 查看Imei的版本
     */
    @DisplayName("check Imei Version")
    @Test
    void checkImeiVersion() {
        String body = "{\n" +
                " \"agentId\":12,\n" +
                " \"imei\":\"865501047918249\",\n" +
                " \"cmd\":{\n" +
                " \t\"c\":42,\n" +
                " \t\"param\":{\n" +
                " \t\t\n" +
                " \t}\n" +
                " }\n" +
                "}";
        Response response = AppHttpUtil.post(body,InfoApp.CHECK_DEVICES_VERSION);
        Assert.assertEquals(response.path("code").toString(),"109");
        Allure.addAttachment("check Imei Version", response.asString());
    }
    /**
     * 关闭Cabinetsn
     */
    @DisplayName("disable Cabinetsn")
    @Test
    void disableCabinetsn() {
        String body = "{\n" +
                "   \"imei\":\"865501047918249\",\n" +
                "   \"agentId\":\"90\",\n" +
                "   \"cmd\":{\n" +
                "      \"c\": 75,\n" +
                "      \"param\": {\n" +
                "          \"action\":\"1\",\n" +
                "          \"cabinetsn\":\"H8ANBCB5L600112C\",\n" +
                "          \"opendoor\":\"10\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
        Response response = AppHttpUtil.post(body,InfoApp.CHECK_DEVICES_VERSION);
        Assert.assertEquals(response.path("code").toString(),"109");
        Allure.addAttachment("disable Cabinetsn", response.asString());
    }
    /**
     * 打开Imei
     */
    @DisplayName("open Imei")
    @Test
    void openImei() {
        String body = "{\n" +
                "\t\"imei\":\"865501047918249\",\n" +
                "\t\"agentId\":\"12\",\n" +
                "\t\"cmd\":{\n" +
                "\t\t\"c\":69,\n" +
                "\t\t\"param\":{\n" +
                "\t\t\t\"action\":1,\n" +
                "\t\t\t\"opendoor\":2,\n" +
                "\t\t\t\"tasktoken\":\"123456\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        Response response = AppHttpUtil.post(body,InfoApp.CHECK_DEVICES_VERSION);
        Assert.assertEquals(response.path("code").toString(),"109");
        Allure.addAttachment("open Imei", response.asString());
    }

}
