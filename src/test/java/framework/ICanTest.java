package framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ICanTest {
    static WebDriver driver;

//    @BeforeAll
//    public static void beforeAll(){
////        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Test
    public void cheshiRenTest() throws InterruptedException {
//        driver.get("https://ceshiren.com");
//        driver.findElement(By.id("search-button")).click();
//
//        String keyword = "内推 BAT";
//        driver.findElement(By.id("search-term")).sendKeys(keyword + Keys.ENTER);
//        String title = driver.findElement(By.cssSelector(".topic-title")).getText();
//        Thread.sleep(5000);
//        assertThat(title, containsString(keyword));



    }
    @Test
    @ParameterizedTest
    @MethodSource("data")
    public void cheshiRenTestYaml(TestCase testCase)  {
//        driver.get("https://ceshiren.com");
//        driver.findElement(By.id("search-button")).click();
//
//        String keyword = "内推 BAT";
//        driver.findElement(By.id("search-term")).sendKeys(keyword + Keys.ENTER);
//        String title = driver.findElement(By.cssSelector(".topic-title")).getText();
//        Thread.sleep(5000);
//        assertThat(title, containsString(keyword));
        testCase.run();


    }
    static Stream<TestCase> data() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TestCase testCase =objectMapper.readValue(new File("src/main/resources/data/ceshiRen.yaml"),
                TestCase.class);
        return Stream.of(testCase);
    }
}
