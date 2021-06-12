package wechat.services;

public class BuildBody {

    public static String buildDepartC(String name, String enName){
        String createBody = "{\n" +
                "   \"name\": \"" + name + "\",\n" +
                "   \"name_en\": \""+ enName +"\",\n" +
                "   \"parentid\": 1\n" +
                "}\n";
        return createBody;
    }

    public static String buildDepartU(String departId, String name, String enName){
        String updateBody = "{\n" +
                "   \"id\": "+departId+",\n" +
                "   \"name\": \""+ name +"\",\n" +
                "   \"name_en\": \""+ enName +"\",\n" +
                "   \"parentid\": 1,\n" +
                "}";
        return updateBody;
    }
}
