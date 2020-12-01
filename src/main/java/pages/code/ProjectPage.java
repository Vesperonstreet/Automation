package pages.code;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseAuthorizedPage;
import pages.issues.IssuesPage;
import pages.settings.SettingsPage;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInGreen;
import static helpers.ColorPrinter.printTabsNamesWithDifferentColors;

public class ProjectPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница проекта";

    private final By codeTab = By.xpath("//span[contains(text(), 'Code')]");
    private final By issuesTab = By.xpath("//span[@data-content = 'Issues']");
    private final By pullRequestsTab = By.xpath("//span[contains(text(), 'Pull request')]");
    private final By actionsTab = By.xpath("//span[@data-content= 'Actions']");
    private final By projectsTab = By.xpath("//span[contains(text(), 'Projects')]");
    private final By wikiTab = By.xpath("//span[contains(text(), 'Wiki')]");
    private final By securityTab = By.xpath("//span[contains(text(), 'Security')]");
    private final By insightsTab = By.xpath("//span[contains(text(), 'Insights')]");
    private final By settingsTab = By.xpath("//span[contains(text(), 'Settings')]");

    private final By repoLink = By.xpath("//a[@data-pjax=\"#js-repo-pjax-container\"]");

    private final By tabsList = By.xpath("//li[(@class='d-flex') and not(contains(@class,'Counter '))]");
    protected By tabs = By.xpath("//span[@data-content]");


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

    public void colorfulTabsNames() {
        List<WebElement> tabsList = driver.findElements(tabs);
        printMessageInGreen("Список всех доступных табов: ");
        printTabsNamesWithDifferentColors(tabsList);
        log.info("Список табов напечатан");

    }

    public SettingsPage openSettingsPage(){
        try {
            driver.findElement(settingsTab).click();
        } catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new SettingsPage(driver);
    }

    public ProjectPage validateRenaming(String expectedTitle){
        Assert.assertTrue(driver.findElement(repoLink).getText().endsWith(expectedTitle));
        return this;
    }

}