package AI.Test.UITest;

import AI.web.agent.AgentBasePage;
import AI.web.agent.AgentWebManager;
import org.junit.jupiter.api.*;
/**
 * 代理端UI自动化
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AgentUITest {
    /**
     * 登录
     */
    @Order(1)
    @Test
    void login() throws InterruptedException {
        AgentWebManager web = new AgentWebManager();
        web.startWeb().login().checkLogin();
    }
    /**
     * 搜索代理
     */
    @Order(2)
    @Test
    void searchAgent() throws InterruptedException {
        AgentWebManager web = new AgentWebManager();
        web.startWeb().login().toCompanyList().searchAgent();
    }
    /**
     * 搜索用户
     */
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
