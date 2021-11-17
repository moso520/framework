package AI.Test.UITest;

import AI.web.agent.AgentBasePage;
import AI.web.agent.AgentWebManager;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AgentUITest {

    @Order(1)
    @Test
    void login() throws InterruptedException {
        AgentWebManager web = new AgentWebManager();
        web.startWeb().login().checkLogin();
    }

    @Order(2)
    @Test
    void searchAgent() throws InterruptedException {
        AgentWebManager web = new AgentWebManager();
        web.startWeb().login().toCompanyList().searchAgent();
    }

    @Order(3)
    @Test
    void searchUser() throws InterruptedException {
        AgentWebManager web = new AgentWebManager();
        web.startWeb().login().toUserList().searchUser();
    }

    @AfterEach
    void quit(){
        AgentBasePage.quitChrome();
    }
}
