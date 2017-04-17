package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.getContactHelper().gotoHomePage();
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("test1", "middle1", "last1", "nick1", "test1"));
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size() +1);
  }



}
