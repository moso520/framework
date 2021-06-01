package unittest;

import app.page.BasePage;
import app.page.TeamPage;
import util.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.data.DataManager;
import util.data.PageObjectMethod;

import java.io.IOException;

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
        System.out.println();
//        parseSteps("cancel","/com.xueqiu.app/page/SearchPage.yaml");

    }
}
