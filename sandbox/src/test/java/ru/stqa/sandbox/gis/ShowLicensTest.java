package ru.stqa.sandbox.gis;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShowLicensTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testShowLicens() throws Exception {
    wd.get("https://dom.gosuslugi.ru/#!/licenses");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Реестр лицензий субъекта: за пределами РФ'])[1]/following::button[1]")).click();
    wd.findElement(By.linkText("66-Свердловская область")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Очистить'])[1]/following::button[1]")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
