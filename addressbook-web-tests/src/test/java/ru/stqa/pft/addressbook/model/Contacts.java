package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Константин on 26.04.2017.
 */
public class Contacts extends ForwardingSet<ContactData>{

  private Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return null;
  }

  public Contacts withAddedC(ContactData contact){
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;

  }

  public Contacts withOutC(ContactData contact){
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;

  }
}
