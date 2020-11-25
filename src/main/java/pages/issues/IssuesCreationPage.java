package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BaseAuthorizedPage;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static helpers.ColorPrinter.*;

public class IssuesCreationPage extends BaseAuthorizedPage {

    private static final String TITLE = "Страница со списком задач проекта";

    public IssuesCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By IssueTitleField = By.id("issue_title");
    private final By IssueBodyField = By.id("issue_body");
    private final By IssueCreationButton = By.xpath("//button[@class = 'btn btn-primary']");
    private final By labelsShowButton = By.id("labels-select-menu");
    private final By IssueLabels = By.xpath("//span[@class = 'name']");

    public IssueInfoPage createNewIssue(String title, String body, List<String> testLabels) {
        printColorMessage("Создаем новую задачу", log, Level.INFO);
        Assert.assertTrue(driver.findElement(IssueTitleField).isDisplayed());
        driver.findElement(IssueTitleField).sendKeys(title);
        printMessageInYellow("Поле title заполненно", log);
        Assert.assertTrue(driver.findElement(IssueBodyField).isDisplayed());
        driver.findElement(IssueBodyField).sendKeys(body);
        printMessageInYellow("Поле body заполненно", log);
        Assert.assertTrue(driver.findElement(labelsShowButton).isDisplayed());
        webDriverWait_10.until(ExpectedConditions.elementToBeClickable(labelsShowButton));
        driver.findElement(labelsShowButton).click();
        printMessageInYellow("Кнопка Labels нажата", log);
/*
// ===== Лямбда-выражение Вариант 1 =====
        driver.findElements(IssueLabels).forEach(label -> {
            if (testLabels.contains(label.getText())) {
                Assert.assertTrue(label.isDisplayed());
                label.click();
            }
        });
*/
// ===== Лямбда-выражение Вариант 2 =====
        driver.findElements(IssueLabels)
                .stream()
                .filter(label -> testLabels.contains(label.getText()))
                .forEach(WebElement::click);

// todo Код выше это конструкция Лямбда-выражение, можно заменить на код ниже
/*
        List<WebElement> labels = driver.findElements(IssueLabels);
        for (WebElement label : labels){
            if(testLabels.contains(label.getText())) {
                Assert.assertTrue(label.isDisplayed());
                label.click();
            }
        }
*/
        driver.findElement(labelsShowButton).click();
        Assert.assertTrue(driver.findElement(IssueCreationButton).isDisplayed());
        driver.findElement(IssueCreationButton).click();
        printMessageInYellow("Кнопка IssueCreationButton нажата", log);
        printMessageInGreen("Задача создана", log);
        return new IssueInfoPage(driver);
    }
}