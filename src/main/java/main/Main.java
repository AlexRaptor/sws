package main;

import accounts.AccountServer;
import accounts.AccountServerController;
import accounts.AccountServerControllerMBean;
import accounts.AccountServerImpl;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AdminRequestServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws Exception {
//        DBService dbService = new DBService();
//        dbService.printConnectInfo();

//        AccountServiceImpl accountService = new AccountServiceImpl( dbService );

//        if( accountService.getUserByLogin( "admin" ) == null )
//        {
//            accountService.addNewUser( new UserProfile( "admin" ) );
//        }
//        if( accountService.getUserByLogin( "test" ) == null )
//        {
//            accountService.addNewUser( new UserProfile( "test" ) );
//        }

        AccountServer accountServer = new AccountServerImpl(10);

        AccountServerControllerMBean ascb = new AccountServerController(accountServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=AccountServerController.usersLimit");
        mbs.registerMBean(ascb, name);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/v1/users");
//        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");
//        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
//        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
//        context.addServlet( new ServletHolder( new WebSocketChatServlet() ), "/chat" );
        context.addServlet(new ServletHolder(new AdminRequestServlet(accountServer)), "/admin");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
