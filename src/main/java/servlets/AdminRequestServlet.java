package servlets;

import accounts.AccountServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by raptor on 09.03.16.
 */
public class AdminRequestServlet extends HttpServlet {

    private final AccountServer accountServer;

    public AdminRequestServlet( AccountServer accountServer ) {
        this.accountServer = accountServer;
    }

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {
        resp.setContentType( "text/html;charset=utf-8" );
        resp.setStatus( HttpServletResponse.SC_OK );
        resp.getWriter().println( accountServer.getUsersLimit() );
    }
}
