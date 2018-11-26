package ru.otus.hibernate;

public interface DBService {
    <T extends DataSet> void save(T user);
    <T extends DataSet> T load(long id,T clazz);
}
