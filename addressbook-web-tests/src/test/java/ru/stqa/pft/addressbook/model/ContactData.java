package ru.stqa.pft.addressbook.model;

public class ContactData {
  private String group;
  private final String name;
  private final String middle;
  private final String lastname;
  private final String nick;

  public void setId(int id) {
    this.id = id;
  }

  private  int id;


  public String getLastname() {
    return lastname;
  }

  public int getId() {
    return id;
  }

  public ContactData(String name, String middle, String lastname, String nick, String group) {
    this.id = Integer.MAX_VALUE;
    this.group = group;
    this.name = name;
    this.middle = middle;
    this.lastname = lastname;
    this.nick = nick;
  }


  public ContactData(int id, String name, String middle, String lastname, String nick, String group) {
    this.id = id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

}
