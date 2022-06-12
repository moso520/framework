package AI.resources;

public class InfoApp {
    private static final String TEST_HOST_PUB = "39.99.152.77";
    private static final String TEST_HOST_1 = "172.20.146.157";
    private static final String TEST_HOST_2 = "172.20.146.156";
    private static final String TEST_HOST_3 = "172.20.146.170";
    private static final String TEST_HOST_4 = "172.20.146.172";
    public static final String USER_ID = "5c99d9e542cda600684bfc6a";
    /**
     * Host,分别修改后面的数字即可
     * TEST_HOST是APP的HOST
     * DEVICES_HOST是devices的HOST
     */

    //每台服务器 会有2个appserver 实例， 启动端口分别是8083 ， 8183。
    public static String TEST_HOST = TEST_HOST_2 + ":8183";
    public static String DEVICES_HOST = TEST_HOST_3;

    //APP
    public static final String LOGIN = "http://"+ TEST_HOST + "/app/userInfo";
    public static final String USER_DETAIL = "http://"+ TEST_HOST + "/app/v3/user/userInfo";
    public static final String UPLOAD_BASIC_INFO = "http://"+ TEST_HOST + "/app/userInfo/basicInfo";
    public static final String CABINET_LIST = "http://"+ TEST_HOST + "/app/v3/swap/cabinet/list";
    public static final String GROUP_GRCODE = "http://"+ TEST_HOST + "/app/v3/swap/group/qrcode";
    public static final String DEPOSIT_AMOUNT = "http://"+ TEST_HOST + "/app/deposit/amount";
    public static final String SUBMIT_CERTIFICATION = "http://"+ TEST_HOST + "/app/v3/user/userInfo/certification";
    public static final String SWAP = "http://"+ TEST_HOST + "/app/v3/swap";
    public static final String SEND_SMS = "http://"+ TEST_HOST_PUB + "/platform/sms";
    public static final String CHECK_SMS = "http://"+ TEST_HOST_PUB + ":/app/v3/login/sms/check";

    //DEVICES
    public static final String CHECK_DEVICES_VERSION = "http://" + DEVICES_HOST + ":8082/v1/device";
}
