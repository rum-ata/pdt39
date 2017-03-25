package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBaseContact {

  @Test
  public void testContactDeletion() {

    appC.getContactHelper().selectContact();
    appC.getContactHelper().deleteSelectedContact();
    appC.getContactHelper().closeAlertDeletionContact();
  }

}
