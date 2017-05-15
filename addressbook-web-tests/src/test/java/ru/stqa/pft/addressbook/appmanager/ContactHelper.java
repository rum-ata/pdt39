package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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




  public void gotoNewContactForm() {
    click(By.linkText("add new"));
  }

  public void fillNewContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddle());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNick());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilPhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("address"), contactData.getAddress());
    //attach(By.name("photo"), contactData.getPhoto());

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

  public void gotoModificationContactForm(int id) {
        wd.findElement(By.xpath("//a[@href=\"edit.php?id=" + id + "\"]")).click();
  }

  public void submitModificationContact() {
    wd.findElement(By.name("update")).click();
  }

  public void createC(ContactData contact) {
    gotoNewContactForm();
    fillNewContactForm(contact, true);
    submitNewContactForm();
    contactCache = null;
    gotoHomePage();
  }

  public void modifyC(ContactData contact) {
    //selectContactById(contact.getId());
    gotoModificationContactForm(contact.getId());
    fillNewContactForm(contact, false);
    submitModificationContact();
    contactCache = null;
    gotoHomePage();
  }

  public void deleteC(ContactData contact) {

    selectContactById(contact.getId());
    deleteSelectedContact();
    closeAlertDeletionContact();
    contactCache = null;
    gotoHomePage();
  }


  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public boolean isContactPresent() {
    return isElementPresent(By.name("selected[]"));
  }

  public int countC() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts allC() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row: rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lName = cells.get(1).getText();
      String fName = cells.get(2).getText();
      String address = cells.get(3).getText();
      String emails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();

      contactCache.add(new ContactData().withId(id).withName(fName).withLastname(lName)
              .withAddress(address)
              .withAllPhones(allPhones)
              .withEmails(emails));
    }
    return new Contacts(contactCache);
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobil  = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2  = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    return new ContactData().withId(contact.getId()).withName(firstname).withLastname(lastname)
            .withAddress(address)
            .withHomePhone(home).withMobilPhone(mobil).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cell = row.findElements(By.tagName("td"));
    cell.get(7).findElement(By.tagName("a")).click();

    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    //wd.findElement(By.cssSelector(String.format("a[hreh='edit.php?id=%s']", id))).click();


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
