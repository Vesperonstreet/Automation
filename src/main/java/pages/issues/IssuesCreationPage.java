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

    private final By MainPage = By.xpath("//main[@id='js-repo-pjax-container']");

    public IssueInfoPage createNewIssue(String title, String body){
        printColorMessage("Создаем новую задачу", log, Level.INFO);
        Assert.assertTrue(driver.findElement(IssueTitleField).isDisplayed());
        driver.findElement(IssueTitleField).sendKeys(title);
        printMessageInYellow("Поле title заполненно", log);
        Assert.assertTrue(driver.findElement(IssueBodyField).isDisplayed());
        driver.findElement(IssueBodyField).sendKeys(body);
        printMessageInYellow("Поле body заполненно", log);
        Assert.assertTrue(driver.findElement(IssueLabelsButton).isDisplayed());
        driver.findElement(IssueLabelsButton).click();
        printMessageInYellow("Кнопка IssueLabelsButton нажата", log);

        List<WebElement> labels = driver.findElements(IssueLabels);
        for (WebElement label : labels){
            Assert.assertTrue(label.isDisplayed());
        }

        driver.findElements(IssueLabels).stream().findFirst().orElse(labels.get(2)).click();

        Assert.assertTrue(driver.findElement(MainPage).isDisplayed());
        driver.findElement(MainPage).click();
        printMessageInYellow("Выполнен клик на экране, для закрытия Labels", log);
        Assert.assertTrue(driver.findElement(IssueCreationButton).isDisplayed());
        driver.findElement(IssueCreationButton).click();
        printMessageInGreen("Задача создана", log);

        return new IssueInfoPage(driver);
    }
}