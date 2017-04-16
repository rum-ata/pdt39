package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().gotoHomePage();
    if (!app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("test1", "name1", "middle1", "last1", "test1"));
    }
    int beforeC = app.getContactHelper().getContactCount();

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertDeletionContact();
    app.getContactHelper().gotoHomePage();
    int afterC = app.getContactHelper().getContactCount();
    Assert.assertEquals(afterC, beforeC -1);
  }

}
