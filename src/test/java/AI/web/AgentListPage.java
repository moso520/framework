package AI.web;

import AI.resources.WebInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgentListPage extends BasePage{
    public AgentListPage(ChromeDriver driver) {
        super(driver);
    }

    public AgentListPage searchAgent() throws InterruptedException {
        sendKeys(By.xpath(WebInfo.AGENT_INPUT_PHONE_XPATH),"17710245528");
        click(By.xpath(WebInfo.AGENT_SEARCH_BUTTON_XPATH));
        Thread.sleep(1000);
        Assert.assertEquals(getText(By.xpath(WebInfo.AGENT_SEARCH_RESULT_NAME_XPATH)),"测试");
        return this;
    }
}
