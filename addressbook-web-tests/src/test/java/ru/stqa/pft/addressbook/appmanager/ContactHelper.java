package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void createContact(ContactData contact) {
    gotoNewContanctForm();
    fillNewContanctForm(contact, true);
    submitNewContactForm();
    gotoHomePage();
  }

  public void closeAlertDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void gotoHomePage() {
    click(By.linkText("home page"));
  }

  public void submitNewContactForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContanctForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddle());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNick());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void submitModificationContact() {
    wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
  }

  public void fillSinglefieldContact() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("name_name1");
  }

  public void gotoModificationContactForm() {
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
  }

  public void gotoNewContanctForm() {
    click(By.linkText("add new"));
  }

  public boolean isContactPresent(){
    return isElementPresent(By.xpath("//div[@id='content']/form/input[21]"));
  }
}
