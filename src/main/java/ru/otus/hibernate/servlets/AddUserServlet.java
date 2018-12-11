package ru.otus.hibernate.servlets;

import org.h2.bnf.context.DbColumn;
import ru.otus.hibernate.entity.AdressDataSet;
import ru.otus.hibernate.entity.PhoneDataSet;
import ru.otus.hibernate.entity.UserDataSet;
import ru.otus.hibernate.service.DBService;
import ru.otus.hibernate.service.DBServiceHibernateImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDataSet user = new UserDataSet();
        DBService service = (DBService) getServletContext().getAttribute("dbService");
        String name = request.getParameter("name");
        if (name.equals("")) {
            throw new IllegalArgumentException("Name can't be null");
        }

        String age = request.getParameter("age");
        int parseAge = Integer.parseInt(age);
        if (parseAge < 5 || parseAge > 100) {
            throw new IllegalArgumentException("Age can't be below 5");
        }
        String number = request.getParameter("phone");

        if (number.length() < 8) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        String street = request.getParameter("adress");
        user.setName(name);
        user.setAge(parseAge);
        AdressDataSet adress = new AdressDataSet();
        adress.setStreet(street);
        PhoneDataSet phone = new PhoneDataSet();
        phone.setNumber(number);
        phone.setUsers(user);
        List<PhoneDataSet> list = new ArrayList<>();
        list.add(phone);
        user.setPhones(list);
        user.setAdress(adress);
        service.save(user);
        response.sendRedirect("/data_info.html");
    }
}
