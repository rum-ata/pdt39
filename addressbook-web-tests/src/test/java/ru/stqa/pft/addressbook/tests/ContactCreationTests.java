package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {

    app.contactC().gotoHomePage();
    Set<ContactData> beforeC = app.contactC().allC();
    ContactData contact = new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1");
    app.contactC().createC(contact);
    Set<ContactData> afterC = app.contactC().allC();
    Assert.assertEquals(afterC.size(), beforeC.size() +1);

    contact.withId(afterC.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    beforeC.add(contact);
    Assert.assertEquals(beforeC, afterC);
  }

}
