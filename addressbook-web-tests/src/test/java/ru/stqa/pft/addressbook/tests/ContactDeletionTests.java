package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isContactPresent()){
      app.getContactHelper().createContact(new ContactData("test1","name1", "middle1", "last1", "test1"));
    }

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeAlertDeletionContact();
  }

}
