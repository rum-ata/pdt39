package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Константин on 30.04.2017.
 */
public class ContactEmailTests extends TestBase {

  @Test
  public void testContactPhone() {
    app.contactC().gotoHomePage();
    ContactData contact = app.contactC().allC().iterator().next();
    ContactData contactInfoFromEditForm = app.contactC().infoFromEditForm(contact);

    assertThat(contact.getEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals("")).map(ContactEmailTests::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll(" [-()]", "");
  }

}
