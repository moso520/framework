package AI;


import AI.Test.APPTest.UserDetailTest;
import AI.Test.AgentTest.AgentTest;
import AI.Test.AgentTest.UserReportTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * App+代理+综管接口自动化
 */
@RunWith(JUnitPlatform.class)
@SelectClasses( { AgentTest.class, UserReportTest.class, UserDetailTest.class} )
public class SuiteTest {

}
