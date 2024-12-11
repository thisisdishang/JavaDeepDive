package AJT2;

import java.sql.*;

public class BookCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "1234";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            //createBookTable(connection);


            //insertBook(connection, "C Programming", "Denich Ritechie", 500);
            //deleteBook(connection, 2);
            //updateBook(connection, 7,500);

            getBooks(connection);

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createBookTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            String createBookQuery = "CREATE TABLE IF NOT EXISTS Book (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title VARCHAR(255), " +
                    "author VARCHAR(255), " +
                    "price DECIMAL(10, 2))";

            statement.execute(createBookQuery);
            System.out.println("Book Table created");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertBook(Connection connection, String title, String author, double price) {
        String insertBookQuery = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertBookQuery)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
            System.out.println("Book inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateBook(Connection connection, int id, double price) {
        String updateQuery = "UPDATE Book SET price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Book updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteBook(Connection connection, int id) {
        String deleteBookQuery = "DELETE FROM Book WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteBookQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Book updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void getBooks(Connection connection) {
        String bookQuery = "SELECT * FROM Book";
        try (PreparedStatement ps = connection.prepareStatement(bookQuery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.printf("%d %s %s%n", rs.getInt("id"), rs.getString("title"), rs.getString("author"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}