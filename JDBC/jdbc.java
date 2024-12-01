package JDBC;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        try {
            // Loading JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection to DBMS
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root", "");

            // Creating Statement
            Statement stmt=con.createStatement();

            // Execute Statement
            ResultSet rs=stmt.executeQuery("select * from employee");

            // Processing Data
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString("ename"));
                System.out.println(rs.getString(3));
            }

            // Terminating Connection
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }    
}