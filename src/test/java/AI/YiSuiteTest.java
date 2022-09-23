package AI;



import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import performance.TCPPerfTest;
import performance.WeAgentPerfTest;
import performance.WeCUserPerfTest;
import performance.YiManagerPerfTest;

/**
 * App+代理+综管接口自动化
 */
@RunWith(JUnitPlatform.class)
@SelectClasses( { WeAgentPerfTest.class, WeCUserPerfTest.class, YiManagerPerfTest.class} )
public class YiSuiteTest {

}
