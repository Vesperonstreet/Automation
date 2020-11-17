package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;

public class IssuesPage extends BasePage {

    private static final String TITLE = "Страница создания задач";

    public IssuesPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By newIssuesButton = By.xpath("//a[@class = 'btn btn-primary']");

    public IssuesCreationPage pressToCreateNewIssue(){
        printColorMessage("Нажимаем на \"Создать новую задачу\"", log, Level.INFO);
        Assert.assertTrue(driver.findElement(newIssuesButton).isDisplayed());
        driver.findElement(newIssuesButton).click();
        printMessageInYellow("Кнопка нажата", log);
        return new IssuesCreationPage(driver);
    }
}