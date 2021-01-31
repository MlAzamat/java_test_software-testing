package ru.stqa.pft.addressbookTest4;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class CreateGroup {


    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        openSite();
        login();
    }

    private void openSite() {
        driver = new FirefoxDriver();
        //  baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.xpath("//html")).click();
    }

    private void login() {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        newGroup();
        fillNewGroup("111", "1112", "1113");
        saveNewGroup();
        returnGroup();
    }

    private void returnGroup() {
        driver.findElement(By.linkText("groups")).click();
    }

    private void saveNewGroup() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillNewGroup(String text1, String text2, String text3) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(text1);
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(text2);
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(text3);
    }

    private void newGroup() {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        logOut();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private void logOut() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}
