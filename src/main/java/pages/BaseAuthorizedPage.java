package pages;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.ProjectPage;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;

public abstract class BaseAuthorizedPage extends BasePage{

    public BaseAuthorizedPage(WebDriver driver, String title) {
        super(driver, title);
    }

    //Search field
    private final By searchField = By.xpath("//input[@data-unscoped-placeholder='Search or jump to...']");
    private final By searchResults = By.xpath("//li[contains(@id,'jump-to-suggestions')]");
    //User Buttons
    private final By userButton = By.xpath("//summary[@class='Header-link' and @aria-label='View profile and more']");
    private final By logOutButton = By.xpath("//button[contains(text(), 'Sign out')]");

    public ProjectPage searchProject(String projectName){
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(projectName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error(e);
        }
        driver.findElements(searchResults).get(1).click();
        return new ProjectPage(driver);
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