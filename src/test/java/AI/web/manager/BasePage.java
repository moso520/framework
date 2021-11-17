package AI.web.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static ChromeDriver driver;
    Integer retryTimes = 3;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
    }
    public boolean click(By by){

        try {
            driver.findElement(by).click();
            System.out.println("click success " + by);
        }catch (Exception e){
            System.out.println(driver.getPageSource());
            retryTimes += 1;
            e.printStackTrace();
            if (retryTimes < 4){
                this.handleAlert();
                return click(by);
            }
            else {
                retryTimes = 0;
                return false;
            }
        }
        return true;
    }

    public void handleAlert(){

    }

    public void sendKeys(By by, String content){
        driver.findElement(by).sendKeys(content);
        System.out.println("sendKeys success " + by + content);
    }

    public String getAttribute(By by, String element){
        String attribute = driver.findElement(by).getAttribute(element);
        return attribute;
    }

    public String getText(By by){
        String resString = driver.findElement(by).getText();
        System.out.println("getText success " + by + resString);
        return resString;
    }

    public static void quitChrome(){
        driver.quit();
    }
}
