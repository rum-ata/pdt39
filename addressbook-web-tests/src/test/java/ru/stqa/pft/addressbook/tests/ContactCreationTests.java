package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {

    app.contactC().gotoHomePage();
    List<ContactData> beforeC = app.contactC().listC();
    ContactData contact = new ContactData("test1", "middle1", "last1", "nick1", "test1");
    app.contactC().createC(contact);
    List<ContactData> afterC = app.contactC().listC();
    Assert.assertEquals(afterC.size(), beforeC.size() +1);

    beforeC.add(contact);
    Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    beforeC.sort(byId);
    afterC.sort(byId);

    Assert.assertEquals(beforeC, afterC);
  }

}
