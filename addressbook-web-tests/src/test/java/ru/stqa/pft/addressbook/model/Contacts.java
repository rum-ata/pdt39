package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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

  //конструктор для контактов из БД
  public Contacts(Collection<ContactData> contacts) {
    this.delegate = new HashSet<ContactData>(contacts);
  }

    @Override
  protected Set<ContactData> delegate() {
    return delegate;
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
