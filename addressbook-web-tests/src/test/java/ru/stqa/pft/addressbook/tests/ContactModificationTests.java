package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    if (! app.getContactHelper().isContactPresent()){
      app.getContactHelper().createContact(new ContactData("test1","name1", "middle1", "last1", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().gotoModificationContactForm();
    app.getContactHelper().fillNewContanctForm(new ContactData("test1_test1","name1", "middle1", "last1", null), false);
    app.getContactHelper().submitModificationContact();
  }

}
