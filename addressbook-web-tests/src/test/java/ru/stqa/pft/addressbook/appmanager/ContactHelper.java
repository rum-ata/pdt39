package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void createC(ContactData contact) {
    gotoNewContactForm();
    fillNewContactForm(contact, true);
    submitNewContactForm();
    gotoHomePage();
  }

  public void gotoNewContactForm() {
    click(By.linkText("add new"));
  }

  public void fillNewContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddle());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNick());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitNewContactForm() {
    click(By.name("submit"));
  }

  public void closeAlertDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }



  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
  }

  public void gotoModificationContactForm() {
    int i = wd.findElements(By.name("selected[]")).size();
    wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr["+(i+1)+"]/td[8]/a/img")).click();
  }

  public void submitModificationContact() {
    wd.findElement(By.name("update")).click();
  }

  public void modifyC(ContactData contact) {
    selectContactById(contact.getId());
    gotoModificationContactForm();
    fillNewContactForm(contact, false);
    submitModificationContact();
    gotoHomePage();
  }





  public void deleteC(ContactData contact) {

    selectContactById(contact.getId());
    deleteSelectedContact();
    closeAlertDeletionContact();
    gotoHomePage();
  }


  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public boolean isContactPresent() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }



  public Set<ContactData> allC() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    int sizeContactList = wd.findElements(By.name("selected[]")).size();
    for (int i = 1; i <= sizeContactList; i++){
      String fName = wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr["+(i+1)+"]/td[3]")).getText();
      String lName = wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr["+(i+1)+"]/td[2]")).getText();
      int id = Integer.parseInt(wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr["+(i+1)+"]/td[1]/input")).getAttribute("id"));
      ContactData contact = new ContactData().withId(id).withName(fName).withLastname(lName);
      contacts.add(contact);
    }
    return contacts;
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }



}
