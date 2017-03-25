package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactBaseHelper {

  protected FirefoxDriver wd;

  public ContactBaseHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  protected void typeC(By locatorC, String textC) {
    clickC(locatorC);
    wd.findElement(locatorC).clear();
    wd.findElement(locatorC).sendKeys(textC);
  }

  protected void clickC(By locatorC) {
    wd.findElement(locatorC).click();
  }
}
