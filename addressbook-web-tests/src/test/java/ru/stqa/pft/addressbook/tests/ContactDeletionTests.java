package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().gotoHomePage();
    if (!app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("test1", "name1", "middle1", "last1", "test1"));
    }
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(beforeC.size()-1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertDeletionContact();
    app.getContactHelper().gotoHomePage();
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size() -1);

    beforeC.remove(beforeC.size()-1);
    Assert.assertEquals(beforeC, afterC);

  }

}
