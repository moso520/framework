package AI.Test.YCYDTest;


import AI.Test.AgentTest.AgentTest;
import AI.resources.Contact;
import AI.resources.Info;
import AI.resources.InfoApp;
import AI.resources.JsonBody;
import AI.util.AppHttpUtil;
import AI.util.HttpUtil;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 逸池测试类
 */
public class YCYDTest {
    private static final Logger logger = LoggerFactory.getLogger(AgentTest.class);
    static Map<String, String> cookies;
    static String token;

    @BeforeMethod
    public void login(){
        Response response = HttpUtil.loginYCYD();
        Assert.assertEquals(response.path("msg"),"success");
        Allure.addAttachment("login results", response.asString());
    }

    /**
     * 充电桩部署
     */
    @Test()
    void equipmentList() {
        Response response = HttpUtil.getYCYD(Info.YI_EQUIPMENT);
        Assert.assertEquals(response.path("msg"),"success");
        Allure.addAttachment("get equipmentList", response.asString());
    }

    /**
     * 用户列表
     */
    @Test()
    public void userList() {
        Response response = HttpUtil.getYCYD(Info.YI_USER);
        Assert.assertEquals(response.path("msg"),"success");
        Allure.addAttachment("get equipmentList", response.asString());
    }

    /**
     * 搜用户
     */
    @Test()
    public void userSearch() throws UnsupportedEncodingException {
//        Response response = HttpUtil.getYCYD(Info.YI_USER+"&keyword="+java.net.URLEncoder.encode(Contact.PROD_YICHIO_SEARCH_USER,"UTF-8"));
        Response response = HttpUtil.getYCYD(Info.YI_USER+"&keyword="+Contact.PROD_YICHIO_SEARCH_USER);
        Assert.assertEquals(response.path("page.list[0].id"),Contact.PROD_YICHIO_TEST_USER_ID);
        Allure.addAttachment("get equipmentList", response.asString());
    }

    /**
     * 换电记录
     */
    @Test()
    public void changeOrder() {
        Response response = HttpUtil.getYCYD(Info.YI_CHANGE_ORDER);
        Assert.assertEquals(response.path("msg"),"success");
        Allure.addAttachment("get equipmentList", response.asString());
    }

    /**
     * 消费记录
     */
    @Test()
    public void walletBalanceDetail() {
        Response response = HttpUtil.getYCYD(Info.YI_WALLET_BALANCE_DETAIL);
        Assert.assertEquals(response.path("msg"),"success");
        Allure.addAttachment("get equipmentList", response.asString());
    }

    /**
     * 用户钱包金额管理
     */
    @Test()
    public void walletAdjustTest() {
        //获取之前的钱包金额
        Float availableBalance = Float.parseFloat(HttpUtil.getYCYD(Info.YI_USER+"&keyword="+Contact.PROD_YICHIO_SEARCH_USER).path("page.list[0].availableBalance"));

        HashMap<String, Object> map = new HashMap<>();
        map.put("t",System.currentTimeMillis());
        map.put("userId",Contact.PROD_YICHIO_TEST_USER_ID);
        map.put("amount","1");
        map.put("type","1");
        map.put("remark","test");
        //增加1分钱
        Response responseIncrease = HttpUtil.postYCYD(map,Info.YI_ADJUST);
        assertAll("check response info",
                ()->assertEquals(responseIncrease.path("msg"),"success"),
                ()->assertEquals(availableBalance+0.01F,Float.parseFloat(
                        HttpUtil.getYCYD(Info.YI_USER+"&keyword="+Contact.PROD_YICHIO_SEARCH_USER).path("page.list[0].availableBalance"))));
        Allure.addAttachment("get equipmentList", responseIncrease.asString());


        //减少1分钱
        map.put("type","-1");
        Response responseDecrease = HttpUtil.postYCYD(map,Info.YI_ADJUST);
        assertAll("check response info",
                ()->assertEquals(responseIncrease.path("msg"),"success"),
                ()->assertEquals(availableBalance,Float.parseFloat(
                        HttpUtil.getYCYD(Info.YI_USER+"&keyword="+Contact.PROD_YICHIO_SEARCH_USER).path("page.list[0].availableBalance"))));
        Allure.addAttachment("get equipmentList", responseDecrease.asString());
    }


}
