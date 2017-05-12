package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k on 12.05.2017.
 */
public class ContactDataGenerator {

    @Parameter (names = "-c", description = "Contact count")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);

        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts (count);
        save (contacts, new File(file));
    }
//{"test1","middle1","last1","nick1","address","tel11","tel12","tel13","email11","email12","email13","test1"});
    private  void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact: contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getName(), contact.getMiddle(), contact.getLastname(), contact.getNick(),
                    contact.getAddress(), contact.getHomePhone(),contact.getMobilPhone(),contact.getWorkPhone(),
                    contact.getEmail(),contact.getEmail2(),contact.getEmail3(),
                    contact.getPhoto(),contact.getGroup()));
        }
        writer.close();
    }


    private  List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++){
            File photo = new File("/src/test/resources/ava.png");
            contacts.add(new ContactData().withName((String.format("test %s", i))).withMiddle((String.format("middle %s", i))).withLastname((String.format("last %s", i)))
                    .withNick((String.format("nick %s", i))).withAddress((String.format("address %s", i)))
                    .withHomePhone((String.format("111 %s", i))).withMobilPhone((String.format("222 %s", i))).withWorkPhone((String.format("222 %s", i)))
                    .withEmail((String.format("em1 %s", i))).withEmail2((String.format("em2 %s", i))).withEmail3((String.format("em3 %s", i)))
                    .withPhoto(photo).withGroup("test1"));
        }
        return contacts;
    }

}
