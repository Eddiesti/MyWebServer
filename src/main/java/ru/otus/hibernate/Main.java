package ru.otus.hibernate;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceHibernateImpl();

//        AdressDataSet addressDataSet = new AdressDataSet();
//        addressDataSet.setStreet("1");
        UserDataSet userDataSet = new UserDataSet();
        userDataSet.setName("2");
        userDataSet.setAge(2);
//        userDataSet.setAdress(addressDataSet);
        dbService.save(userDataSet);
    }
}
