package wechat.util;

import io.restassured.response.Response;
import wechat.services.TokenFilter;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpUtil {

    public static String getgetAccessToken(){
        String accessToken = given()
                .when()
                .param("corpid","ww60620b053b98245b")
                .param("corpsecret","ItRiRb8CJzc5ye7J5QEJjy6JGzkOtTTcTuCGnZTTcGA")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .extract()
                .response()
                .path("access_token");
        return accessToken;
    }

    public static Response get(Map<String, Object> map, String url){
        Response response = given().filter(TokenFilter.getTokenFilter()).log().all()
                .when()
                .params(map)
                .get(url)
                .then()
                .extract()
                .response();
        return response;
    }

    public static Response get(String url){
        Response response = given().filter(TokenFilter.getTokenFilter()).log().all()
                .when()
                .get(url)
                .then()
                .extract()
                .response();
        return response;
    }

    public static Response post(Object object, String url, String contentType){
        Response response = given().filter(TokenFilter.getTokenFilter()).log().all()
                .contentType(contentType)
                .when()
                .body(object)
                .post(url)
                .then()
                .extract()
                .response();
        return response;
    }

    public static Response post(Object object, String url){
        Response response = given().filter(TokenFilter.getTokenFilter()).log().all()
                .contentType("application/json")
                .when()
                .body(object)
                .post(url)
                .then()
                .extract()
                .response();
        return response;
    }
}
