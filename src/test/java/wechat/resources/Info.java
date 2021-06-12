package wechat.resources;

public class Info {
    private static final String HOST = "https://qyapi.weixin.qq.com";
    private static final String GET_ACCESS_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    private static final String TAIL = "?access_token=";


    public static final String DEPARTMENT_CREATE = HOST + "/cgi-bin/department/create?access_token=" + TAIL;
    public static final String DEPARTMENT_UPDATE = HOST + "/cgi-bin/department/update?access_token=" + TAIL;
    public static final String DEPARTMENT_LIST = HOST + "/cgi-bin/department/list?access_token=" + TAIL;
    public static final String DEPARTMENT_DELETE = HOST + "/cgi-bin/department/delete?access_token=" + TAIL;

}
