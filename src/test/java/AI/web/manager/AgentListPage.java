package AI.web.manager;

import AI.resources.WebInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgentListPage extends BasePage{
    public AgentListPage(ChromeDriver driver) {
        super(driver);
    }

    public AgentListPage searchAgent() throws InterruptedException {
        sendKeys(By.xpath(WebInfo.AGENT_INPUT_PHONE_XPATH),"18132092207");
        click(By.xpath(WebInfo.AGENT_SEARCH_BUTTON_XPATH));
        Thread.sleep(3000);
        Assert.assertEquals(getText(By.xpath(WebInfo.AGENT_SEARCH_RESULT_NAME_XPATH)),"故障电池总仓");
        return this;
    }
}
