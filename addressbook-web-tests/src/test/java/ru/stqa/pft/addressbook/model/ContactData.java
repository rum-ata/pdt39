package ru.stqa.pft.addressbook.model;

public class ContactData {
  private String group;
  private final String name;
  private final String middle;
  private final String lastname;
  private final String nick;


  public ContactData( String name, String middle, String lastname, String nick, String group) {
    this.group = group;
    this.name = name;
    this.middle = middle;
    this.lastname = lastname;
    this.nick = nick;

  }

  public String getName() {
    return name;
  }

  public String getMiddle() {
    return middle;
  }

  public String getLastName() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getGroup() {
    return group;
  }


}
