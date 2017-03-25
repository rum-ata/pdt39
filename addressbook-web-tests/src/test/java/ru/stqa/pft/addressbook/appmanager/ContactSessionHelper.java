package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactSessionHelper {
  private FirefoxDriver wd;

  public ContactSessionHelper(FirefoxDriver wd) {

    this.wd = wd;
  }
  public void login() {

    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}
