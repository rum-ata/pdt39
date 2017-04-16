package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.getContactHelper().gotoHomePage();
    int beforeC = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("test1", "name1", "middle1", "last1", "test1"));
    int afterC = app.getContactHelper().getContactCount();
    Assert.assertEquals(afterC, beforeC +1);
  }



}
