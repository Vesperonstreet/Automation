package tests.ui.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ui.autorization.LoginNegativeTest;
import tests.ui.autorization.LoginPositiveTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginPositiveTest.class,
                LoginNegativeTest.class
        }
)
public class SmokeSuite {
}
