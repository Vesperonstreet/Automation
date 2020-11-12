package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import java.util.NoSuchElementException;
import static helpers.ColorPrinter.printMessageInYellow;

public class LoginPageTest extends BaseTest{

    private LoginPage page;
    private String errorMessage;
    private String invalidMessage;


    @Before
    public void setPage(){
        printMessageInYellow("=== Begin test ===");
        this.page = new LoginPage(driver);
        this.errorMessage = "There have been several " +
                "failed attempts to sign in from this account " +
                "or IP address. Please wait a while and try " +
                "again later.";
        this.invalidMessage = "Incorrect username or password.";
    }


    @Test
    public void negativeAuthTest(){
        try {
            page.checkAuthFields()
                    .LoginNegative("admin", "admin")
                    .validateErrorMessage(errorMessage, true)
                    .returnToLoginPage()
                    .LoginNegative("login", "password")
                    .validateErrorMessage(invalidMessage);
        } catch (NoSuchElementException e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void checkPositiveLogin(){
        try {
            page.checkAuthFields()
                    .login(System.getProperty("login"), System.getProperty("password"))
                    .validateLogin();
        } catch (NoSuchElementException e){
            Assert.fail(e.getMessage());
        }
    }

    // mvn test -Dname=value -Dkey=value
    @Test
    public void showSystemVars(){
        System.out.println(System.getProperty("name"));
        System.out.println(System.getProperty("key"));

    }
}