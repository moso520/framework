package AI.web.agent;

import AI.resources.AgentWebInfo;
import AI.resources.WebInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgentUserListPage extends AgentBasePage {
    public AgentUserListPage(ChromeDriver driver) {
        super(driver);
    }

    public AgentUserListPage searchUser() throws InterruptedException {
        sendKeys(By.xpath(AgentWebInfo.USER_INPUT_SN_XPATH),"VX6LNBHIFFDFC1001025");
        click(By.xpath(AgentWebInfo.USER_SEARCH_BUTTON_XPATH));
        Thread.sleep(1000);
        Assert.assertEquals(getText(By.xpath(AgentWebInfo.USER_SEARCH_RESULT_OPERATION_XPATH)),"合作中");
        return this;
    }
}
