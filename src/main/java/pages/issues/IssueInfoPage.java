package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseAuthorizedPage;
import pages.BasePage;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInGreen;

public class IssueInfoPage extends BaseAuthorizedPage {

    private static final String TITLE = "Страница информации о задаче проекта";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title = By.xpath("//span[@class = 'js-issue-title']");
    private final By statusImage = By.xpath("//div[contains(@class, 'flex-md-self-center')]/span");
    private final By description = By.xpath("//td[contains(@class, 'js-comment-body')]");
    private final By labels = By.xpath("//*[@class = 'lh-condensed-ultra']");

    public IssueInfoPage validateCreatedIssue(String titleText, String body, List<String> testLabels){
        printColorMessage("Проверка созданой задачи", log, Level.INFO);
        try {
            log.info("Проверка метки заголовка задачи");
            Assert.assertEquals(titleText, driver.findElement(title).getText());
            Assert.assertTrue(driver.findElement(statusImage).isDisplayed());
            log.info("Проверка тела задачи");
            Assert.assertEquals(body, driver.findElement(description).getText());

// ===== Лямбда-выражение =====
            driver.findElements(labels).forEach(label -> {
                        Assert.assertTrue(testLabels.contains(label.getText()));
                        testLabels.remove(label.getText());
                    });

// todo Код выше это конструкция Лямбда-выражение, можно заменить на код ниже
            List<WebElement> labelElements = driver.findElements(labels);
            for (WebElement label : labelElements){
                log.info("Проверка метки: " + label.getText());
                Assert.assertTrue(testLabels.contains(label.getText()));
                testLabels.remove(label.getText());
            }
    //        Assert.assertTrue(testLabels.isEmpty());
        } catch (NoSuchElementException n){
            Assert.fail("Задача создана не корректна" + n.getMessage());
        }
        printMessageInGreen("Проверка выполнена. Задача создана.", log);
        return this;
    }
}