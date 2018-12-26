package ru.otus.hibernate.service;

import ru.otus.hibernate.entity.DataSet;

public interface DBService {
    <T extends DataSet> void save(T user);

    <T extends DataSet> T load(long id, Class<T> clazz);

    <T extends DataSet> String getUserById(long id, Class<T> clazz);

    <T extends DataSet> Integer getCountUsers();

    void shutdown();
}
