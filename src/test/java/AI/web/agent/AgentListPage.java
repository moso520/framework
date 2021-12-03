package AI.web.agent;

import AI.resources.AgentWebInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgentListPage extends AgentBasePage {
    public AgentListPage(ChromeDriver driver) {
        super(driver);
    }

    public AgentListPage searchAgent() throws InterruptedException {
        sendKeys(By.xpath(AgentWebInfo.AGENT_INPUT_COMPANY_XPATH),"厦门一行一网络");
        click(By.xpath(AgentWebInfo.AGENT_SEARCH_BUTTON_XPATH));
        Thread.sleep(3000);
        Assert.assertEquals(getText(By.xpath(AgentWebInfo.AGENT_SEARCH_RESULT_NAME_XPATH)),"15160686998");
        return this;
    }
}
