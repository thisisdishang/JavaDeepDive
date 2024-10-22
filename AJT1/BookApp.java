package AJT1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookApp {
    private JFrame frame;
    private JTextField idField, titleField, authorField, isbnField;
    private JTextArea displayArea;
    private List<Book> bookList = new ArrayList<>();
    private static final String FILENAME = "C:\\Users\\disha\\Downloads\\JavaDeepDive\\AJT1\\Books.dat";

    public BookApp() {
        frame = new JFrame("Book Management");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Input Fields
        frame.add(new JLabel("Book ID:"));
        idField = new JTextField(20);
        frame.add(idField);

        frame.add(new JLabel("Title:"));
        titleField = new JTextField(20);
        frame.add(titleField);

        frame.add(new JLabel("Author:"));
        authorField = new JTextField(20);
        frame.add(authorField);

        frame.add(new JLabel("ISBN:"));
        isbnField = new JTextField(20);
        frame.add(isbnField);

        JButton saveButton = new JButton("Save Book");
        frame.add(saveButton);
        saveButton.addActionListener(e -> saveBook());

        JButton loadButton = new JButton("Load Books");
        frame.add(loadButton);
        loadButton.addActionListener(e -> loadBooks());

        JButton queryButton = new JButton("Query Book");
        frame.add(queryButton);
        queryButton.addActionListener(e -> queryBook());

        JButton updateButton = new JButton("Update Book");
        frame.add(updateButton);
        updateButton.addActionListener(e -> updateBook());

        JButton deleteButton = new JButton("Delete Book");
        frame.add(deleteButton);
        deleteButton.addActionListener(e -> deleteBook());

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private void saveBook() {
        String bookId = idField.getText();
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();

        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
            return;
        }

        Book book = new Book(bookId, title, author, isbn);
        bookList.add(book);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(bookList);
            JOptionPane.showMessageDialog(frame, "Book saved successfully.");
            clearFields();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error saving book: " + ex.getMessage());
        }
    }

    private void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            bookList = (List<Book>) ois.readObject();
            displayArea.setText("");
            for (Book book : bookList) {
                displayArea.append(book.toString() + "\n");
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, "Error loading books: " + ex.getMessage());
        }
    }

    private void queryBook() {
        String searchId = JOptionPane.showInputDialog(frame, "Enter Book ID, Title, or Author:");
        if (searchId == null || searchId.isEmpty()) return;

        displayArea.setText("");
        for (Book book : bookList) {
            if (book.getBookId().equalsIgnoreCase(searchId) ||
                book.getTitle().equalsIgnoreCase(searchId) ||
                book.getAuthor().equalsIgnoreCase(searchId)) {
                displayArea.append(book.toString() + "\n");
            }
        }
    }

    private void updateBook() {
        String bookId = JOptionPane.showInputDialog(frame, "Enter Book ID to update:");
        if (bookId == null || bookId.isEmpty()) return;

        for (Book book : bookList) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                String newTitle = JOptionPane.showInputDialog(frame, "Enter new title:", book.getTitle());
                String newAuthor = JOptionPane.showInputDialog(frame, "Enter new author:", book.getAuthor());
                String newIsbn = JOptionPane.showInputDialog(frame, "Enter new ISBN:", book.getIsbn());

                bookList.remove(book);
                bookList.add(new Book(bookId, newTitle, newAuthor, newIsbn));
                saveAllBooks();
                loadBooks();
                JOptionPane.showMessageDialog(frame, "Book updated successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Book ID not found.");
    }

    private void deleteBook() {
        String bookId = JOptionPane.showInputDialog(frame, "Enter Book ID to delete:");
        if (bookId == null || bookId.isEmpty()) return;

        for (Book book : bookList) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                bookList.remove(book);
                saveAllBooks();
                loadBooks();
                JOptionPane.showMessageDialog(frame, "Book deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Book ID not found.");
    }

    private void saveAllBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(bookList);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error saving books: " + ex.getMessage());
        }
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
    }

    public static void main(String[] args) {
        // Below ensure that the GUI is built and updated in a thread-safe manner, avoiding potential issues that could arise from manipulating the UI from a different thread
        // Event Dispatch Thread (EDT) is is a special thread in Swing responsible for handling events (like button clicks) and updating the GUI.
        SwingUtilities.invokeLater(BookApp::new);
    }
}