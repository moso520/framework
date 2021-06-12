package wechat.wechatTest;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testng.Assert;
import wechat.services.DepartImp;
import wechat.util.FakerUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;


@Epic("Epic企业微信接口测试用例")
@Feature("Feature部门相关功能测试")
public class DepartmentTest {

    @BeforeEach
    @AfterEach
    @DisplayName("DisplayName -> Clean Depart Test Case")
    void clearDepart(){
        DepartImp.clearDepartments();
    }

    @Story("Create Department Test")
    @DisplayName("Create Depart Test Case")
    @Description("Use CSV file as parameters to test create department")
    @Severity(SeverityLevel.BLOCKER)
    @ParameterizedTest
    @CsvFileSource(resources = "/data/createDepartment.csv", numLinesToSkip = 1)
    void createDepartment(String creatName, String creatEnName, String returnCode){
        Response createResponse = DepartImp.createDepart(creatName,creatEnName);
        Assert.assertEquals(returnCode, createResponse.path("errcode").toString());
    }

    @Story("List Department Test")
    @DisplayName("List Depart Test Case")
    @Description("List department and check with Java 8 lambdas")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void listDepartment(){
        String name = "name" + FakerUtils.getTimeStamp();
        String name_en = "name_en" + FakerUtils.getTimeStamp();
        String departmentId = DepartImp.createDepart(name, name_en).path("id").toString();
        Response listResposnse = DepartImp.listDepartRes(departmentId);
        assertAll("List department check",
                ()->assertEquals(name, listResposnse.path("department.name[1]").toString()),
                ()->assertEquals(name_en, listResposnse.path("department.name_en[1]").toString()),
                ()->assertEquals(departmentId, listResposnse.path("department.id[1]").toString())
                );
    }

    @Story("Update Department Test")
    @DisplayName("Update Depart Test Case")
    @Description("Update department and check with Java 8 lambdas")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void updateDepartment(){
        String name = "Depart_Test_1";
        String name_en = "En_Depart_Test_1";
        String departmentId = DepartImp.createDepart(name, name_en).path("id").toString();
        String name_Update = FakerUtils.getTimeStamp();
        String name_en_Update = FakerUtils.getTimeStamp();
        Response updateResponse = DepartImp.updateDepart(departmentId, name_Update, name_en_Update);
        Response listResposnse = DepartImp.listDepartRes(departmentId);
        assertAll("List department check",
                ()->assertEquals("0", updateResponse.path("errcode").toString()),
                ()->assertEquals(name_Update, listResposnse.path("department.name[1]").toString()),
                ()->assertEquals(name_en_Update, listResposnse.path("department.name_en[1]").toString())
        );
    }

    @Story("Delete Department Test")
    @DisplayName("Delete Depart Test Case")
    @Description("Use CSV file as parameters to test Delete department")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void deleteDepart(){
        String name = "Depart_Test_1";
        String name_en = "En_Depart_Test_1";
        String departmentId = DepartImp.createDepart(name, name_en).path("id").toString();
        Response listResposnse = DepartImp.listDepartRes(departmentId);
        assertAll("List department check",
                ()->assertEquals(name, listResposnse.path("department.name[1]").toString()),
                ()->assertEquals(name_en, listResposnse.path("department.name_en[1]").toString()),
                ()->assertEquals(departmentId, listResposnse.path("department.id[1]").toString())
        );
        DepartImp.deleteDepart(departmentId);
        assertNull(DepartImp.listDepartRes(departmentId).path("department.id[1]"));
    }


}
