package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC(){
    app.contactC().gotoHomePage();
    if (app.contactC().allC().size() == 0) {
      app.contactC().createC(new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> beforeC = app.contactC().allC();
    ContactData modifiedContact = beforeC.iterator().next();

    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1");
    app.contactC().modifyC(contact);
    Set<ContactData> afterC = app.contactC().allC();
    Assert.assertEquals(afterC.size(), beforeC.size() );

    beforeC.remove(modifiedContact);
    beforeC.add(contact);
    Assert.assertEquals(beforeC, afterC);
  }



}
