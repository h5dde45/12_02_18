package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet",
initParams = {
        @WebInitParam(name = "init_1",value = "value_1")
})
public class TestServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(config.getInitParameter("init_1"));
    }

    protected void progressRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>" + request.getParameter("p1") + "</h1>");
            out.println("<h1>" + request.getParameter("p2") + "</h1>");
//            out.println("<img src='images\\priority.png'/>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        progressRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        progressRequest(request, response);
    }
}
