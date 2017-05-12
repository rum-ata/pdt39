package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContact(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{"test1","middle1","last1","nick1","address","tel11","tel12","tel13","email11","email12","email13","/src/test/resources/ava.png","test1"});
    list.add(new Object[]{"test1","middle1","last1","nick1","address","tel11","tel12","tel13","email11","email12","email13","/src/test/resources/ava.png","test1"});
    list.add(new Object[]{"test1","middle1","last1","nick1","address","tel11","tel12","tel13","email11","email12","email13","/src/test/resources/ava.png","test1"});
    return list.iterator();
  }

  @Test (dataProvider = "validContact")
  public void testContactCreation(String name, String middle, String last, String nick, String address, String hPhone, String mPhone, String wPhone,
                                  String em1, String em2, String em3, String foto, String gr) {

    app.contactC().gotoHomePage();
    Contacts beforeC = app.contactC().allC();
    File photo = new File(foto);
    ContactData contact = new ContactData().withName(name).withMiddle(middle).withLastname(last).withNick(nick)
            .withAddress(address)
            .withHomePhone(hPhone).withMobilPhone(mPhone).withWorkPhone(wPhone)
            .withEmail(em1).withEmail2(em2).withEmail3(em3)
            .withPhoto(photo)
            .withGroup(gr);

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
