package main;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SessionsServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import servlets.UsersServlet;

public class Main {
    public static void main(String[] args) throws Exception
    {
        DBService dbService = new DBService();
        dbService.printConnectInfo();

        AccountService accountService = new AccountService( dbService );

        if( accountService.getUserByLogin( "admin" ) == null )
        {
            accountService.addNewUser( new UserProfile( "admin" ) );
        }
        if( accountService.getUserByLogin( "test" ) == null )
        {
            accountService.addNewUser( new UserProfile( "test" ) );
        }

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/v1/users");
//        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        System.out.println( "Server started" );
        server.join();
    }
}
