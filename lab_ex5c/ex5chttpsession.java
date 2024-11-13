import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import static java.lang.System.out;

public class ex5chttpsession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        // Use HttpSession to store session information
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("age", age);
        out.println("<h2>HTTP SESSION</h2>");
        // Redirect to display session information
        response.sendRedirect("ex5c");
    }
}
