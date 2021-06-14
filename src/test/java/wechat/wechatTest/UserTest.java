package wechat.wechatTest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.BeforeTest;
import wechat.bean.User;
import wechat.services.Data_User;
import wechat.services.DepartImp;
import wechat.services.UserImp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {
    private static User createUser;
    private static int createDepartmentId;
    private static List<Integer> departmentIds = new ArrayList<>();

    //todo delete all user

    @BeforeClass
    @AfterClass
    @DisplayName("Clean Depart Test Case")
    @Test
    void clearDepart(){
        DepartImp.clearDepartments();
    }

    @BeforeClass
    @DisplayName("Create Depart")
    @ParameterizedTest
    @CsvSource({
        "Depart001, TestDepartEn"
    })
    @Order(3)
    void createDepartment(String creatName, String creatEnName){
        Response createResponse = DepartImp.createDepart(creatName,creatEnName);
        Assert.assertEquals("0", createResponse.path("errcode").toString());
        createDepartmentId = createResponse.path("id");
        departmentIds.add(createDepartmentId);
    }


    @DisplayName("Create User From Yaml")
    @Description("Yaml file as parameters to test create user")
    @ParameterizedTest
    @MethodSource("data")
    @Order(4)
    void create(Data_User data_user){

        createUser = (User)data_user.createUserData(new Exception().getStackTrace()[0].getMethodName());
        createUser.setDepartment(departmentIds);
        String createBody = JSONObject.toJSONString(createUser, SerializerFeature.WriteMapNullValue);
        Response createResponse = UserImp.createUser(createBody);
        Assert.assertEquals("0", createResponse.path("errcode").toString());
    }

    @DisplayName("List User")
    @Description("List User Test")
    @Test
    @Order(5)
    void list(){

        Response listUserRes = UserImp.listUserRes(String.valueOf(createDepartmentId));
        //{"errcode":0,"errmsg":"ok","userlist":[{"userid":"test001","name":"王好","department":[2]}]}
        assertAll("List user check",
                ()->Assert.assertEquals(createUser.getUserid(), StringUtils.strip(listUserRes.path("userlist.userid").toString(), "[]")),
                ()->Assert.assertEquals(createUser.getName(), StringUtils.strip(listUserRes.path("userlist.name").toString(), "[]"))
        );
    }


    @DisplayName("Update User")
    @Description("Update User Test")
    @ParameterizedTest
    @CsvSource({
            "王好002, 18302419811"
    })
    @Order(6)
    void update(String name, String mobile){
        createUser.setName(name);
        createUser.setMobile(mobile);
        String updateBody = JSONObject.toJSONString(createUser, SerializerFeature.WriteMapNullValue);
        Response updateRes = UserImp.updateUser(updateBody);
        Response listUserRes = UserImp.listUserRes(String.valueOf(createDepartmentId));
        assertAll("List user check",
                ()->Assert.assertEquals("0", updateRes.path("errcode").toString()),
                ()->Assert.assertEquals(createUser.getName(), StringUtils.strip(listUserRes.path("userlist.name").toString(), "[]"))
        );
    }

    @DisplayName("Delete User")
    @Description("Delete User Test")
    @Test
    @Order(7)
    void delete(){
        UserImp.deleteUser(createUser.userid);
    }

    static Stream<Data_User> data() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Data_User dataUser = mapper.readValue(
                new File("src/main/resources/data/wechat_user.yaml"),
                Data_User.class
        );
        return Stream.of(dataUser);
    }
}
