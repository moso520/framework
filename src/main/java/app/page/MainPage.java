package app.page;



import app.contact.Info;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public MainPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public MessagePage toMessage(){
        click(By.cssSelector("*[text='消息']"));
        return new MessagePage(driver);
    }
    public TeamPage toTeam(){
        click(By.xpath(Info.TEAM_XPATH));
        return new TeamPage(driver);
    }
}