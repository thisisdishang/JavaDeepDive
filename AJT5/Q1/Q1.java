import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.*;


public class Q1 extends GenericServlet {
   public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
      LocalDateTime localtime = LocalDateTime.now();
      PrintWriter out = response.getWriter();
      out.println("<html><body>");
      out.println("<h1>Current Time Of Server Machine: </h1>");
      out.println("<h2>" + dtf.format(localtime) + "</h2>");
      out.println("</body></html>");
      out.close();
   }
}