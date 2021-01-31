package ru.stqa.pft.addressbookTest4.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();



  @Test
  public void testUntitledTestCase() throws Exception {
    app.clickGroup();
    app.deleteGroup();
    app.returnGroup();
  }

}
