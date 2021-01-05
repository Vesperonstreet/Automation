package tests;

import org.junit.Test;

import static helpers.DbHelper.executeQueryWithResult;

public class DebugTest {

    @Test
    public void checkDb() {
        System.out.println(executeQueryWithResult("select * from data.users",
                "id", "username", "password"));
    }
}