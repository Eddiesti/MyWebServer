package ru.otus.hibernate;

import javax.persistence.*;

@MappedSuperclass
abstract class DataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DataSet() {
    }
}