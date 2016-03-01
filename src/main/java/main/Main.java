package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestServlet;
import servlets.MirrorRequestServlet;

public class Main
{
    public static void main( String[] args ) throws Exception
    {
        Server server = new Server( 8080 );
        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
        server.setHandler( context );
        AllRequestServlet allRequestServlet = new AllRequestServlet();
        context.addServlet( new ServletHolder( allRequestServlet ), "/*" );

        MirrorRequestServlet mirrorRequestServlet = new MirrorRequestServlet();
        context.addServlet( new ServletHolder( mirrorRequestServlet ), "/mirror" );

        server.start();

        System.out.println( "Server started" );

        server.join();
    }
}
