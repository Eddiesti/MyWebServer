package ru.otus.hibernate;

import ru.otus.hibernate.entity.AdressDataSet;
import ru.otus.hibernate.entity.PhoneDataSet;
import ru.otus.hibernate.entity.UserDataSet;
import ru.otus.hibernate.service.DBService;
import ru.otus.hibernate.service.DBServiceHibernateImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceHibernateImpl();
        PhoneDataSet phoneDataSet = new PhoneDataSet();
        PhoneDataSet phoneDataSet1 = new PhoneDataSet();
        phoneDataSet.setNumber("+79777777");
        phoneDataSet1.setNumber("+79777777");
        AdressDataSet addressDataSet = new AdressDataSet();
        addressDataSet.setStreet("7");
        UserDataSet userDataSet = new UserDataSet();
        userDataSet.setName("Roman");
        userDataSet.setAge(17);
        userDataSet.setAdress(addressDataSet);
        phoneDataSet.setUsers(userDataSet);
        phoneDataSet1.setUsers(userDataSet);
        List<PhoneDataSet> list = new ArrayList<>();
        list.add(phoneDataSet);
        list.add(phoneDataSet1);
        userDataSet.setPhones(list);
        dbService.save(userDataSet);
        UserDataSet load2 = dbService.load(1, userDataSet.getClass());
        System.out.println(load2 + " load");
        System.out.println(userDataSet + " user");
        boolean equals = load2.equals(userDataSet);
        System.out.println(equals);
        dbService.shutdown();
    }
}
