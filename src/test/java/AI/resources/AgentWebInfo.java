package AI.resources;

public class AgentWebInfo {
    public static final String AGENT_HOST = "http://agent.aihuandian.net/#/login";
    //Login
    public static final String LOGIN_USERNAME_XPATH = "//*[@id=\"app\"]/div[1]/div/form/div[1]/div/div/input";
    public static final String LOGIN_PASSWORD_XPATH = "//*[@id=\"app\"]/div[1]/div/form/div[2]/div/div/input";
    public static final String LOGIN_LOGIN_BUTTON_XPATH = "//*[@id=\"app\"]/div[1]/div/form/div[3]/div/div/button[1]/span";
    public static final String LOGIN_SKIP_BUTTON_XPATH = "//*[@id=\"app\"]/div[2]/div/div[1]";


    //MAIN
    public static final String LOGIN_USERNAME_TEXT_XPATH = "//*[@id=\"app\"]/section/header/div[2]/div[1]/p";

    //Company
    public static final String AGENT_COMPANY_XPATH = "//*[@id=\"app\"]/section/section/aside/ul/li[4]/div/span[2]";
    public static final String AGENT_COMPANY_LIST_XPATH = "//*[@id=\"app\"]/section/section/aside/ul/li[4]/ul/li[1]";
    public static final String AGENT_INPUT_COMPANY_XPATH = "//*[@id=\"app\"]/section/section/main/div/div[2]/div[1]/form/div[1]/div/div/input";
    public static final String AGENT_SEARCH_BUTTON_XPATH = "//*[@id=\"app\"]/section/section/main/div/div[2]/div[1]/form/div[3]/div/button[1]/span";
    public static final String AGENT_SEARCH_RESULT_NAME_XPATH = "//*[@id=\"app\"]/section/section/main/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/span";

    //User
    public static final String USER_MANAGER_XPATH = "//*[@id=\"app\"]/section/section/aside/ul/li[3]/div/span[2]";
    public static final String USER_LIST_XPATH = "//*[@id=\"app\"]/section/section/aside/ul/li[3]/ul/li[2]";
    public static final String USER_INPUT_SN_XPATH = "//*[@id=\"app\"]/section/section/main/div/div[2]/div/div[2]/input";
    public static final String USER_SEARCH_BUTTON_XPATH = "//*[@id=\"app\"]/section/section/main/div/div[2]/div/div[3]";
    public static final String USER_SEARCH_RESULT_OPERATION_XPATH = "//*[@id=\"app\"]/section/section/main/div/div[3]/div[2]/div[1]/div[3]/table/tbody/tr/td[10]/div/span";
}
