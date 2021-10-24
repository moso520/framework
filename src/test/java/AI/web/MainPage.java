package AI.web;

import AI.resources.Contact;
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


}
