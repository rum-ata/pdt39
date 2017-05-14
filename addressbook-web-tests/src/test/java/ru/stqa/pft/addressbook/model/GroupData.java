package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity //привязка к БД
@Table (name = "group_list") //привязка к таблице в БД
public class GroupData {
  @XStreamOmitField //в XStream пропускает следующее поле в генераторе xml (пропускает id)
  @Id //привязка к столбцу
  @Column (name = "group_id") //привязка к столбцу таблицы БД
    private int id = Integer.MAX_VALUE;

  @Column (name = "group_name")
  @Expose // в JSON добавляет поле в генераторе json (добавляет name)
  private String name;

  @Column (name = "group_header") //привязка к столбцу таблицы БД
  @Type(type = "text") //тип данных в столбце таблицы БД
  @Expose // в JSON добавляет поле в генераторе json (добавляет name)
  private String header;

  @Column (name = "group_footer") //привязка к столбцу таблицы БД
  @Type(type = "text") //тип данных в столбце таблицы БД
  @Expose // в JSON добавляет поле в генераторе json (добавляет name)
  private String footer;





  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}
