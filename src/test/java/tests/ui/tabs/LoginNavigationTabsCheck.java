package tests.ui.tabs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;
import tests.ui.BaseTest;

import static helpers.ColorPrinter.printMessageInYellow;

public class LoginNavigationTabsCheck extends BaseTest {

    private LoginPage page;

    @Before
    public void setPage(){
        printMessageInYellow("=== Start of test ===");
        this.page = new LoginPage(driver);
    }

    @Test
    public void checkPositiveLogin(){
        try{
            page.checkAuthFields()
                    .login(System.getProperty("login"),
                            System.getProperty("password"))
//                    .validateLogin();
                    .openOurProject()
                    .validateTabs()
                    .logout()
                    .validateLogout();
        } catch (NoSuchElementException e){
            Assert.fail(e.getMessage());
        }
    }

    @After
    public void tearDown(){
        printMessageInYellow("=== And of test ===");
    }
}