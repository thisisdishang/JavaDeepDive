import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); 
        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (username == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = cookie.getValue();
                        break;
                    }
                }
            }
        }

        if (username == null) {
            response.sendRedirect("index.html");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Welcome, " + username + "!</h3>");
            out.println("<p><a href='LogoutServlet'>Logout</a></p>");
            out.println("</body></html>");
        }
    }
}

