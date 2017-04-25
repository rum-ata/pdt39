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
    if (app.contactC().listC().size() == 0) {
      app.contactC().createC(new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> beforeC = app.contactC().listC();
    int indexC = beforeC.size()-1;
    ContactData contact = new ContactData().withId(beforeC.get(indexC).getId()).withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1");
    app.contactC().modifyC(indexC, contact);
    List<ContactData> afterC = app.contactC().listC();
    Assert.assertEquals(afterC.size(), beforeC.size() );

    beforeC.remove(indexC);
    beforeC.add(contact);
    Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    beforeC.sort(byId);
    afterC.sort(byId);
    Assert.assertEquals(beforeC, afterC);
  }



}
