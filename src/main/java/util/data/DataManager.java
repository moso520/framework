package util.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataManager {


    public PageObjectMethod getDataElements(String method) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String path = "src/main/resources/data/app_test_data.yaml";
        PageObjectModel model = mapper.readValue(this.getClass().getResourceAsStream(path),PageObjectModel.class);

        return model.methods.get(method);
    }

    public PageObjectMethod getDataElements() throws IOException {
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        return getDataElements(method);
    }

    public void parseSteps(String method) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String path = "src/main/resources/data/app_test_data.yaml";
        try {
            PageObjectModel model = mapper.readValue(this.getClass().getResourceAsStream(path),PageObjectModel.class);
//            parseStepsFromYaml(model.methods.get(method));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseSteps(){
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        parseSteps(method);
    }

//    private void parseStepsFromYaml(PageObjectMethod steps){ //获取方法名method
//        steps.getSteps().forEach(step ->{
//            WebElement element = null;
//            if (step.get("id") != null){
//                element = driver.findElement(By.id("id"));
//            }else if (step.get("xpath") != null){
//                element = findElement(By.id(step.get("xpath")));
//            }else if (step.get("aid") != null){
//                element = findElement(MobileBy.AccessibilityId(step.get("aid")));
//                if (step.get("send") != null){
//                    element.sendKeys(step.get("send"));
//                }
//                else if (step.get("get") != null){
//                    findElement(By by).getAttribute(get);
//                }
//                else {
//                    element.click();  //默认操作是点击
//                }
//            );
//            }
//        }
//    }



}