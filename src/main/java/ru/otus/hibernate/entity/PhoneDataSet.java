package ru.otus.hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "phones")

public class PhoneDataSet extends DataSet {
    private String number;
    @ManyToOne(optional = false)
    private UserDataSet user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneDataSet that = (PhoneDataSet) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return
                "number='" + number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUsers(UserDataSet users) {
        this.user = users;
    }
}
