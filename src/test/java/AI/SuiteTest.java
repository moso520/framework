package AI;


import AI.Test.APPTest.SmsTest;
import AI.Test.APPTest.UserDetailTest;
import AI.Test.AgentTest;
import AI.Test.UserReportTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses( { AgentTest.class, UserReportTest.class, UserDetailTest.class, SmsTest.class} )
public class SuiteTest {
}
