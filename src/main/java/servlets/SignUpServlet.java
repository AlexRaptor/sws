package servlets;

import accounts.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>/signup</p>
 *
 * @author raptor
 *         date: 03.03.16.
 */
public class SignUpServlet extends HttpServlet {
    private final AccountServiceImpl accountServiceImpl;

    public SignUpServlet(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        System.out.println("--- UP: " + login + " : " + password);

//        accountServiceImpl.addNewUser(new UserProfile(login, password, "e-mail"));

        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
