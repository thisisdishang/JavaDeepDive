import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class BooksServlet extends HttpServlet {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/books";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234"; 

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM book";
            try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

                out.println("<html><body>");
                out.println("<h3>Available Books</h3>");
                while (rs.next()) {
                    out.println("<p><strong>ID:</strong> " + rs.getInt("id") + "</p>");
                    out.println("<p><strong>Title:</strong> " + rs.getString("title") + "</p>");
                    out.println("<p><strong>Author:</strong> " + rs.getString("author") + "</p>");
                    out.println("<p><strong>Price:</strong> " + rs.getDouble("price") + "</p>");
                    out.println("<hr>");
                }
                out.println("</body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

