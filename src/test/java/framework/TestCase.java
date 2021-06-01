package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class TestCase {
    public WebDriver driver;
    public String name;
    public List<HashMap<String, Object>> before_all;
    public List<HashMap<String, Object>> after_all;
    public List<HashMap<String, Object>> before;
    public List<HashMap<String, Object>> after;
    public List<HashMap<String, Object>> steps;

    public void run(){
        System.out.println(steps);
        AtomicReference<By> default_by = new AtomicReference<>();

        steps.forEach(step ->{
            step.entrySet().forEach((entry) ->{
                System.out.println(entry);
                String action = entry.getKey().toLowerCase();
                Object value = entry.getValue();

                if (action.equals("get")){
                    driver.get(String.valueOf(value));
                }else if (action.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                }else if(action.equals("find")){
                    ArrayList<String> values = (ArrayList<String>) value;
                    String locator_by = values.get(0);
                    String locator_value = values.get(1);
                    switch (locator_by){
                        case "id":
                            default_by.set(By.id(locator_value));
                            break;
                        case "css":
                            default_by.set(By.cssSelector(locator_value));
                            break;
                        case "xpath":
                            default_by.set(By.xpath(locator_value));
                            break;
                    }
                }else if(action.equals("click")){
                    driver.findElement(default_by.get()).click();
                }else if(action.equals("sendkeys")){
                    driver.findElement(default_by.get()).sendKeys((String) value);
                }else if (action.equals("wait_imp")) {
                    Integer seconds = (Integer) value;
                    driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
                }
            });

        });
    }


}
