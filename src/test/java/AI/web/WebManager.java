package AI.web;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebManager {
    public LoginPage startWeb(){
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/test/java/AI/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LoginPage(driver);
    }
}
