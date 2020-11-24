package pages.code;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;
import pages.issues.IssuesPage;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInGreen;

public class ProjectPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница проекта";

    protected final By codeTab = By.xpath("//span[contains(text(), 'Code')]");
    private final By issuesTab = By.xpath("//span[@data-content = 'Issues']");
    protected final By pullRequestsTab = By.xpath("//span[contains(text(), 'Pull request')]");
    protected final By actionsTab = By.xpath("//span[@data-content= 'Actions']");
    protected final By projectsTab = By.xpath("//span[contains(text(), 'Projects')]");
    protected final By wikiTab = By.xpath("//span[contains(text(), 'Wiki')]");
    protected final By securityTab = By.xpath("//span[contains(text(), 'Security')]");
    protected final By insightsTab = By.xpath("//span[contains(text(), 'Insights')]");
    protected final By settingsTab = By.xpath("//span[contains(text(), 'Settings')]");

    public ProjectPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public IssuesPage openProjectIssues(){
        try {
            driver.findElement(issuesTab).click();
        } catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new IssuesPage(driver);
    }

    public ProjectPage validateTabs(){
        printColorMessage("Проверка отображения всех табов", log, Level.INFO);
        try {
            Assert.assertTrue(driver.findElement(codeTab).isDisplayed());
            Assert.assertTrue(driver.findElement(issuesTab).isDisplayed());
            Assert.assertTrue(driver.findElement(pullRequestsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(actionsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(projectsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(wikiTab).isDisplayed());
            Assert.assertTrue(driver.findElement(securityTab).isDisplayed());
            Assert.assertTrue(driver.findElement(insightsTab).isDisplayed());
            Assert.assertTrue(driver.findElement(settingsTab).isDisplayed());
        } catch (NoSuchElementException n){
            Assert.fail("Таб не найден: " + n.getMessage());
        }
        printMessageInGreen("Все табы присутствуют", log);
        return new ProjectPage(driver);
    }

}