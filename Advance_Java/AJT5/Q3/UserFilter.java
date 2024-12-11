import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UserFilter implements Filter {

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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && isValidUser(username, password)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("index.html");
        }
    }

    private boolean isValidUser(String username, String password) {
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next(); // If user exists, return true
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
