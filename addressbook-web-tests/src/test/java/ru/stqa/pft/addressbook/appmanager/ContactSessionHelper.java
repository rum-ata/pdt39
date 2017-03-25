package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactSessionHelper extends ContactBaseHelper{


  public ContactSessionHelper(FirefoxDriver wd) {

    super(wd);
  }
  public void login(String username,String password) {

    typeC(By.name("user"),username);
    typeC(By.name("pass"), password);
    clickC(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
