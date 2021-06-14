package wechat.wechatTest;

import io.restassured.response.Response;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testng.Assert;
import wechat.services.DepartImp;

public class ThreadTest {

    @RepeatedTest(100)
    void createDepartment(){
        Response createResponse = DepartImp.createDepart("name123","name_en123");
        Assert.assertEquals("0", createResponse.path("errcode").toString());
    }
}
