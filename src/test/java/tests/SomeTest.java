package tests;

import org.junit.Before;
import pages.LoginPageObject;

public class SomeTest extends BaseTest {

    private LoginPageObject page;

    @Before()
    public void setPage(){
        page = new LoginPageObject(driver);
    }


//    @Test()
    public void ourTest(){
        page.checkAuthFields();
    }
}

 /* ----------------------------------------------------------------------------------------------

    private By loginField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signInButton = By.id("commit");

    private WebDriver driver;

    @Test
    public void ourTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") +
                "/src/main/resources/chrome_drivers_V86/chromedriver.exe");

        this.driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://github.com/login");

        driver.quit();

//        Assert.assertTrue(3 > 2);
//        Assert.assertEquals("Message", "Expected", "Not Expected");

    }
*/