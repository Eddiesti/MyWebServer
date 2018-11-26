package ru.otus.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class AdressDataSet extends DataSet {

    private String street;

    @Override
    public String toString() {
        return "AdressDataSet{" +
                "street='" + street + '\'' +
                ", user=" + user +
                '}';
    }

    @OneToOne(mappedBy = "adress")
    private UserDataSet user;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public UserDataSet getUser() {
        return user;
    }

    public void setUser(UserDataSet user) {
        this.user = user;
    }
}
