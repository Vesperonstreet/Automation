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
    private final By IssueLabels = By.xpath("//div[@class = 'css-truncate']");

    public IssueInfoPage createNewIssue(String title, String body, List<String> testLabels){
        printColorMessage("Создаем новую задачу", log, Level.INFO);
        Assert.assertTrue(driver.findElement(IssueTitleField).isDisplayed());
        driver.findElement(IssueTitleField).sendKeys(title);
        printMessageInYellow("Поле title заполненно", log);
        Assert.assertTrue(driver.findElement(IssueBodyField).isDisplayed());
        driver.findElement(IssueBodyField).sendKeys(body);
        printMessageInYellow("Поле body заполненно", log);
        Assert.assertTrue(driver.findElement(IssueCreationButton).isDisplayed());
        driver.findElement(IssueCreationButton).click();
        printMessageInYellow("Кнопка IssueCreationButton нажата", log);
        printMessageInGreen("Задача создана", log);

        List<WebElement> labels = driver.findElements(IssueLabels);
        for (WebElement label : labels){
            if(testLabels.contains(label.getText())) {
                Assert.assertTrue(label.isDisplayed());
                label.click();
            }
        }

        return new IssueInfoPage(driver);
    }
}