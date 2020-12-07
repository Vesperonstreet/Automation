package tests.ui;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static helpers.ExcelHelper.*;

public class SomeTest {

    @Test
    public void checkFile(){
        List<String> testData = new ArrayList<>();
        testData.add("One");
        testData.add("Two");
        testData.add("Three");
        testData.add("Four");
        testData.add("Five");

        writeToExcelFile("C:/Users/Admin/IdeaProjects/G46Automation/src/test/resources/data/TestExcelFile3.xlsx",
                testData,
                "New Лист1",
                1);
    }
}

/*
//    Для проверки массива из строк и столбцов 24.11.20    ================================
    @Test
    public void checkFile(){
        readExcelFile("C:/Users/Admin/IdeaProjects/G46Automation/src/test/resources/data/TestExcelFile2.xlsx",
                        "Лист1").forEach(System.out::println);
    }
}
*/
/*
//   Для проверки одного столбца 24.11.20     ================================
    @Test
    public void checkFile() {
        System.out.println(readColumnFromExcelFile(
                "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\TestExcelFile.xlsx",
                        0));
    }
}
*/

/*    ==================================================================
    @Test
    public void checkFile(){
       writeTextToFile(
               "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\out.txt",
               "First line\nSecond line\nThird line");
    }
}
*/
/*   ====================================================================
    @Test
    public void checkFile(){
        List<String> data = readLinesFromFile(
                "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\main\\resources\\log4j2.properties");
        for(String line : data){
                System.out.println(line.replaceAll("\n", ""));
        }
    }
}

 */
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