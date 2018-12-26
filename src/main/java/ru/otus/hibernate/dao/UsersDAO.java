package ru.otus.hibernate.dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.hibernate.entity.DataSet;
import ru.otus.hibernate.entity.UserDataSet;
import ru.otus.hibernate.servlets.AddUserServlet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class UsersDAO {
    private static Logger logger = LoggerFactory.getLogger(UsersDAO.class);
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
        logger.info("Session create");
    }

    public <T extends DataSet> void save(T user) {
        session.save(user);
        logger.info("User saved");
    }

    public <T extends DataSet> T load(Class<T> clazz, long id) {
        logger.info("User load");
        return session.load(clazz, id);
    }

    public <T extends DataSet> String getUserById(long id, Class<T> clazz) {
        T user = session.load(clazz, id);
        logger.info("User found");
        return user.toString();
    }

    public <T extends DataSet> Integer getCountUsers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataSet> criteria = builder.createQuery(UserDataSet.class);
        criteria.from(UserDataSet.class);
        return session.createQuery(criteria).list().size();
    }

}
