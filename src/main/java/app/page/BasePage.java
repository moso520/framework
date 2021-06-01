package app.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BasePage {
    protected AppiumDriver<MobileElement> driver;
    Integer retryTimes = 3;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public boolean click(By by){

        try {
            driver.findElement(by).click();
            System.out.println("click success" + by);
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
    }

    public String getAttribute(By by, String element){
        String attribute = driver.findElement(by).getAttribute(element);
        return attribute;
    }

}
