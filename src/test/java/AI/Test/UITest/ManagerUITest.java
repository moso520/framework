package AI.Test.UITest;

import AI.web.WebManager;
import org.junit.jupiter.api.Test;

public class ManagerUITest {

    @Test
    void login(){
        WebManager web = new WebManager();
        web.startWeb().login().checkLogin();
    }

}
