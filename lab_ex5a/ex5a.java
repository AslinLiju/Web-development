import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex5a extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello.I successfully run the servlet!!!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}


