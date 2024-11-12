import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/AnimalInfoServlet")
public class ex5b extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String animalType = request.getParameter("animal");
        PrintWriter out = response.getWriter();

        // Start HTML table
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<table class='table table-bordered table-striped'>")
                    .append("<thead><tr><th>Breed</th><th>Type</th><th>Life Expectancy</th></tr></thead>")
                    .append("<tbody>");

        // Append rows based on animal type
        switch (animalType) {
            case "Dog":
                htmlResponse.append(createRow("Labrador", "Dog", "10-12 years"))
                            .append(createRow("Jack Russell Terrier", "Dog", "13-16 years"))
                            .append(createRow("Dachshund", "Dog", "12-16 years"))
                            .append(createRow("Pomeranian", "Dog", "12-16 years"))
                            .append(createRow("Yorkshire Terrier", "Dog", "13-16 years"))
                            .append(createRow("Maltese", "Dog", "12-15 years"))
                            .append(createRow("Chihuahua", "Dog", "12-20 years"))
                            .append(createRow("Corgi", "Dog", "12-15 years"))
                            .append(createRow("Miniature Pinscher", "Dog", "12-16 years"))
                            .append(createRow("King Charles Spaniel", "Dog", "10-14 years"));
                break;
            case "Cat":
                htmlResponse.append(createRow("Siamese", "Cat", "15-20 years"))
                            .append(createRow("Persian", "Cat", "10-17 years"))
                            .append(createRow("Snowshoe", "Cat", "14-20 years"))
                            .append(createRow("Sokoke", "Cat", "13-15 years"))
                            .append(createRow("Laperm", "Cat", "10-14 years"))
                            .append(createRow("Munchkin", "Cat", "12-15 years"))
                            .append(createRow("Oriental Shorthair", "Cat", "12-15 years"))
                            .append(createRow("Abyssinian", "Cat", "9-15 years"));
                break;
            case "Bird":
                htmlResponse.append(createRow("Parrot", "Bird", "50-60 years"))
                            .append(createRow("Canary", "Bird", "10-15 years"))
                            .append(createRow("Finch", "Bird", "5-10 years"))
                            .append(createRow("Parakeet", "Bird", "5-10 years"))
                            .append(createRow("Chicken", "Bird", "5-10 years"))
                            .append(createRow("Love Bird", "Bird", "10-15 years"));
                break;
            case "Fish":
                htmlResponse.append(createRow("Angel Fish", "Fish", "10-12 years"))
                            .append(createRow("Red Tailed Black Shark", "Fish", "5-8 years"))
                            .append(createRow("Discus", "Fish", "10-15 years"))
                            .append(createRow("Guppy", "Fish", "2-3 years"))
                            .append(createRow("Goldfish", "Fish", "10-15 years"))
                            .append(createRow("Tiger Barb", "Fish", "5-7 years"))
                            .append(createRow("Lionhead Cichlid", "Fish", "8-10 years"))
                            .append(createRow("Neon Tetra", "Fish", "5-10 years"))
                            .append(createRow("Labidochromis Caeruleus", "Fish", "10-12 years"));
                break;
            case "Rabbit":
                htmlResponse.append(createRow("Netherland Dwarf", "Rabbit", "7-10 years"))
                            .append(createRow("Jersey Wooly", "Rabbit", "7-10 years"))
                            .append(createRow("Holland Lop", "Rabbit", "7-10 years"))
                            .append(createRow("Mini Rex", "Rabbit", "7-10 years"))
                            .append(createRow("Dutch", "Rabbit", "5-8 years"))
                            .append(createRow("Mini Lop", "Rabbit", "5-10 years"))
                            .append(createRow("Rex", "Rabbit", "5-6 years"))
                            .append(createRow("Satin", "Rabbit", "5-8 years"))
                            .append(createRow("New Zealand", "Rabbit", "5-7 years"))
                            .append(createRow("French Lop", "Rabbit", "5-7 years"));
                break;
            default:
                htmlResponse.append("<tr><td colspan='3'>No data available for this animal type</td></tr>");
                break;
        }

        // End HTML table
        htmlResponse.append("</tbody></table>");
        out.write(htmlResponse.toString());
        out.close();
    }

    // Helper method to create a table row
    private String createRow(String breed, String type, String lifeExpectancy) {
        return "<tr><td>" + breed + "</td><td>" + type + "</td><td>" + lifeExpectancy + "</td></tr>";
    }
}
