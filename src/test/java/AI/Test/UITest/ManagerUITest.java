package AI.Test.UITest;

import AI.web.BasePage;
import AI.web.WebManager;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManagerUITest {

    @Order(1)
    @Test
    void login(){
        WebManager web = new WebManager();
        web.startWeb().login().checkLogin();
    }

    @Order(2)
    @Test
    void searchAgent() throws InterruptedException {
        WebManager web = new WebManager();
        web.startWeb().login().toAgentList().searchAgent();
    }

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
