package AI.resources;

public class JsonBody {
    public static String uploadBasicInfo = "{\n" +
            "\t\"appVersion\": \"3.4.0\",\n" +
            "\t\"deviceId\": \"70f059078a0a97225240a99395adc54\",\n" +
            "\t\"model\": \"V1916A\",\n" +
            "\t\"objectId\": \"132222222227d8c680308890\",\n" +
            "\t\"phoneManufacturer\": \"vivo\",\n" +
            "\t\"platform\": \"android\",\n" +
            "\t\"systemVersion\": \"11\",\n" +
            "\t\"userPhone\": \"13222222222\"\n" +
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
            "  \"userId\": \"5c99d9e542cda600684bfc6a\",\n" +
            "  \"cabinetSn\": \"H8ANBCB5L600112C\"\n" +
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
}
