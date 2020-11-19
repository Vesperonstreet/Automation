package tests;

import org.junit.Test;
import java.util.List;
import static helpers.FileHelper.readLinesFromFile;

public class SomeTest {

    @Test
    public void checkFile(){
        List<String> data = readLinesFromFile(
                "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\main\\resources\\log4j2.properties");
        for(String line : data){
            System.out.println(line);
        }
    }
}
    /*    ----------------------------------------------
             case for testng

   // @DataProvider
    public Object[][] testData(){
        return new Object[][]{ {"login", "password"}, {"admin", "admin"} };
    }

   // @Test(dataProvider = "testData")
    public void ourTest(String login, String password){
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }
}
         ------------------------------------------------
*/
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