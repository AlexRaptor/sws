package servlets;

import accounts.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>/signin</p>
 *
 * @author raptor
 *         date: 03.03.16.
 */
public class SignInServlet extends HttpServlet {
    private final AccountServiceImpl accountServiceImpl;

    public SignInServlet(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        System.out.println("--- UP: " + login + " : " + password);

        resp.setContentType("text/html;charset=utf-8");

/*        UserProfile userProfile = accountServiceImpl.getUserByLogin(login);
        if (userProfile != null && userProfile.getPass().equals(password)) {
            resp.getWriter().println("Authorized: " + login);
            resp.setStatus( HttpServletResponse.SC_OK );
        } else {
            resp.getWriter().println("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }*/
    }
}
