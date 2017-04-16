package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 25.03.2017.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }



  public void createContact(ContactData contact) {
    gotoNewContactForm();
    fillNewContactForm(contact, true);
    submitNewContactForm();
    gotoHomePage();
  }

  public void closeAlertDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact(int indexC) {
    wd.findElements(By.name("selected[]")).get(indexC).click();
    //click(By.name("selected[]"));
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
    wd.findElement(By.linkText("home")).click();
  }

  public void submitNewContactForm() {
    click(By.name("submit"));
  }

  public void fillNewContactForm(ContactData contactData, boolean creation) {

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
    wd.findElement(By.name("update")).click();
  }

  public void gotoModificationContactForm() {
    wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img")).click();
  }

  public void gotoNewContactForm() {
    click(By.linkText("add new"));
  }

  public boolean isContactPresent() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    int sizeContactList = wd.findElements(By.name("selected[]")).size();

    for (int i = 1; i <= sizeContactList; i++){
      String fName = wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr["+(i+1)+"]/td[3]")).getText();
      String lName = wd.findElement(By.xpath("//div/div[4]/form[2]/table/tbody/tr["+(i+1)+"]/td[2]")).getText();
      ContactData contact = new ContactData(fName, null,lName, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

  /* заполнение полей формы Контакта
  public void fillSinglefieldContact() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("name_name1");
  }
*/
}
