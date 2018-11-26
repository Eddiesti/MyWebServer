package ru.otus.hibernate.entity;

import javax.persistence.*;

@Entity(name = "phones")

public class PhoneDataSet extends DataSet {
    private String number;
    @ManyToOne(optional = false)
    private UserDataSet user;

    @Override
    public String toString() {
        return "PhoneDataSet{" +
                "number='" + number + '\'' +
                '}';
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUsers(UserDataSet users) {
        this.user = users;
    }
}
