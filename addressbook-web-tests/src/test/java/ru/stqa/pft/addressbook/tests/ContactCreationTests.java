package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {

    app.contactC().gotoHomePage();
    Contacts beforeC = app.contactC().allC();
    ContactData contact = new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1");
    app.contactC().createC(contact);
    assertThat(app.contactC().countC(), equalTo(beforeC.size() +1));
    Contacts afterC = app.contactC().allC();
    assertThat(afterC, equalTo(beforeC.withAddedC(contact.withId(afterC.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test

  public void testBadContactCreation() {

    app.contactC().gotoHomePage();
    Contacts beforeC = app.contactC().allC();
    //добавить контакт с "плохим" именем
    ContactData contact = new ContactData().withName("test1'").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1");
    app.contactC().createC(contact);
    assertThat(app.contactC().countC(), equalTo(beforeC.size()));
    Contacts afterC = app.contactC().allC();

    assertThat(afterC, equalTo(beforeC));
  }

}
