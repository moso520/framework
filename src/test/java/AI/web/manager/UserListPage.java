package AI.web.manager;

import AI.resources.WebInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserListPage extends BasePage {
    public UserListPage(ChromeDriver driver) {
        super(driver);
    }

    public UserListPage searchUser() throws InterruptedException {
        sendKeys(By.xpath(WebInfo.USER_INPUT_NAME_XPATH),"王晓春");
        click(By.xpath(WebInfo.USER_SEARCH_BUTTON_XPATH));
        Thread.sleep(1000);
        Assert.assertEquals(getText(By.xpath(WebInfo.USER_SEARCH_RESULT_PHONE_XPATH)),"17326075282");
        return this;
    }
}
