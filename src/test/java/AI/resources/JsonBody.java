package AI.resources;

public class JsonBody {
    public static String uploadBasicInfo = "{\n" +
            "\t\"appVersion\": \"3.4.0\",\n" +
            "\t\"deviceId\": \"ad606709f2d81486d3860338101e352c\",\n" +
            "\t\"model\": \"M2007J3SC\",\n" +
            "\t\"objectId\": \"137000010113f52da67a470e\",\n" +
            "\t\"phoneManufacturer\": \"Xiaomi\",\n" +
            "\t\"platform\": \"android\",\n" +
            "\t\"systemVersion\": \"11\",\n" +
            "\t\"userPhone\": \"13700001011\"\n" +
            "}";

    public static String groupGrcode = "{\n" +
            "    \"qrcode\":\"AG1651625239170\",\n" +
            "    \"userId\":\"5c99d9e542cda600684bfc6a\"\n" +
            "}";

    public static String submitCertification = "{\n" +
            "    \"userId\":\"5c99d9e542cda600684bfc6a\",\n" +
            "    \"userName\":\"Sakura1\",\n" +
            "    \"idCardNumber\":\"433127202108200003\",\n" +
            "    \"idCardFrontImg\":\"123.jpg\",\n" +
            "    \"holdIdCardImg\":\"456.jpg\"\n" +
            "}";
    public static String swapCabine = "{\n" +
            "  \"userId\": \"17326075282\",\n" +
            "  \"cabinetSn\": \"ACAWDEA9L750A020\"\n" +
            "}";


    public static String sendSms = "{\n" +
            " \"phone\":\""+Contact.APP_PHONE+"\",\n" +
            " \"smsCode\":\""+Contact.SMS_DEFAULT_CODE+"\",\n" +
            " \"operationId\":\"12\" \n" +
            "}";

    public static String checkSms = "{\n" +
            " \"phone\":\""+Contact.APP_PHONE+"\",\n" +
            " \"smsCode\":\""+Contact.SMS_DEFAULT_CODE+"\"\n" +
            "}";

    public static String increaseAdjust = "{\n" +
            " \"userId\":\""+Contact.PROD_YICHIO_TEST_USER_ID+"\",\n" +
            " \"t\""+":"+System.currentTimeMillis()+",\n" +
            " \"amount\":\"1\",\n" +
            " \"type\":\"1\",\n" +
            " \"remark\":\"increaseTest\"\n" +
            "}";

    public static String decreaseAdjust = "{\n" +
            " \"userId\":\""+Contact.PROD_YICHIO_TEST_USER_ID+"\",\n" +
            " \"t\""+":"+System.currentTimeMillis()+",\n" +
            " \"amount\":\"1\",\n" +
            " \"type\":\"-1\",\n" +
            " \"remark\":\"decreaseTest\"\n" +
            "}";
}
