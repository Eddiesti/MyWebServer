package ru.otus.hibernate;

import ru.otus.test.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class PhoneDataSet extends DataSet {
    private String number;
}
