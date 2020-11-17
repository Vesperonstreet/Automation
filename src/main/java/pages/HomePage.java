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

    private final By title = By.xpath("//h1[@class = 'h000-mktg text-white lh-condensed-ultra mb-3']");
    private final By description = By.xpath("//p[@class = 'lead-mktg mb-4']");

    public HomePage validateLogout(){
        printColorMessage("Проверка успешного выхода из системы", log, Level.INFO);
        try {
            Assert.assertEquals("Built for developers", driver.findElement(title).getText());
            Assert.assertEquals("GitHub is a development platform inspired by the way you work. " +
                                "From open source to business, you can host and review code, manage projects, " +
                                "and build software alongside 50 million developers.",
                                driver.findElement(description).getText());
        } catch (NoSuchElementException n){
            Assert.fail("Выход не выполнен (((" + n.getMessage());
        }
        printMessageInGreen("Выход выполнен.", log);
        return this;
    }
    
}
