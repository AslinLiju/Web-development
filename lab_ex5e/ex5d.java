import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ex5d extends HttpServlet {
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/pets?useSSL=false&allowPublicKeyRetrieval=true&useServerPrepStmts=false&useCursorFetch=true", "root", "");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String desiredAnimal = request.getParameter("desiredAnimal");
        out.println("<html><head>");
        out.println("<title>Animal Breeds</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    background-image: url('pet_bg4.png');"); 
        out.println("    background-size: cover;");
        out.println("    background-repeat: no-repeat;");
        out.println("    background-position: center;");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    align-items: center;");
        out.println("    height: 100vh;");
        out.println("    margin: 0;");
        out.println("}");
        out.println(".container {");
        out.println("    background: rgba(255, 255, 255, 0.9);"); 
        out.println("    padding: 20px;");
        out.println("    border-radius: 10px;");
        out.println("    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);");
        out.println("    text-align: center;");
        out.println("    width: 80%;");
        out.println("    max-width: 600px;");
        out.println("}");
        out.println("table {");
        out.println("    width: 100%;");
        out.println("    border-collapse: collapse;");
        out.println("    margin-top: 20px;");
        out.println("}");
        out.println("th, td {");
        out.println("    padding: 10px;");
        out.println("    border: 1px solid #ddd;");
        out.println("    text-align: left;");
        out.println("}");
        out.println("th {");
        out.println("    background-color: #f4f4f4;");
        out.println("}");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");

        if (desiredAnimal != null && !desiredAnimal.isEmpty()) {
            try (Connection conn = getConnection()) {
                String query = "SELECT breed_name, life_expectancy, CAST(price AS CHAR) AS price FROM Animals WHERE type = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, desiredAnimal);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        out.println("<h1>Breeds of " + desiredAnimal + "</h1>");

                        if (!rs.next()) {
                            out.println("<p>No breeds found for this animal type.</p>");
                        } else {
                            out.println("<table>");
                            out.println("<tr><th>Breed</th><th>Life Expectancy</th><th>Price</th></tr>");
                            do {
                                String breedName = rs.getString("breed_name");
                                String lifeExpectancy = rs.getString("life_expectancy");
                                String price = rs.getString("price");

                                out.println("<tr>");
                                out.println("<td>" + breedName + "</td>");
                                out.println("<td>" + lifeExpectancy + "</td>");
                                out.println("<td>" + price + "</td>");
                                out.println("</tr>");
                            } while (rs.next());
                            out.println("</table>");
                        }
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
        }

        out.println("</div>"); 
        out.println("</body></html>");
    }
}
