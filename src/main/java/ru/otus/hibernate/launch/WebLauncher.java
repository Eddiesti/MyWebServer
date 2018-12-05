package ru.otus.hibernate.launch;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.otus.hibernate.servlets.AddUserServlet;
import ru.otus.hibernate.servlets.NameServlet;
import ru.otus.hibernate.servlets.UserCountRecipientServlet;

public class WebLauncher {
    private final static int PORT = 8090;
    private final static String PUBLIC_HTML = "html_resourses";

    public static void launch() throws Exception {
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase(PUBLIC_HTML);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new NameServlet(1L)), "/showName.html");
        context.addServlet(UserCountRecipientServlet.class,"/getCount.html");
        context.addServlet(new ServletHolder(new AddUserServlet("",0,"0","0")),"/addUser.html");
        Server server = new Server(PORT);
        server.setHandler(new HandlerList(resourceHandler, context));
        server.start();
        server.join();
    }
}
