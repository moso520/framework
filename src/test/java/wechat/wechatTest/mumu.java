package wechat.wechatTest;

import org.testng.annotations.*;
public class mumu
{
    private int param;

    @Factory(dataProvider = "dataMethod")
    public  mumu(int param) {
        this.param = param;
    }

    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][] { new Object[]{ 0 }, new Object[]{ 10 } };
    }

    @Test
    public void testMethodOne() {
        int opValue = param + 1;
        System.out.println("Test method one output: " + opValue);
    }

    @Test
    public void testMethodTwo() {
        int opValue = param + 2;
        System.out.println("Test method two output: " + opValue);
    }
}