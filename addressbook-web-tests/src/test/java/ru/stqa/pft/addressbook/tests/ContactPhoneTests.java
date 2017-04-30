package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Константин on 30.04.2017.
 */
public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhone(){
    app.contactC().gotoHomePage();
    ContactData contact = app.contactC().allC().iterator().next();
    ContactData contactInfoFromEditForm = app.contactC().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilPhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilPhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
  }

  public String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll(" [-()]","");
  }

}
