import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import static java.lang.System.out;

public class ex5ccookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        // Create cookies to store session information
        Cookie userCookie = new Cookie("username", username);
        Cookie ageCookie = new Cookie("age", age);

        // Set cookies with expiry time (optional)
        userCookie.setMaxAge(60 * 60); // 1 hour
        ageCookie.setMaxAge(60 * 60);

        response.addCookie(userCookie);
        response.addCookie(ageCookie);

        out.println("<h2>COOKIES</h2>");
        // Redirect to display session information
        response.sendRedirect("ex5c");
    }
}
