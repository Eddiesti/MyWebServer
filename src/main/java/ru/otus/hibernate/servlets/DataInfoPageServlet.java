package ru.otus.hibernate.servlets;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.hibernate.entity.UserDataSet;
import ru.otus.hibernate.service.DBService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataInfoPageServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(AddUserServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> pageVariables = new HashMap<>();

        DBService service = (DBService) getServletContext().getAttribute("dbService");
        TemplateProcessor templateProcessor = (TemplateProcessor) getServletContext().getAttribute("templateProcessor");

        pageVariables.put("count", service.getCountUsers());

        String idString = request.getParameter("id");
        try {
            if (idString != null && !idString.isEmpty()) {
                String userById;

                long id = Long.parseLong(idString);
                userById = service.getUserById(id, UserDataSet.class);
                if (userById != null) {
                    pageVariables.put("name", userById);
                }
            }
        } catch (ObjectNotFoundException ex) {
            logger.info("User not found");
            response.sendRedirect("/error.html");
            return;
        }
        String pageText = templateProcessor.getPage("data_info.html", pageVariables);
        response.getWriter().println(pageText);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
