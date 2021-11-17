package agent;

import AI.resources.WebInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage extends BasePage {
    public MainPage(ChromeDriver driver) {
        super(driver);
    }

    public MainPage checkLogin(){
        String userName = getText(By.xpath(WebInfo.LOGIN_USERNAME_TEXT_XPATH));
        Assert.assertEquals(userName,"姜兆京");
        return this;
    }

    public AgentListPage toAgentList(){
        click(By.xpath(WebInfo.AGENT_MANAGER_XPATH));
        click(By.xpath(WebInfo.AGENT_LIST_XPATH));
        return new AgentListPage(driver);
    }

    public UserListPage toUserList(){
        click(By.xpath(WebInfo.USER_MANAGER_XPATH));
        click(By.xpath(WebInfo.USER_LIST_XPATH));
        return new UserListPage(driver);
    }

}
