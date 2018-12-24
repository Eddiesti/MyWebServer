package ru.otus.hibernate.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adress")
public class AdressDataSet extends DataSet {
    private String street;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdressDataSet that = (AdressDataSet) o;
        return street.equals(that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street);
    }

    @OneToOne(mappedBy = "adress")
    private UserDataSet user;

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return
                "street='" + street;
    }
}
