package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class IssuesPage extends BasePage {

    private static final String TITLE = "Страница создания задач";

    public IssuesPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By newIssuesButton = By.xpath("//a[@class = 'btn btn-primary']");

    public IssuesCreationPage pressToCreateNewIssue(){
        log.info("Нажимаем на \"Создать новую задачу\"");
        Assert.assertTrue(driver.findElement(newIssuesButton).isDisplayed());
        driver.findElement(newIssuesButton).click();
        log.info("Кнопка нажата");
        return new IssuesCreationPage(driver);
    }

}
