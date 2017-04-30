package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Константин on 30.04.2017.
 */
public class ContactPhoneTests extends TestBase {

  @Test (enabled = false)
  public void testContactPhone(){
    app.contactC().gotoHomePage();
    ContactData contact = app.contactC().allC().iterator().next();
    ContactData contactInfoFromEditForm = app.contactC().infoFromEditForm(contact);
  }

}
