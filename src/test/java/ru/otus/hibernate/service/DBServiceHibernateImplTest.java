package ru.otus.hibernate.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import ru.otus.hibernate.entity.AdressDataSet;
import ru.otus.hibernate.entity.PhoneDataSet;
import ru.otus.hibernate.entity.UserDataSet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class DBServiceHibernateImplTest {
    private DBServiceHibernateImpl dbService = null;
    private UserDataSet userDataSet = null;
    private int ID = 0;

    @Before
    public void init() {
        ID = 1;
        dbService = new DBServiceHibernateImpl();
        PhoneDataSet phoneDataSet = new PhoneDataSet();
        PhoneDataSet phoneDataSet1 = new PhoneDataSet();
        phoneDataSet.setNumber("+79777777");
        phoneDataSet1.setNumber("+928349234");
        AdressDataSet addressDataSet = new AdressDataSet();
        addressDataSet.setStreet("7");
        userDataSet = new UserDataSet();
        userDataSet.setName("Roman");

        userDataSet.setAge(17);
        userDataSet.setAdress(addressDataSet);
        phoneDataSet.setUsers(userDataSet);
        phoneDataSet1.setUsers(userDataSet);
        List<PhoneDataSet> list = new ArrayList<>();
        list.add(phoneDataSet);
        list.add(phoneDataSet1);
        userDataSet.setPhones(list);
    }

    @Test
    public void save() {
        dbService.save(userDataSet);

        UserDataSet actual = dbService.load(ID, userDataSet.getClass());
        assertNotNull(actual.getId());
        assertEquals(userDataSet,actual);
    }

    @After
    public void close() {
        dbService.shutdown();
    }
}