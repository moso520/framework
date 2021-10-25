package AI.resources;

public class WebInfo {
    public static final String MANAGER_HOST = "http://manager.aihuandian.net";
    //Login
    public static final String LOGIN_USERNAME_XPATH = "/html/body/div/div[2]/div/div[2]/div[1]/div/input";
    public static final String LOGIN_AUTH_XPATH = "/html/body/div/div[2]/div/div[2]/div[2]/div[1]/input";
    public static final String LOGIN_PASSWORD_XPATH = "/html/body/div/div[2]/div/div[2]/div[3]/div/input";
    public static final String LOGIN_LOGIN_BUTTON_XPATH = "/html/body/div/div[2]/div/div[3]/div";


    //MAIN
    public static final String LOGIN_USERNAME_TEXT_XPATH = "/html/body/div[1]/div/div[2]/div[1]/div[3]/div[1]/div[1]";

    //Agent
    public static final String AGENT_MANAGER_XPATH = "/html/body/div[1]/div/div[1]/div[1]/ul/li[13]/div/span";
    public static final String AGENT_LIST_XPATH = "/html/body/div[1]/div/div[1]/div[1]/ul/li[13]/ul/li[1]";
    public static final String AGENT_INPUT_PHONE_XPATH = "/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/input";
    public static final String AGENT_SEARCH_BUTTON_XPATH = "/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div[4]/button[2]/span";
    public static final String AGENT_SEARCH_RESULT_NAME_XPATH = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tr[2]/td[2]";

    //User
    public static final String USER_MANAGER_XPATH = "/html/body/div[1]/div/div[1]/div[1]/ul/li[4]/div/span";
    public static final String USER_LIST_XPATH = "/html/body/div[1]/div/div[1]/div[1]/ul/li[4]/ul/li[1]";
    public static final String USER_INPUT_NAME_XPATH = "/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/input";
    public static final String USER_SEARCH_BUTTON_XPATH = "/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[3]";
    public static final String USER_SEARCH_RESULT_PHONE_XPATH = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/table/tr[2]/td[3]";
}
