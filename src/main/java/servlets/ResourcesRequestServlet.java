package servlets;

import resources.ResourceServer;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author raptor
 *         date: 10.03.16
 */
public class ResourcesRequestServlet extends HttpServlet {
    private final ResourceServer resourceServer;

    public ResourcesRequestServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path_to_resource = req.getParameter("path");

        TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path_to_resource);
        resourceServer.setTestResource(testResource);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(testResource);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
