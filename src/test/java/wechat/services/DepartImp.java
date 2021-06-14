package wechat.services;

import io.restassured.response.Response;
import wechat.resources.Info;
import wechat.util.HttpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartImp {


    public static Response listDepartRes(String departId){
        Map<String, Object> map = new HashMap<>();
        map.put("id",departId);
        Response listDepartResponse = HttpUtil.get(Info.DEPARTMENT_LIST);
        return listDepartResponse;
    }

    public static void clearDepartments(){
        Response listDepartResponse = listDepartRes("");
        ArrayList<Integer> departmentIds = listDepartResponse.path("department.id");
        for (int i : departmentIds){
            if (i == 1){
                continue;
            }
            deleteDepart(String.valueOf(i));
        }
    }

    public static void deleteDepart(String departId){
        Map<String, Object> map = new HashMap<>();
        map.put("id",departId);
        Response delResponse = HttpUtil.get(map, Info.DEPARTMENT_DELETE);
        assertEquals("0", delResponse.path("errcode").toString());
    }

    public static Response createDepart(String creatName,String creatEnName){
        String createBody = BuildBody.buildDepartC(creatName, creatEnName);
        Response createRes = HttpUtil.post(createBody, Info.DEPARTMENT_CREATE);
        return createRes;
    }

    public static Response updateDepart(String departmentId, String creatName,String creatEnName){
        String updateBody = BuildBody.buildDepartU(departmentId, creatName, creatEnName);
        Response updateRes = HttpUtil.post(updateBody, Info.DEPARTMENT_UPDATE);
        return updateRes;
    }
}
