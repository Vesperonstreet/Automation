package pages;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;
import static helpers.ColorPrinter.printMessageInGreen;

public class HomePage extends BasePage{

    private final static String TITLE = "Домашняя страница";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title = By.xpath("//h1[@class = 'h2-5-mktg-fluid h1-sm-mktg-fluid h0-lg-mktg-fluid text-white mb-3-fluid position-relative z-2']");
    private final By description = By.xpath("//p[@class = 'f4-mktg-fluid f2-sm-mktg-fluid text-gray-light-mktg mr-lg-n4-fluid mb-4-fluid lh-condensed lh-sm-default position-relative z-2']");

    public HomePage validateLogout(){
        printColorMessage("Проверка успешного выхода из системы", log, Level.INFO);
        try {
 /*           Assert.assertEquals("Where the world" +
                            "builds software",
                                driver.findElement(title).getText());
 */           Assert.assertEquals("Millions of developers and companies build, ship, and " +
                            "maintain their software on GitHub—the largest and " +
                            "most advanced development platform in the world.",
                                driver.findElement(description).getText());
        } catch (NoSuchElementException n){
            Assert.fail("Выход не выполнен (((" + n.getMessage());
        }
        printMessageInGreen("Выход выполнен.", log);
        return this;
    }
    
}
