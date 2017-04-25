package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC(){
    app.contactC().gotoHomePage();
    if (app.contactC().allC().size() == 0) {
      app.contactC().createC(new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1"));
    }
  }


  @Test
  public void testContactDeletion() {
    Set<ContactData> beforeC = app.contactC().allC();
    ContactData deletedContact = beforeC.iterator().next();
    app.contactC().deleteC(deletedContact);
    Set<ContactData> afterC = app.contactC().allC();
    Assert.assertEquals(afterC.size(), beforeC.size() -1);

    beforeC.remove(deletedContact);
    Assert.assertEquals(beforeC, afterC);

  }



}
