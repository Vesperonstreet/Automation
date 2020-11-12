package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import static helpers.ColorPrinter.printColorMessage;
import static helpers.Level.INFO;

public class IssueInfoPage extends BasePage {

    private static final String TITLE = "Страница информации о задаче проекта";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title = By.xpath("//span[@class = 'js-issue-title']");
    private final By statusImage = By.xpath("//div[contains(@class, 'flex-md-self-center')]/span");
    private final By discription = By.xpath("//td[contains(@class, 'js-comment-body')]");

    public IssueInfoPage validateCreatedIssue(String titletext, String body){
        printColorMessage("Проверка созданой задачи", log, Level.INFO);
        try {
            Assert.assertEquals(titletext, driver.findElement(title).getText());
            Assert.assertTrue(driver.findElement(statusImage).isDisplayed());
            Assert.assertEquals(body, driver.findElement(discription).getText());
        } catch (NoSuchElementException n){
            Assert.fail("Задача создана не корректна" + n.getMessage());
        }

        printColorMessage("Проверка выполнена. Задача создана.", log, Level.INFO);
        return this;
    }

}