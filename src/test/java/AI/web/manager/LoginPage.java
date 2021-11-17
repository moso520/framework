package AI.web.manager;

import AI.resources.Contact;
import AI.resources.WebInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    public LoginPage(ChromeDriver driver) {
        super(driver);
    }
    public LoginPage toLogin(){
        driver.get(WebInfo.MANAGER_HOST);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return this;
    }
    public MainPage login(){
        toLogin();
        sendKeys(By.xpath(WebInfo.LOGIN_USERNAME_XPATH), Contact.MANAGER_NAME);
        sendKeys(By.xpath(WebInfo.LOGIN_AUTH_XPATH),Contact.MANAGER_AUTH);
        sendKeys(By.xpath(WebInfo.LOGIN_PASSWORD_XPATH),Contact.MANAGER_ASSWORD);
        click(By.xpath(WebInfo.LOGIN_LOGIN_BUTTON_XPATH));
        return new MainPage(driver);
    }
}
