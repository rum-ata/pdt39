package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Константин on 30.04.2017.
 */
public class ContactAddressTests extends TestBase {

  @Test
  public void testContactPhone() {
    app.contactC().gotoHomePage();
    ContactData contact = app.contactC().allC().iterator().next();
    ContactData contactInfoFromEditForm = app.contactC().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }


}
