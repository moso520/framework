package wechat.wechatTest;


import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wechat.services.TokenFilter;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


//ww60620b053b98245b
//nWF1rnCxWzyD3USE7FBuSASqD4O2Hb6tBY4a5kirWaY
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo_01_base {
    private static final Logger logger = LoggerFactory.getLogger(Demo_01_base.class);


    static String accessToken;
    static String departmentId;
    @BeforeAll
    public static  void getAccessToken(){
        accessToken = given().log().all()
                .when()
                .param("corpid","ww60620b053b98245b")
                .param("corpsecret","ItRiRb8CJzc5ye7J5QEJjy6JGzkOtTTcTuCGnZTTcGA")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .extract().response().path("access_token");
        logger.info(accessToken);
    }

    @DisplayName("create Department")
    @Test
    @Order(1)
    void createDepartmemt(){

        String body = "{\n" +
                "   \"name\": \"子部门01Q\",\n" +
                "   \"name_en\": \"child01Q\",\n" +
                "   \"parentid\": 1\n" +
                "}\n";
        Response createResponse = given().filter(TokenFilter.getTokenFilter()).log().all()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=")
                .then()
                .log().body()
                .extract()
                .response();
        departmentId = createResponse.path("id").toString();
        logger.info("departmentId: "+ departmentId);
    }


    @DisplayName("update Department")
    @Test
    @Order(2)
    void updateDepartment(){

        String body = "{\n" +
                "   \"id\": "+departmentId+",\n" +
                "   \"name\": \"子部门001U\",\n" +
                "   \"name_en\": \"child001U\",\n" +
                "   \"parentid\": 1,\n" +
                "}";

        Response updateResponse = given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=" + accessToken + "")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0", updateResponse.path("errcode").toString());
    }

    @DisplayName("list Department")
    @Test
    @Order(3)
    void listDepartment() {
        Response listResponse = given().log().all()
                .contentType("application/json")
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0", listResponse.path("errcode").toString());
        ArrayList<Integer> departmentIds = listResponse.path("department.id");
        for (int id : departmentIds) {
            System.out.println(id);
        }
    }

    @DisplayName("delete Department")
    @Test
    @Order(4)
    void deleteDepartment(){
        Response delResponse = given().log().all()
                .contentType("application/json")
                .param("id", departmentId)
                .param("access_token", accessToken)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0", delResponse.path("errcode").toString());
    }



}
