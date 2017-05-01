package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test

  public void testContactCreation() {

    app.contactC().gotoHomePage();
    Contacts beforeC = app.contactC().allC();
    File photo = new File("/src/test/resources/ava.png");
    ContactData contact = new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1")
            .withAddress("мой адрес не дом и не улица")
            .withHomePhone("111").withMobilPhone("222").withWorkPhone("333")
            .withEmail("q1@q.com").withEmail2("q2@q.com").withEmail3("q3@q.com")
            .withPhoto(photo)
            .withGroup("test1");

    app.contactC().createC(contact);
    assertThat(app.contactC().countC(), equalTo(beforeC.size() + 1));
    Contacts afterC = app.contactC().allC();
    assertThat(afterC, equalTo(beforeC.withAddedC(contact.withId(afterC.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/ava.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

  @Test (enabled = false)

  public void testBadContactCreation() {

    app.contactC().gotoHomePage();
    Contacts beforeC = app.contactC().allC();
    //добавить контакт с "плохим" именем
    ContactData contact = new ContactData().withName("test1'").withMiddle("middle1").withLastname("last1").withNick("nick1")
            .withAddress("мой адрес не дом и не улица")
            .withHomePhone("111").withMobilPhone("222").withWorkPhone("333")
            .withEmail("q1@q.com").withEmail2("q2@q.com").withEmail3("q3@q.com")
            .withGroup("test1");

    app.contactC().createC(contact);
    assertThat(app.contactC().countC(), equalTo(beforeC.size()));
    Contacts afterC = app.contactC().allC();

    assertThat(afterC, equalTo(beforeC));
  }

}
