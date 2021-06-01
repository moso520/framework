package app;

import app.page.Wework;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class addPersonTest {

    @Test
    void addPerson() throws MalformedURLException {
        Wework wework = new Wework();
//        wework.startApp().toTeam().addRemark();
        wework.startApp().toTeam().addPerson();
//    wework.startApp().toTeam().searchPerson();
    }


}
