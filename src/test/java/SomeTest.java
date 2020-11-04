import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SomeTest {

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
}