package ru.stqa.pft.addressbookTest3;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCreateGroup {

    public static class UntitledTestCase {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @BeforeClass(alwaysRun = true)
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "https://www.google.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            login();
        }

        private void login() {
            driver.get("http://localhost/addressbook/");
            driver.findElement(By.linkText("groups")).click();
        }

        @Test
        public void testUntitledTestCase() throws Exception {

            clickNewCreateGroup("new");
            clickNameField();
            clearNameField();
            fillNameField();
            driver.findElement(By.name("group_header")).click();
            driver.findElement(By.name("group_header")).clear();
            driver.findElement(By.name("group_header")).sendKeys("test2");
            driver.findElement(By.name("group_footer")).click();
            driver.findElement(By.name("group_footer")).clear();
            driver.findElement(By.name("group_footer")).sendKeys("test3");
            driver.findElement(By.name("submit")).click();
        }

        private void fillNameField() {
            driver.findElement(By.name("group_name")).sendKeys("test1");
        }

        private void clearNameField() {
            driver.findElement(By.name("group_name")).clear();
        }

        private void clickNameField() {
            driver.findElement(By.name("group_name")).click();
        }

        private void clickNewCreateGroup(String s) {
            driver.findElement(By.name(s)).click();
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
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
}
