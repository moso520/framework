package AI.web.agent;

import AI.resources.AgentWebInfo;
import AI.resources.Contact;
import AI.resources.WebInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AgentLoginPage extends AgentBasePage {

    public AgentLoginPage(ChromeDriver driver) {
        super(driver);
    }
    public AgentLoginPage toLogin(){
        driver.get(AgentWebInfo.AGENT_HOST);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return this;
    }
    public AgentMainPage login() throws InterruptedException {
        toLogin();
        sendKeys(By.xpath(AgentWebInfo.LOGIN_USERNAME_XPATH), Contact.AGENT_NAME);
        sendKeys(By.xpath(AgentWebInfo.LOGIN_PASSWORD_XPATH),Contact.AGENT_PASSWORD);
        click(By.xpath(AgentWebInfo.LOGIN_LOGIN_BUTTON_XPATH));
        Thread.sleep(1000);
        click(By.xpath(AgentWebInfo.LOGIN_SKIP_BUTTON_XPATH));
        return new AgentMainPage(driver);
    }
}
