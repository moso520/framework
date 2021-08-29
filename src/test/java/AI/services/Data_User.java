package AI.services;

import AI.bean.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;

public class Data_User {
    public String name;
    public HashMap<String, List<HashMap<String, Object>>> methods;
    private static Gson gson = new GsonBuilder().create();



    public Object createUserData(String methodName){


        List<HashMap<String, Object>> userCreate = methods.get(methodName);
        JSONObject jsonObject = new JSONObject();
        for (HashMap<String, Object> hashMap : userCreate){
            for (HashMap.Entry<String, Object> entry : hashMap.entrySet()){
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        }

        User user = JSON.parseObject(jsonObject.toJSONString(), User.class);
        return user;
    }

}
