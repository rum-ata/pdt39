package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC(){
    app.getContactHelper().gotoHomePage();
    if (!app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("test1", "middle1", "last1", "nick1", "test1"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    int indexC = beforeC.size()-1;
    ContactData contact = new ContactData(beforeC.get(indexC).getId(),"test1", "middle1", "last1", "nick1", null);
    app.getContactHelper().modifyContact(indexC, contact);
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size() );

    beforeC.remove(indexC);
    beforeC.add(contact);
    Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    beforeC.sort(byId);
    afterC.sort(byId);
    Assert.assertEquals(beforeC, afterC);
  }



}
