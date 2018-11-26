package ru.otus.hibernate;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceHibernateImpl();
        PhoneDataSet phoneDataSet = new PhoneDataSet();
        phoneDataSet.setNumber("+79777777");
        AdressDataSet addressDataSet = new AdressDataSet();
        addressDataSet.setStreet("7");
        UserDataSet userDataSet = new UserDataSet();
        userDataSet.setName("Roman");

        userDataSet.setAge(17);
        userDataSet.setAdress(addressDataSet);
        phoneDataSet.setUsers(userDataSet);
        List<PhoneDataSet> list = new ArrayList();
        list.add(phoneDataSet);
        list.add(phoneDataSet);
        userDataSet.setPhones(list);
        dbService.save(userDataSet);
        UserDataSet load2 = dbService.load(1,userDataSet);
        System.out.println(load2);
        ((DBServiceHibernateImpl) dbService).shutdown();
    }
}
