package tests.ui.issues;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.issues.IssuesPage;
import tests.ui.BaseTest;

import java.util.Collection;
import java.util.List;

import static helpers.ExcelHelper.readDataFromExcelFile;
import static helpers.FileHelper.readDataFromTxtFile;

@RunWith(Parameterized.class)
public class IssueCreatingFromExcelFileTest extends BaseTest {

    private IssuesPage page;
    private boolean systemProperties;

    private String title;
    private String body;
    private List<String> labels;

    public IssueCreatingFromExcelFileTest(String title, String body, List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        if (System.getProperty("readFromExcel").equals("true")) {
            return readDataFromExcelFile(
                    "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\issueData.xlsx",
                    "Sheet1");
        }
        else {
            return readDataFromTxtFile(
                    "C:\\Users\\Admin\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\issueData.txt");
        }
    }

    @Before
    public void signIn() {
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProject()
                .openProjectIssues();
    }

    @Test
    public void checkIssueCreation() {
        page.pressToCreateNewIssue()
                .createNewIssue(this.title, this.body, this.labels)
                .validateCreatedIssue(this.title, this.body, this.labels);
    }

    @After
    public void tearDown() {
        page.logout()
                .validateLogout();
    }
}