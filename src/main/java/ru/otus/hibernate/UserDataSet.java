package ru.otus.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDataSet extends DataSet {
    private int age;
    private String name;

    public UserDataSet() {
    }

    //@OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "user")
//    @Transient
//    private AdressDataSet adress;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public AdressDataSet getAdress() {
//        return adress;
//    }
//
//    public void setAdress(AdressDataSet adress) {
//        this.adress = adress;
//    }
}
