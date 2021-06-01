package app.page;

import app.contact.Info;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamPage extends BasePage {
    public TeamPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
    public TeamPage addPerson() {
        for(int i = 10; i < 20 ; i++) {
            String addMemText = "添加成员...";
            click(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
                            ".text(\"" + addMemText + "\").instance(0));"));
//            click(By.cssSelector(Info.TEAM_TEAMMEM_ADDMEM_CSS));
            click(By.xpath(Info.TEAM_TEAMMEM_ADDMEM_MANINPUT_XPATH));
            sendKeys(By.id(Info.TEAM_TEAMMEM_ADDMEM_NAME_ID), "老王0"+i);
            sendKeys(By.id(Info.TEAM_TEAMMEM_ADDMEM_PHONE_ID), "183000000"+i);
            selectAutoInv();
            click(By.id(Info.TEAM_TEAMMEM_ADDMEM_SAVE_ID));
            click(By.id(Info.TEAM_TEAMMEM_BACK_ID));
        }
        return this;

    }

    public boolean isSelectedAutoInv(){
        return Boolean.parseBoolean(getAttribute(By.id(Info.TEAM_TEAMMEM_ADDMEM_AUTO_INV_ID), "selected"));
    }

    public void selectAutoInv(){
        if (!isSelectedAutoInv()){
            click(By.id(Info.TEAM_TEAMMEM_ADDMEM_AUTO_INV_ID));
        }
    }

    public TeamPage addRemark(){
        click(By.xpath("//*[@text='老王001-01']"));
        click(By.id(Info.TEAM_TEAMMEM_EDIT_REMARK_ID));
        sendKeys(By.id(Info.TEAM_TEAMMEM_EDIT_REMCONTENT_ID),"老王001");
        sendKeys(By.id(Info.TEAM_TEAMMEM_EDIT_DESC_ID), "from Statestreet Company" + "老王001-01");
        click(By.id(Info.TEAM_TEAMMEM_EDIT_SAVE_ID));
        WebDriverWait wait =new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Info.TEAM_TEAMMEM_BACK_ID)));
        click(By.id(Info.TEAM_TEAMMEM_BACK_ID));
        System.out.println();
        return this;
    }

    public TeamPage searchPerson(){
        click(By.id(Info.TEAM_TEAMMEM_SEARCH_ID));
        sendKeys(By.id(Info.TEAM_TEAMMEM_SEARCH_BOX_ID), "王好");
        click(By.id(Info.TEAM_TEAMMEM_SEARCH_RESULT_ID));
        String nameText = getAttribute(By.id(Info.TEAM_TEAMMEM_SEARCH_NAME_ID),"text");
        assertThat(nameText, equalTo("王好"));
        click(By.id(Info.TEAM_TEAMMEM_BACK_ID));
        click(By.id(Info.TEAM_TEAMMEM_BACK_ID));
        return this;
    }

}
