package ru.otus.hibernate.dao;

import org.hibernate.Session;
import ru.otus.hibernate.entity.DataSet;


public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public <T extends DataSet> void save(T user) {
        session.save(user);
    }

    public <T extends DataSet> T load(long id, T clazz) {
        return (T) session.load(clazz.getClass(), id);
    }
}
