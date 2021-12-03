package AI.Test.UITest;

import AI.web.manager.BasePage;
import AI.web.manager.WebManager;
import org.junit.jupiter.api.*;

/**
 * 综管端UI自动化
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManagerUITest {
    /**
     * 登录
     */
    @Order(1)
    @Test
    void login(){
        WebManager web = new WebManager();
        web.startWeb().login().checkLogin();
    }
    /**
     * 搜索代理
     */
    @Order(2)
    @Test
    void searchAgent() throws InterruptedException {
        WebManager web = new WebManager();
        web.startWeb().login().toAgentList().searchAgent();
    }
    /**
     * 搜索用户
     */
    @Order(3)
    @Test
    void searchUser() throws InterruptedException {
        WebManager web = new WebManager();
        web.startWeb().login().toUserList().searchUser();
    }

    @AfterEach
    void quit(){
        BasePage.quitChrome();
    }
}
