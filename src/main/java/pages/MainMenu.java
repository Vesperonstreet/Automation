package pages;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;

public class MainMenu extends BasePage{

    private final static String TITLE = "Основное меню";

    private final By userButton = By.xpath("//summary[@class='Header-link' and @aria-label='View profile and more']");
    private final By logOutButton = By.xpath("//button[contains(text(), 'Sign out')]");

    public MainMenu(WebDriver driver) {
        super(driver, TITLE);
    }

    public HomePage logout(){
        log.info("Выход из приложения");
        printColorMessage("Проверка наличия кнопки View profile", log, Level.INFO);
        Assert.assertTrue(driver.findElement(userButton).isDisplayed());
        driver.findElement(userButton).click();
        printMessageInYellow("Кнопка View profile нажата", log);
        printColorMessage("Проверка наличия кнопки Sign out", log, Level.INFO);
        Assert.assertTrue(driver.findElement(logOutButton).isDisplayed());
        driver.findElement(logOutButton).click();
        printMessageInYellow("Кнопка Sign out нажата", log);
        return new HomePage(driver);
    }
}