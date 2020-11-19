package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.issues.IssuesPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueCreatingTest extends BaseTest{

    private IssuesPage page;

    private String title;
    private String body;
    private List<String> labels;

    public IssueCreatingTest(String title, String body, List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }
/*
    @Parameterized.Parameters
    public static Collection<Object> data(){
        "C:\Users\Admin\IdeaProjects\G46Automation\src\main\resources\data\isuues.txt"
        return
    }
*/
    @Before
    public void signIn(){
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProject()
                .openProjectIssues();
    }
/*
    @Test
    public void checkIssueCreation(){
        List<String> labels = new ArrayList<>();
        labels.add("bug");
        labels.add("good first issue");
        page.pressToCreateNewIssue()
                .createNewIssue("Automated title", "Test Body", labels)
                .validateCreatedIssue("Automated title", "Test Body", labels);
    }

 */
}