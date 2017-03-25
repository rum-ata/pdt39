package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ContactApplicationManager;

/**
 * Created by Константин on 25.03.2017.
 */
public class TestBaseContact {

  protected final ContactApplicationManager appC = new ContactApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    appC.initC();
  }

  @AfterMethod
  public void tearDown() {
    appC.stopC();
  }

  public ContactApplicationManager getAppC() {
    return appC;
  }
}
