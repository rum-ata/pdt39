package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getContactHelper().gotoHomePage();
    if (!app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("test1", "middle1", "last1", "nick1", "test1"));
    }
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(beforeC.size() -1);
    app.getContactHelper().gotoModificationContactForm();
    ContactData contact = new ContactData(beforeC.get(beforeC.size()-1).getId(),"test1", "middle1", "last1", "nick1", null);
    app.getContactHelper().fillNewContactForm(contact, false);
    app.getContactHelper().submitModificationContact();
    app.getContactHelper().gotoHomePage();
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size() );

    beforeC.remove(beforeC.size() -1);
    beforeC.add(contact);
    Assert.assertEquals(new HashSet<Object>(beforeC), new HashSet<Object>(afterC));
  }

}
