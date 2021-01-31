package ru.stqa.pft.addressbookTest4.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.addressbookTest4.appManager.ApplicationManager;

import static org.testng.Assert.fail;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.openSite();
        app.login();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.logOut();
        /*String verificationErrorString = app.verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }*/
    }


}
