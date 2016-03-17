package main;

import chat.ChatServer;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resources.ResourceServer;
import resources.ResourceServerController;
import resources.ResourceServerControllerMBean;
import servlets.ResourcesRequestServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) {
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

//        AccountServer accountServer = new AccountServerImpl(10);
//
//        AccountServerControllerMBean ascb = new AccountServerController(accountServer);
//        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//        ObjectName name = new ObjectName("Admin:type=AccountServerController.usersLimit");
//        mbs.registerMBean(ascb, name);

//        ResourceServer resourceServer = new ResourceServer();

//        ResourceServerControllerMBean rscb = new ResourceServerController(resourceServer);
//        MBeanServer msb = ManagementFactory.getPlatformMBeanServer();
//        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
//        msb.registerMBean(rscb, name);

//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/v1/users");
//        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");
//        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
//        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
//        context.addServlet( new ServletHolder( new WebSocketChatServlet() ), "/chat" );
//        context.addServlet(new ServletHolder(new AdminRequestServlet(accountServer)), "/admin");
//        context.addServlet(new ServletHolder(new ResourcesRequestServlet(resourceServer)), "/resources");

//        ResourceHandler resource_handler = new ResourceHandler();
//        resource_handler.setDirectoriesListed(true);
//        resource_handler.setResourceBase("public_html");

//        HandlerList handlers = new HandlerList();
//        handlers.setHandlers(new Handler[]{resource_handler, context});
//        handlers.setHandlers(new Handler[]{context});

//        Server server = new Server(8080);
//        server.setHandler(handlers);

        try {
//            server.start();
//            server.join();

            new ChatServer(5050, 10).start();
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
