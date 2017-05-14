package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table (name = "addressbook")
@XStreamAlias("contact")
public class ContactData {

  @XStreamOmitField //в генераторе пропустит поле id
  @Id
  @Column (name = "id")
  private int id = Integer.MAX_VALUE;
  @Column (name = "firstname")
  //@Type(type = "text")
  private String name;

  @Transient
  private String middle;

  @Column (name = "lastname")
  //@Type(type = "text")
  private String lastname;

  @Transient
  private String nick;

  @Column (name = "home")
  @Type(type = "text")
  private String homePhone;
  @Column (name = "mobile")
  @Type(type = "text")
  private String mobilPhone;
  @Column (name = "work")
  @Type(type = "text")
  private String workPhone;

  @Transient
  private String allPhones;
  @Transient
  private String emails;
  @Transient
  private String email;
  @Transient
  private String email2;
  @Transient
  private String email3;

  @Transient
  private  String address;

  @Column (name = "photo")
  @Type(type = "text")
  private String photo;

  @Transient
  private String group;



  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmails(String emails) {
    this.emails = emails;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

    public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withMiddle(String middle) {
    this.middle = middle;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilPhone(String mobilPhone) {
    this.mobilPhone = mobilPhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public File getPhoto() {
    return new File(photo);
  }

  public String getAddress() {
    return address;
  }

  public String getEmails() {
    return emails;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail3() {
    return email3;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail() {
    return email;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilPhone() {
    return mobilPhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMiddle() {
    return middle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", middle='" + middle + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nick='" + nick + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilPhone='" + mobilPhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", emails='" + emails + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", address='" + address + '\'' +
            ", photo='" + photo + '\'' +
            ", group='" + group + '\'' +
            '}';
  }


}
