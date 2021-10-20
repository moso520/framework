package AI.Test;

import AI.TestData.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class BasicTest {
//    static String method1 =  new Exception().getStackTrace()[1].getClassName();

    static Object[][] yamlDataMethod() {
        /*System.out.println(method1);
        String str = new Exception().getStackTrace().getClass().getSuperclass().getName();
        StackTraceElement[] ss = new Exception().getStackTrace();
        String sss = ss[1].getClassName();
        System.out.println("LogUtil上级调用类："+ss[1].getClassName() +"  --调用方法："+ ss[1].getMethodName());

        Method method = null;
        String s = method.getDeclaringClass().getName();
        String method1 =  new Exception().getStackTrace()[1].getClassName();*/
//        Map<String, ArrayList<HashMap<String, Object>>> yamlList = getYamlList();
//        Object[][] files = new Object[yamlList.size()][];
//        for (int i = 0; i < yamlList.size(); i++) {
//            files[i] = new Object[]{yamlList.get(i)};
//        }
//        return files;
        return null;
    }

    static Stream<ArrayList<HashMap<String, Object>>> getYamlList() {
        Map<String, ArrayList<HashMap<String, Object>>> resultMap = null;
        try {
            Yaml yaml = new Yaml();
            File f = new File("src/test/java/AI/resources/testdata.yaml");
            //读入文件
            resultMap = yaml.load(new FileInputStream(f));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        LinkedHashMap<String,HashMap<String, Object>> list = (LinkedHashMap)resultMap.get("TestSuite");
//        LinkedHashMap<String, Object> list = (LinkedHashMap) resultMap.get("TestSuite");
        System.out.println();
        return null;

    }

    static Stream<TestData> data() throws IOException {


        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestData testData = mapper.readValue(
                new File("src/test/java/AI/resources/testdata.yaml"),
                TestData.class
        );
        return Stream.of(testData);
    }
}
