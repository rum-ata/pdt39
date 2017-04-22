package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

public class ContactModificationTests extends TestBase {

  @Test (enabled = false)
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
    Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    beforeC.sort(byId);
    afterC.sort(byId);
    Assert.assertEquals(beforeC, afterC);
  }

}
