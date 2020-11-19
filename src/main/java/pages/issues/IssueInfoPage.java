package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInGreen;

public class IssueInfoPage extends BasePage {

    private static final String TITLE = "Страница информации о задаче проекта";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title = By.xpath("//span[@class = 'js-issue-title']");
    private final By statusImage = By.xpath("//div[contains(@class, 'flex-md-self-center')]/span");
    private final By description = By.xpath("//td[contains(@class, 'js-comment-body')]");
    private final By labels = By.xpath("");

    public IssueInfoPage validateCreatedIssue(String titletext, String body){
        printColorMessage("Проверка созданой задачи", log, Level.INFO);
        try {
            Assert.assertEquals(titletext, driver.findElement(title).getText());
            Assert.assertTrue(driver.findElement(statusImage).isDisplayed());
            Assert.assertEquals(body, driver.findElement(description).getText());
            List<WebElement> labelElements = driver.findElements(labels);
            for (WebElement label : labelElements){
    //            Assert.assertTrue(testLabels.contains(label.getText()));
    //            testLabels.remove(label.getText());
            }
    //        Assert.assertTrue(testLabels.isEmpty());
        } catch (NoSuchElementException n){
            Assert.fail("Задача создана не корректна" + n.getMessage());
        }
        printMessageInGreen("Проверка выполнена. Задача создана.", log);
        return this;
    }
}