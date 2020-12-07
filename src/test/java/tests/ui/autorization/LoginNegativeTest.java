package tests.ui.autorization;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import tests.ui.BaseTest;

import java.util.Collection;

import static helpers.ColorPrinter.printMessageInYellow;
import static helpers.FileHelper.readAuthDataFromFile;

@RunWith(Parameterized.class)
public class LoginNegativeTest extends BaseTest {

    private LoginPage page;
    private String errorMessage;
    private String invalidMessage;

    private String login;
    private String password;

    public LoginNegativeTest(String login, String password){
        this.login = login;
        this.password = password;
    }
/*
    @Parameterized.Parameters
    public static Collection<String[]> data(){
        Collection<String[]> result = new ArrayList<>();
        result.add(new String[]{"login", "password"});
        result.add(new String[]{"testLogin", "testPassword"});
        result.add(new String[]{"tester", "tester"});
        result.add(new String[]{"someLogin", "somePassword"});
        return result;
    }
    //todo код выше можно заменить на часть кода ниже
*/
    @Parameterized.Parameters
    public static Collection<String[]> data(){
        return readAuthDataFromFile(
           "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\authData.txt");
}

    @Before
    public void setPage(){
        printMessageInYellow("=== Start of test ===");
        this.page = new LoginPage(driver);
        this.errorMessage = "There have been several " +
                "failed attempts to sign in from this account " +
                "or IP address. Please wait a while and try " +
                "again later.";
        this.invalidMessage = "Incorrect username or password.";
    }


    @Test
    public void negativeAuthTest(){    // todo Кейс для параметризации
            page.checkAuthFields()
                    .LoginNegative(this.login, this.password)
                    .validateErrorMessage(invalidMessage);
    }

/*
            //todo Кейс без параметризации
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
 */
    @After
    public void tearDown(){
        printMessageInYellow("=== And of test ===");
    }
}