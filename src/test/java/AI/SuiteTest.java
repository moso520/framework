package AI;


import AI.Test.AgentTest;
import AI.Test.UserReportTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses( { AgentTest.class, UserReportTest.class} )
public class SuiteTest {
}
