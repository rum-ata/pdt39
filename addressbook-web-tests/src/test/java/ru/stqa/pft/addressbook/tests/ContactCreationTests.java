package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.getContactHelper().gotoHomePage();
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("test1", "middle1", "last1", "nick1", "test1");
    app.getContactHelper().createContact(contact);
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size() +1);


    int max = 0;
    for (ContactData c: afterC){
      if (c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);
    beforeC.add(contact);
    Assert.assertEquals(new HashSet<Object>(beforeC), new HashSet<Object>(afterC));
  }

}
