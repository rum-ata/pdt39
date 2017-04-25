package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC(){
    app.contactC().gotoHomePage();
    if (app.contactC().listC().size() == 0) {
      app.contactC().createC(new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1"));
    }
  }


  @Test
  public void testContactDeletion() {
    List<ContactData> beforeC = app.contactC().listC();
    int indexC = beforeC.size()-1;
    app.contactC().deleteC(indexC);
    List<ContactData> afterC = app.contactC().listC();
    Assert.assertEquals(afterC.size(), beforeC.size() -1);

    beforeC.remove(indexC);
    Assert.assertEquals(beforeC, afterC);

  }



}
