package ru.otus.hibernate.servlets;


import ru.otus.hibernate.entity.AdressDataSet;
import ru.otus.hibernate.entity.PhoneDataSet;
import ru.otus.hibernate.entity.UserDataSet;
import ru.otus.hibernate.service.DBService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddUserServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(AddUserServlet.class);


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDataSet user = new UserDataSet();
        DBService service = (DBService) getServletContext().getAttribute("dbService");
        String name = request.getParameter("name");
        if (name.equals("")) {
            logger.info("Name is null");
            response.sendRedirect("/error.html");
            return;
        }

        String age = request.getParameter("age");
        int parseAge = 0;
        try {
             parseAge = Integer.parseInt(age);
        } catch (NumberFormatException ex) {
            logger.info("Incorrect correct data");
            response.sendRedirect("/error.html");
            return;
        }
        if (parseAge < 5 || parseAge > 100) {
            logger.info("Age can't < 5 and > 100");
            response.sendRedirect("/error.html");
            return;
        }
        String number = request.getParameter("phone");

        if (number.length() < 8) {
            logger.info("Phone number can't < 5");
            response.sendRedirect("/error.html");
            return;
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
        return;
    }
}

