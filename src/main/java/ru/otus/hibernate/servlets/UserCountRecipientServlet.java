package ru.otus.hibernate.servlets;

import ru.otus.hibernate.service.DBService;
import ru.otus.hibernate.service.DBServiceHibernateImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserCountRecipientServlet extends HttpServlet {
    private TemplateProcessor templateProcessor = new TemplateProcessor();
    private DBService service = new DBServiceHibernateImpl();

    public UserCountRecipientServlet() throws IOException {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    private String getPage() throws IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("count", service.getCountUsers());
        return templateProcessor.getPage("getCount.html", pageVariables);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = getPage();
        response.getWriter().println(page);
    }
}
