package tests.tabs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.code.ProjectPage;
import tests.BaseTest;

public class ListTabsTest extends BaseTest {

    private ProjectPage page;

    @Before
    public void signIn() {
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProject();
    }

    @Test
    public void printTabsInDiffColors() {
        page.colorfulTabsNames();
    }

    @After
    public void tearDown(){
        page.logout()
                .validateLogout();
    }
}