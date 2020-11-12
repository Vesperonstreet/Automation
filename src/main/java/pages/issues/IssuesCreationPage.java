package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class IssuesCreationPage extends BasePage {

    private static final String TITLE = "Страница со списком задач проекта";

    public IssuesCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By IssueTitleField = By.id("issue_title");
    private final By IssueBodyField = By.id("issue_body");
    private final By IssueCreationButton = By.xpath("//button[@class = 'btn btn-primary']");

    public IssueInfoPage createNewIssue(String title, String body){
        log.info("Создаем новую задачу");
        Assert.assertTrue(driver.findElement(IssueTitleField).isDisplayed());
        driver.findElement(IssueTitleField).sendKeys(title);
        Assert.assertTrue(driver.findElement(IssueBodyField).isDisplayed());
        driver.findElement(IssueBodyField).sendKeys(body);
        Assert.assertTrue(driver.findElement(IssueCreationButton).isDisplayed());
        driver.findElement(IssueCreationButton).click();
        log.info("Задача создана");
        return new IssueInfoPage(driver);
    }
}