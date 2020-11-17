package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

public class LogoutTest extends BaseTest{

    private MainPage page;

    @Before
    public void signIn(){
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"));
    }

    @Test
    public void exit(){
        page.logout()
            .validateLogout();
    }
}