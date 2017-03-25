package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactApplicationManager {

  FirefoxDriver wd;

  private  ContactHelper contactHelper;
  private ContactSessionHelper contactSessionHelper;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void initC() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    contactHelper = new ContactHelper(wd);
    contactSessionHelper = new ContactSessionHelper(wd);
    contactSessionHelper.login();
  }



  public void stopC() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
