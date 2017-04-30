package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC() {
    app.contactC().gotoHomePage();
    if (app.contactC().allC().size() == 0) {
      app.contactC().createC(new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1")
              .withHomePhone("111").withMobilPhone("222").withWorkPhone("333").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts beforeC = app.contactC().allC();
    ContactData modifiedContact = beforeC.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1")
            .withHomePhone("111").withMobilPhone("222").withWorkPhone("333").withGroup("test1");

    app.contactC().modifyC(contact);
    assertThat(app.contactC().countC(), equalTo(beforeC.size()));
    Contacts afterC = app.contactC().allC();
    assertThat(afterC, equalTo(beforeC.withOutC(modifiedContact).withAddedC(contact)));
  }

}
