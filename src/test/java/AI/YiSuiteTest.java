package AI;


import AI.Test.APPTest.UserDetailTest;
import AI.Test.AgentTest.AgentTest;
import AI.Test.AgentTest.UserReportTest;
import AI.Test.DevicesTest.DevicesTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import performance.TCPPerf;
import performance.WeAgentPerf;
import performance.WeCUserPerf;
import performance.YiManagerPerf;

/**
 * App+代理+综管接口自动化
 */
@RunWith(JUnitPlatform.class)
@SelectClasses( { WeAgentPerf.class, WeCUserPerf.class, YiManagerPerf.class, TCPPerf.class} )
public class YiSuiteTest {

}
