package ru.otus.hibernate.servlets;

import ru.otus.hibernate.entity.UserDataSet;
import ru.otus.hibernate.service.DBService;
import ru.otus.hibernate.service.DBServiceHibernateImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NameServlet extends HttpServlet {
    private long id;
    private TemplateProcessor templateProcessor = new TemplateProcessor();
    private DBService dbService = new DBServiceHibernateImpl();

    public NameServlet(long id) throws IOException {
        id = this.id;

    }

    private String getPage(String nameById) throws IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("name", nameById);
        return templateProcessor.getPage("showName.html", pageVariables);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idString = request.getParameter("id");
        long id = Long.parseLong(idString);
        if(id > dbService.getCountUsers() || id < 0){
            throw new IllegalArgumentException("This id does not exist");
        }

        String nameById = dbService.getNameById(id, UserDataSet.class);
        String page = getPage(nameById);
        response.getWriter().println(page);
    }
}
