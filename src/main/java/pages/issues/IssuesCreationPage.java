package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import java.util.List;

import static helpers.ColorPrinter.*;

public class IssuesCreationPage extends BasePage {

    private static final String TITLE = "Страница со списком задач проекта";

    public IssuesCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By IssueTitleField = By.id("issue_title");
    private final By IssueBodyField = By.id("issue_body");
    private final By IssueCreationButton = By.xpath("//button[@class = 'btn btn-primary']");

    private final By IssueLabelsButton = By.id("labels-select-menu");
    private final By IssueLabels = By.xpath("//div[@class='css-truncate']");

    public IssueInfoPage createNewIssue(String title, String body){
        printColorMessage("Создаем новую задачу", log, Level.INFO);
        Assert.assertTrue(driver.findElement(IssueTitleField).isDisplayed());
        driver.findElement(IssueTitleField).sendKeys(title);
        Assert.assertTrue(driver.findElement(IssueBodyField).isDisplayed());
        driver.findElement(IssueBodyField).sendKeys(body);
        Assert.assertTrue(driver.findElement(IssueCreationButton).isDisplayed());
        driver.findElement(IssueCreationButton).click();
        printMessageInGreen("Задача создана", log);


        List<WebElement> labels = driver.findElements(IssueLabels);
        for (WebElement label : labels){
            Assert.assertTrue(label.isDisplayed());
        }

        return new IssueInfoPage(driver);
    }
}