package ru.otus.hibernate.launch;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.otus.hibernate.servlets.AddUserServlet;
import ru.otus.hibernate.servlets.DataInfoPageServlet;
import ru.otus.hibernate.servlets.TemplateProcessor;


public class WebLauncher {
    private final static int PORT = 8060;
    private final static String PUBLIC_HTML = "html_resourses";

    public static void launch() throws Exception {
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase(PUBLIC_HTML);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        TemplateProcessor templateProcessor = new TemplateProcessor();

        context.addServlet(new ServletHolder(new AddUserServlet(null,0,null,null,null)), "/add");
        context.addServlet(DataInfoPageServlet.class,"/data_info.html");
        Server server = new Server(PORT);
        server.setHandler(new HandlerList(resourceHandler, context));

        server.start();
        server.join();
    }
}
