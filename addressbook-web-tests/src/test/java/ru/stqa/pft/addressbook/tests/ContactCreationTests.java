package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoNewContanctForm();
    app.getContactHelper().fillNewContanctForm(new ContactData("test1","name1", "middle1", "last1", "test1"), true);
    app.getContactHelper().submitNewContactForm();
    app.getContactHelper().gotoHomePage();
  }

}
