package ru.otus.hibernate.config;

import ru.otus.hibernate.entity.AdressDataSet;
import ru.otus.hibernate.entity.DataSet;
import ru.otus.hibernate.entity.PhoneDataSet;
import ru.otus.hibernate.entity.UserDataSet;

public class HibernateConfiguration {
    public static org.hibernate.cfg.Configuration setup() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(UserDataSet.class);
        configuration.addAnnotatedClass(PhoneDataSet.class);
        configuration.addAnnotatedClass(DataSet.class);
        configuration.addAnnotatedClass(AdressDataSet.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:db_example");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        configuration.setProperty("hibernate.connection.characterEncoding","utf8");
        return configuration;
    }
}
