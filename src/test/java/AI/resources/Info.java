package AI.resources;

public class Info {
    private static final String TEST_HOST = "http://agent.aihuandian.net";
    private static final String APP_HOST = "http://test-agent.aihuandian.net";
    private static final String GET_ACCESS_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    private static final String TAIL = "?access_token=";

    //Department
    public static final String DEPARTMENT_CREATE = TEST_HOST + "/cgi-bin/department/create" + TAIL;
    public static final String DEPARTMENT_UPDATE = TEST_HOST + "/cgi-bin/department/update" + TAIL;
    public static final String DEPARTMENT_LIST = TEST_HOST + "/cgi-bin/department/list" + TAIL;
    public static final String DEPARTMENT_DELETE = TEST_HOST + "/cgi-bin/department/delete" + TAIL;

    //User
    public static final String USER_LIST_FROM_DEPARTMENT = TEST_HOST + "/cgi-bin/user/simplelist" + TAIL;
    public static final String USER_DELETE = TEST_HOST + "/cgi-bin/user/delete" + TAIL;
    public static final String USER_CREATE = TEST_HOST + "/cgi-bin/user/create" + TAIL;
    public static final String USER_UPDATE = TEST_HOST + "/cgi-bin/user/update" + TAIL;

    //Al - agent
    public static final String LOGIN = TEST_HOST + "/api/v2/agent/account/login";
    public static final String USER_INFO = TEST_HOST + "/api/v2/agent/account/info";
    public static final String LIST_PACKAGE = TEST_HOST + "/api/v1/agent/package/list";
    public static final String LIST_USER = TEST_HOST + "/api/v2/agent/account/employee/list";
    public static final String LIST_PROVINCE = TEST_HOST + "/api/v1/agent/area/province/list";
    public static final String LIST_AREA = TEST_HOST + "/api/v1/agent/area/area/list";
    public static final String LIST_CITY = TEST_HOST + "/api/v1/agent/area/city/list";
    //Tab User detail
    public static final String LIST_ALL_USER = TEST_HOST + "/api/v2/agent/user/group/list";
    public static final String LIST_CO_USER = TEST_HOST + "/api/v1/agent/report/cooperation/user/list?pageSize=10&pageNum=0";
     //欠费
    public static final String LIST_OWE_USER = TEST_HOST + "/api/v1/agent/report/owe/user/list?pageSize=10&pageNum=0";
    public static final String LIST_NEW_USER = TEST_HOST + "/api/v1/agent/report/new/user/list?pageSize=10&pageNum=0";
    public static final String LIST_EXCHANGE_USER = TEST_HOST + "/api/v1/agent/report/excharge/battery/list?pageSize=10&pageNum=0";
}
