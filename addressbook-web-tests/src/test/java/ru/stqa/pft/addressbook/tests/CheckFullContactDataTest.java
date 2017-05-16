package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by k.smotrov on 16.05.2017.
 */
public class CheckFullContactDataTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditionsC() {
        app.contactC().gotoHomePage();
        if (app.contactC().allC().size() == 0) {
            app.contactC().createC(new ContactData().withName("test1").withMiddle("middle1").withLastname("last1").withNick("nick1")
                    .withAddress("мой адрес не дом и не улица")
                    .withHomePhone("111").withMobilPhone("222").withWorkPhone("333")
                    .withEmail("q1@q.com").withEmail2("q2@q.com").withEmail3("q3@q.com"));
        }
    }

    @Test
    public void testFullContact(){
        ContactData contact = app.contactC().allC().iterator().next();
        String contentFromFullDataPage = app.contactC().infoFromFullDataPage(contact); //получение данных со страницы подробной информации
        app.contactC().gotoHomePage(); //возврат на главную
        String contentInfoFromEditForm = app.contactC().madeContentInfoFromEditForm(contact); //пполучение данных со страницы редактирования
        assertThat(contentFromFullDataPage, equalTo(contentInfoFromEditForm));
        app.contactC().gotoHomePage(); //возврат на главную

    }


}
