package AI.TestData;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {
   /* public String name;
    public HashMap<String, List<HashMap<String, Object>>> methods;
    private static Gson gson = new GsonBuilder().create();



    public Object getTestData(String methodName){
//        methodName = new Exception().getStackTrace()[0].getMethodName();
        List<HashMap<String, Object>> userCreate = methods.get(methodName);
        JSONObject jsonObject = new JSONObject();
        for (HashMap<String, Object> hashMap : userCreate){
            for (HashMap.Entry<String, Object> entry : hashMap.entrySet()){
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        }

//        User user = JSON.parseObject(jsonObject.toJSONString(),User.class);
        return jsonObject;
    }*/



    public static List<Map<String, String>> readYamlUtil() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//        ArrayList<HashMap<String, Object>> map = readYamlUtil();
//        for (Map.Entry<String, Map<String, String>> me : map.entrySet()) {
//            Map<String, String> numNameMapValue = me.getValue();
//            Map<String, String> tmp = new HashMap<>();
//            for (Map.Entry<String, String> nameMapEntry : numNameMapValue.entrySet()) {
//                String numKey = nameMapEntry.getKey();
//                String nameValue = nameMapEntry.getValue();
//                tmp.put(numKey, nameValue);
//            }
//            list.add(tmp);
//        }
        return list;
    }
//todo
//    public static Map<String, ArrayList<HashMap<String, Object>>> getYamlList() {
//        Map<String, ArrayList<HashMap<String, Object>>> resultMap = null;
//        try {
//            Yaml yaml = new Yaml();
//            File f = new File("src/test/java/AI/resources/testdata.yaml");
//            //读入文件
//            resultMap = yaml.load(new FileInputStream(f));
//            System.out.println();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return resultMap;
//
//    }



}
