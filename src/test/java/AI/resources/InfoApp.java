package AI.resources;

public class InfoApp {
//    private static final String TEST_HOST = "39.99.152.77:8083";
    private static final String TEST_HOST = "39.99.152.77:8083";
    private static final String DEVICES_HOST = "http://172.20.146.157:9880";
    public static final String USER_ID = "5c99d9e542cda600684bfc6a";


    //user detail
    public static final String LOGIN = "http://"+ TEST_HOST + "/app/userInfo";
    public static final String USER_DETAIL = "http://"+ TEST_HOST + "/app/v3/user/userInfo";
    public static final String UPLOAD_BASIC_INFO = "http://"+ TEST_HOST + "/app/userInfo/basicInfo";
    public static final String CABINET_LIST = "http://"+ TEST_HOST + "/app/v3/swap/cabinet/list";
    public static final String GROUP_GRCODE = "http://"+ TEST_HOST + "/app/v3/swap/group/qrcode";
    public static final String DEPOSIT_AMOUNT = "http://"+ TEST_HOST + "/app/deposit/amount";
    public static final String SUBMIT_CERTIFICATION = "http://"+ TEST_HOST + "/app/v3/user/userInfo/certification";
    public static final String SWAP = "http://"+ TEST_HOST + "/app/v3/swap";
    public static final String SEND_SMS = "http://"+ TEST_HOST + "/platform/sms";
    public static final String CHECK_SMS = "http://"+ TEST_HOST + "/app/v3/login/sms/check";

    //DEVICES
    public static final String CHECK_DEVICES_VERSION = DEVICES_HOST + "/device/cabinet/device";


}
