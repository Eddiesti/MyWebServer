package ru.otus.hibernate.service;

import ru.otus.hibernate.entity.DataSet;

public interface DBService {
    <T extends DataSet> void save(T user);
    <T extends DataSet> T load(long id,T clazz);
}
