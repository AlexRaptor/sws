package servlets;

import accounts.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class SessionsServlet extends HttpServlet {
    private final AccountServiceImpl accountServiceImpl;

    public SessionsServlet(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    //get logged user profile
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
//        String sessionId = request.getSession().getId();
//        UserProfile profile = accountServiceImpl.getUserBySessionId(sessionId);
//        if (profile == null) {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
//            Gson gson = new Gson();
//            String json = gson.toJson(profile);
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println(json);
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
    }

    //sign in
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("login");
//        String pass = request.getParameter("pass");
//
//        if (login == null || pass == null) {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//
//        UserProfile profile = accountServiceImpl.getUserByLogin(login);
//        if (profile == null || !profile.getPass().equals(pass)) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        accountServiceImpl.addSession(request.getSession().getId(), profile);
//        Gson gson = new Gson();
//        String json = gson.toJson(profile);
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println(json);
//        response.setStatus(HttpServletResponse.SC_OK);
    }

    //sign out
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
//        String sessionId = request.getSession().getId();
//        UserProfile profile = accountServiceImpl.getUserBySessionId(sessionId);
//        if (profile == null) {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
//            accountServiceImpl.deleteSession(sessionId);
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("Goodbye!");
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
    }
}
