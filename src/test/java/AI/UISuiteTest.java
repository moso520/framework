package AI;


import AI.Test.APPTest.UserDetailTest;
import AI.Test.AgentTest;
import AI.Test.UITest.AgentUITest;
import AI.Test.UITest.ManagerUITest;
import AI.Test.UserReportTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * 代理+综管UI自动化
 */
@RunWith(JUnitPlatform.class)
@SelectClasses( {AgentUITest.class, ManagerUITest.class} )
public class UISuiteTest {
}
