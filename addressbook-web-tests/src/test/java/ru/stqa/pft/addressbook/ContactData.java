package ru.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String middle;
  private final String lastname;
  private final String nick;
  private final String tittle;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;

  public ContactData(String name, String middle, String lastname, String nick, String tittle, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage) {
    this.name = name;
    this.middle = middle;
    this.lastname = lastname;
    this.nick = nick;
    this.tittle = tittle;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
  }

  public String getName() {
    return name;
  }

  public String getMiddle() {
    return middle;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getTittle() {
    return tittle;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }
}
