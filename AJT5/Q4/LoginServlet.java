import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class LoginServlet extends HttpServlet {
    private static final Map<String, String> USERS = new HashMap<>();
    
    static {
        USERS.put("dishang", "dishu");
        USERS.put("admin", "admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERS.containsKey(username) && USERS.get(username).equals(password)) {

            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(60 * 30);
            
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 30);
            response.addCookie(userCookie);
            
            response.sendRedirect("WelcomeServlet");
        } else {
            response.getWriter().println("Invalid username or password.");
        }
    }
}
