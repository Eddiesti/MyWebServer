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

public class DataInfoPageServlet extends HttpServlet {
    private long id;
    private TemplateProcessor templateProcessor = new TemplateProcessor();
    private DBService service = new DBServiceHibernateImpl();
    private Map<String, Object> pageVariables = new HashMap<>();

    public DataInfoPageServlet() throws IOException {
    }

    public DataInfoPageServlet(long id) throws IOException {
        this.id = id;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        pageVariables.put("count", service.getCountUsers());

        String idString = request.getParameter("id");

        if (idString != null) {
            long id = Long.parseLong(idString);
            String nameById = service.getNameById(id, UserDataSet.class);
            if (nameById != null) {
                pageVariables.put("name", nameById);
            }
        }

        String pageText = templateProcessor.getPage("data_info.html", pageVariables);
        response.getWriter().println(pageText);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
