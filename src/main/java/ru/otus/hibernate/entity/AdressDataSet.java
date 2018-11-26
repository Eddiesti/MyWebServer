package ru.otus.hibernate.entity;



import javax.persistence.*;

@Entity
@Table(name = "adress")
public class AdressDataSet extends DataSet {
    private String street;
    @OneToOne(mappedBy = "adress")
    private UserDataSet user;

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "AdressDataSet{" +
                "street='" + street + '\'' +
                '}';
    }
}
