package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    @Before()
    public void setUp(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") +
                        "/src/main/resources/chrome_drivers_V87/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
    }

    @After()
    public void tearDown(){
        driver.quit();
    }
}
