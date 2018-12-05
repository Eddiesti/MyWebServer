package ru.otus.hibernate.entity;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.util.Collections;
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
        return
                "age=" + age +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                ", adress=" + adress;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataSet that = (UserDataSet) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                CollectionUtils.isEqualCollection(phones, that.phones) &&
                Objects.equals(adress, that.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, phones, adress);
    }

    public void setPhones(List<PhoneDataSet> phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
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
