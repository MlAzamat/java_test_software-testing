package ru.stqa.pft.addressbookTest4;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected StringBuffer verificationErrors = new StringBuffer();
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private GroupDate groupDate;

    protected void openSite() {
        driver = new FirefoxDriver();
        //  baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.xpath("//html")).click();
    }

    protected void login() {
    driver.findElement(By.id("LoginForm")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.id("LoginForm")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void returnGroup() {
        driver.findElement(By.linkText("groups")).click();
    }

    protected void saveNewGroup() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillNewGroup(GroupDate groupDate) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupDate.getText1());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupDate.getText2());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupDate.getText3());
    }

    protected void newGroup() {
        driver.findElement(By.name("new")).click();
    }

    protected void logOut() {
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

    protected void clickGroup() {
      driver.findElement(By.linkText("groups")).click();
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

    protected void deleteGroup() {
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.name("delete")).click();
    }
}
