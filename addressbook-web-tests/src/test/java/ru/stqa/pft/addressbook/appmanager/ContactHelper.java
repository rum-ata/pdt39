package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactHelper extends ContactBaseHelper{


  public ContactHelper(FirefoxDriver wd) {
    super(wd);

  }

  public void gotoHomePage() {
    clickC(By.linkText("home page"));
  }


  public void submitNewContactForm() {
    clickC(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContanctForm(ContactData contactData) {
    typeC(By.name("firstname"), contactData.getName());
    typeC(By.name("middlename"), contactData.getMiddle());
    typeC(By.name("lastname"), contactData.getLastname());
    typeC(By.name("nickname"), contactData.getNick());
    typeC(By.name("title"), contactData.getTittle());
    typeC(By.name("company"), contactData.getCompany());
    typeC(By.name("address"), contactData.getAddress());
    typeC(By.name("home"), contactData.getHome());
    typeC(By.name("mobile"), contactData.getMobile());
    typeC(By.name("work"), contactData.getWork());
    typeC(By.name("fax"), contactData.getFax());
    typeC(By.name("email"), contactData.getEmail());
    typeC(By.name("email2"), contactData.getEmail2());
    typeC(By.name("email3"), contactData.getEmail3());
    typeC(By.name("homepage"), contactData.getHomepage());
  }


  public void gotoNewContanctForm() {
    clickC(By.linkText("add new"));
  }

  public void closeAlertDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    clickC(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
    clickC(By.name("selected[]"));
  }

  public  boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
