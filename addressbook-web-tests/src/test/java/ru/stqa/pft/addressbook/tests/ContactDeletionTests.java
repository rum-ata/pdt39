package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC() {
    app.contactC().gotoHomePage();
    if (app.db().contacts().size() == 0) {
      app.contactC().createC(new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1")
              .withAddress("мой адрес не дом и не улица")
              .withHomePhone("111").withMobilPhone("222").withWorkPhone("333")
              .withEmail("q1@q.com").withEmail2("q2@q.com").withEmail3("q3@q.com"));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts beforeC = app.db().contacts();
    ContactData deletedContact = beforeC.iterator().next();
    app.contactC().deleteC(deletedContact);
    assertThat(app.contactC().countC(), equalTo(beforeC.size() - 1));
    Contacts afterC = app.db().contacts();
    assertThat(afterC, equalTo(beforeC.withOutC(deletedContact)));
  }


}
