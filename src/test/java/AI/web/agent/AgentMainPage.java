package AI.web.agent;

import AI.resources.AgentWebInfo;
import AI.resources.WebInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgentMainPage extends AgentBasePage {
    public AgentMainPage(ChromeDriver driver) {
        super(driver);
    }

    public AgentMainPage checkLogin(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String userName = getText(By.xpath(AgentWebInfo.LOGIN_USERNAME_TEXT_XPATH));
        Assert.assertEquals("刘忠海",userName);
        return this;
    }

    public AgentListPage toCompanyList(){
        click(By.xpath(AgentWebInfo.AGENT_COMPANY_XPATH));
        click(By.xpath(AgentWebInfo.AGENT_COMPANY_LIST_XPATH));
        return new AgentListPage(driver);
    }

    public AgentUserListPage toUserList(){
        click(By.xpath(AgentWebInfo.USER_MANAGER_XPATH));
        click(By.xpath(AgentWebInfo.USER_LIST_XPATH));
        return new AgentUserListPage(driver);
    }

}
