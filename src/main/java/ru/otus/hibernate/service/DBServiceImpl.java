package ru.otus.hibernate.service;

import ru.otus.hibernate.entity.DataSet;

public class DBServiceImpl implements DBService {
    public <T extends DataSet> void save(T user) {

    }

    public <T extends DataSet> T load(long id, Class<T> clazz) {
        return null;
    }

    @Override
    public <T extends DataSet> String getUserById(long id, Class<T> clazz) {
        return null;
    }


    @Override
    public Integer getCountUsers() {
        return null;
    }

    @Override
    public void shutdown() {

    }
}

