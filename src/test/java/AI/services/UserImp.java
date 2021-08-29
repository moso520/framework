package AI.services;

import AI.resources.Info;
import AI.util.HttpUtil;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserImp {


    public static Response listUserRes(String departmentId){
        Map<String, Object> map = new HashMap<>();
        map.put("department_id",departmentId);
        Response listUserResponse = HttpUtil.get(map, Info.USER_LIST_FROM_DEPARTMENT);
        return listUserResponse;
    }

    public static void clearUsersFromDepart(String departmentId){
        Response listUserResponse = listUserRes(departmentId);
        ArrayList<String> userIds = listUserResponse.path("userlist.userid");
        for (String str : userIds){
            deleteUser(str);
        }
    }

    public static void deleteUser(String userId){
        Map<String, Object> map = new HashMap<>();
        map.put("userid",userId);
        Response delResponse = HttpUtil.get(map, Info.USER_DELETE);
        assertEquals("0", delResponse.path("errcode").toString());
    }

    public static Response createUser(String createBody){
        Response createRes = HttpUtil.post(createBody, Info.USER_CREATE);
        return createRes;
    }

    public static Response updateUser(String updateBody){
        Response updateRes = HttpUtil.post(updateBody, Info.USER_UPDATE);
        return updateRes;
    }
}
