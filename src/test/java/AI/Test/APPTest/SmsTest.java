
package AI.Test.APPTest;


import AI.Test.BasicTest;
import AI.TestData.TestData;
import AI.resources.InfoApp;
import AI.resources.JsonBody;
import AI.util.AppHttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class SmsTest extends BasicTest {
    private  JSONObject jsonObject;
    public  String name_class = this.getClass().getName();
    private static final Logger logger = LoggerFactory.getLogger(UserDetailTest.class);
    Map<String, String> cookies = new HashMap<String, String>();


//    @DisplayName("send Sms")
//    @Test
//    void sendSms() {
//        Response response = AppHttpUtil.post(JsonBody.sendSms,InfoApp.SEND_SMS);
//        Assert.assertEquals(response.path("suc").toString(),"true");
//        Allure.addAttachment("send Sms", response.asString());
//    }

    @DisplayName("check Sms")
    @Test
    @ParameterizedTest
    @MethodSource("getYamlList")
    void checkSms(TestData testData) {

//        jsonObject = (JSONObject) testData.(new Exception().getStackTrace()[0].getMethodName());
//        createUser = (User)data_user.createUserData(new Exception().getStackTrace()[0].getMethodName());

        Response response = AppHttpUtil.post(JsonBody.checkSms,InfoApp.CHECK_SMS);
        Assert.assertEquals(response.path("suc").toString(),"true");
//        objectId = response.path("data.objectId");
        Allure.addAttachment("check Sms", response.asString());
    }

//
//    static Stream<TestData> data() throws IOException {
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        TestData testData = mapper.readValue(
//                new File("src/test/java/AI/resources/testdata.yaml"),
//                TestData.class
//        );
//        return Stream.of(testData);
//    }

   /* public Object[][] yamlDataMethod() {
        List<Map<String, Object>> yamlList = getYamlList();
        Object[][] files = new Object[yamlList.size()][];
        for (int i = 0; i < yamlList.size(); i++) {
            files[i] = new Object[]{yamlList.get(i)};
        }
        return files;
    }
*/















}
