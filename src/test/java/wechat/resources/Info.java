package wechat.resources;

public class Info {
    private static final String HOST = "https://qyapi.weixin.qq.com";
    private static final String GET_ACCESS_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    private static final String TAIL = "?access_token=";

    //Department
    public static final String DEPARTMENT_CREATE = HOST + "/cgi-bin/department/create" + TAIL;
    public static final String DEPARTMENT_UPDATE = HOST + "/cgi-bin/department/update" + TAIL;
    public static final String DEPARTMENT_LIST = HOST + "/cgi-bin/department/list" + TAIL;
    public static final String DEPARTMENT_DELETE = HOST + "/cgi-bin/department/delete" + TAIL;

    //User
    public static final String USER_LIST_FROM_DEPARTMENT = HOST + "/cgi-bin/user/simplelist" + TAIL;
    public static final String USER_DELETE = HOST + "/cgi-bin/user/delete" + TAIL;
    public static final String USER_CREATE = HOST + "/cgi-bin/user/create" + TAIL;
    public static final String USER_UPDATE = HOST + "/cgi-bin/user/update" + TAIL;


}
