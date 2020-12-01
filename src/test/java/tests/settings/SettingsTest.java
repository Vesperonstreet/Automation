package tests.settings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.settings.SettingsPage;
import tests.BaseTest;

public class SettingsTest extends BaseTest {

    private SettingsPage page;

    @Before
    public void signIn() {
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProject()
                .openSettingsPage();
    }

    @Test
    public void checkRepositoryRenaming(){
        page.renameRepository("Java_Automation")
                .validateRenaming("Java_Automation");
    }

    @After
    public void tearDown(){
        page.logout()
                .validateLogout();
    }
}