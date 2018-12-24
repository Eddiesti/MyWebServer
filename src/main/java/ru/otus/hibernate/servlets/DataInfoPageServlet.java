package ru.otus.hibernate.servlets;

import ru.otus.hibernate.entity.UserDataSet;
import ru.otus.hibernate.service.DBService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataInfoPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> pageVariables = new HashMap<>();

        DBService service = (DBService) getServletContext().getAttribute("dbService");
        TemplateProcessor templateProcessor = (TemplateProcessor) getServletContext().getAttribute("templateProcessor");

        pageVariables.put("count", service.getCountUsers());

        String idString = request.getParameter("id");

        if (idString != null && !idString.isEmpty()) {
            long id = Long.parseLong(idString);
            String nameById;
            nameById = service.getNameById(id, UserDataSet.class);
            if (nameById != null) {
                pageVariables.put("name", nameById);
            }
        } else throw new IllegalArgumentException("User not found");

        String pageText = templateProcessor.getPage("data_info.html", pageVariables);
        response.getWriter().println(pageText);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}

