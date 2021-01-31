package ru.stqa.pft.addressbookTest4.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbookTest4.model.GroupDate;

public class GroupHelper {
    protected WebDriver driver;

    public void saveNewGroup() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillNewGroup(GroupDate groupDate) {
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

    public void newGroup() {
        driver.findElement(By.name("new")).click();
    }

    public void clickGroup() {
      driver.findElement(By.linkText("groups")).click();
    }

    public void deleteGroup() {
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.name("delete")).click();
    }
}
