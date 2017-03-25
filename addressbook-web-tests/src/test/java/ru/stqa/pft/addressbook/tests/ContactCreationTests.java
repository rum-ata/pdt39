package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoNewContanctForm();
    app.getContactHelper().fillNewContanctForm(new ContactData("name1", "middle1", "last1", "nick1", "sir1", "Ford1", "US, Detroit", "+75550001122", "+79998887766", "+76667778899", "1234567890", "test@test.com", "test2@test.com", "test3@test.com", "www.test.com"));
    app.getContactHelper().submitNewContactForm();
    app.getContactHelper().gotoHomePage();
  }

}
