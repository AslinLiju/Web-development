import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import static java.lang.System.out;

public class ex5curlrewritting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        out.println("<h2>URL REWRITTING</h2>");
        // Add parameters to the URL for session handling
        String encodedURL = response.encodeRedirectURL("ex5c?username=" + username + "&age=" + age );

        // Redirect to display session information with rewritten URL
        response.sendRedirect(encodedURL);
    }
}
