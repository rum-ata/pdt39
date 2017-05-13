package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();

    while (line != null){
      String[] split = line.split(";");
      File photo = new File("/src/test/resources/ava.png");
      list.add(new Object[]{new ContactData().withName(split[0]).withMiddle(split[1]).withLastname(split[2]).withNick(split[3]).withAddress(split[4])
              .withHomePhone(split[5]).withMobilPhone(split[6]).withWorkPhone(split[7])
              .withEmail(split[8]).withEmail2(split[9]).withEmail3(split[10]).withPhoto(photo).withGroup(split[11])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validContactsXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null){
      xml+=line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>)xStream.fromXML(xml);
    return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();

  }

  @Test (dataProvider = "validContactsXml")
  public void testContactCreation(ContactData contact) {

    app.contactC().gotoHomePage();
    Contacts beforeC = app.contactC().allC();
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
