package ru.stqa.pft.addressbookTest4.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbookTest4.model.GroupDate;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final GroupHelper groupHelper = new GroupHelper();
    protected StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private GroupDate groupDate;

    public void openSite() {
        groupHelper.driver = new FirefoxDriver();
        //  baseUrl = "https://www.google.com/";
        groupHelper.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper.driver.get("http://localhost/addressbook/");
        groupHelper.driver.findElement(By.xpath("//html")).click();
    }

    public void login() {
    groupHelper.driver.findElement(By.id("LoginForm")).click();
    groupHelper.driver.findElement(By.name("user")).clear();
    groupHelper.driver.findElement(By.name("user")).sendKeys("admin");
    groupHelper.driver.findElement(By.id("LoginForm")).click();
    groupHelper.driver.findElement(By.name("pass")).clear();
    groupHelper.driver.findElement(By.name("pass")).sendKeys("secret");
    groupHelper.driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void returnGroup() {
        groupHelper.clickGroup();
    }

    public void logOut() {
        groupHelper.driver.findElement(By.linkText("Logout")).click();
        groupHelper.driver.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            groupHelper.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            groupHelper.driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = groupHelper.driver.switchTo().alert();
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

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
