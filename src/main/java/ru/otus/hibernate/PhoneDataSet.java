package ru.otus.hibernate;

import ru.otus.test.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "phones")
public class PhoneDataSet extends DataSet {
    private String number;
    @ManyToOne(optional = false)
    private UserDataSet user;

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhoneDataSet{" +
                "number='" + number + '\'' +
                ", user=" + user +
                '}';
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserDataSet getUsers() {
        return user;
    }

    public void setUsers(UserDataSet users) {
        this.user = users;
    }
}
