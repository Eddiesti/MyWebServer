package ru.otus.hibernate.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserDataSet extends DataSet {
    private int age;

    private String name;

    public UserDataSet() {
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<PhoneDataSet> phones;

    @Override
    public String toString() {
        return "UserDataSet{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                ", adress=" + adress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataSet that = (UserDataSet) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(phones, that.phones) &&
                Objects.equals(adress, that.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, phones, adress);
    }


    public void setPhones(List<PhoneDataSet> phones) {
        this.phones = phones;
    }

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADRESS_ID")
    private AdressDataSet adress;


    public void setAge(int age) {
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(AdressDataSet adress) {
        this.adress = adress;
    }
}
