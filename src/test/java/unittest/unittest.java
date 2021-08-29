package unittest;

import app.page.BasePage;
import app.page.TeamPage;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import util.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.data.DataManager;
import util.data.PageObjectMethod;
import wechat.services.TokenFilter;
import wechat.util.HttpUtil;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class unittest  {


    //行为流
    //搜索股票
    @Test
    public void search() throws IOException {
        DataManager dataManager = new DataManager();
        PageObjectMethod pageObjectMethod = dataManager.getDataElements();
        System.out.println();
//        parseSteps("search","/com.xueqiu.app/page/SearchPage.yaml");

    }
    //取消返回
    @Test
    public void cancel(){
        Response response = given().log().all()
                .when()
                .get("http://127.0.0.1:8888/html/response")
                .then()
                .extract()
                .response();

        System.out.println();
        JSONObject jsonObject = JSONObject.parseObject(response.path("html.body"));

        System.out.println();
//        parseSteps("cancel","/com.xueqiu.app/page/SearchPage.yaml");

    }


}
