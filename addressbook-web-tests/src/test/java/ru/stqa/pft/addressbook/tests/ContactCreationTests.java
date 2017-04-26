package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {

    app.contactC().gotoHomePage();
    Contacts beforeC = app.contactC().allC();
    ContactData contact = new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1").withGroup("test1");
    app.contactC().createC(contact);
    Contacts afterC = app.contactC().allC();
    assertThat(afterC.size(), equalTo(beforeC.size() +1));
    assertThat(afterC, equalTo(beforeC.withAddedC(contact.withId(afterC.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
