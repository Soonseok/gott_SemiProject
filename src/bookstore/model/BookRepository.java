package bookstore.model;

import bookstore.controller.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static List<Book> books = new ArrayList<>();
    private static boolean initialized = false;

    public static void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM BOOKDB";
        try (Connection conn = DBConnection.makeConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("BOOK_ID"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setTitle(rs.getString("TITLE"));
                book.setPrice(rs.getInt("PRICE"));
                book.setImagePath(rs.getString("COVER_IMAGE"));
                book.setBookAbstract(rs.getString("BOOK_ABSTRACT"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> getBooksByCategory(String category) throws SQLException {
        // String category = p m c b 중 하나
        List<Book> categorizedBooks = new ArrayList<>();

        String sql = "select * from bookdb where book_id like '" + category + "%'";
        try (Connection con = DBConnection.makeConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("BOOK_ID"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setTitle(rs.getString("TITLE"));
                book.setPrice(rs.getInt("PRICE"));
                book.setImagePath(rs.getString("COVER_IMAGE"));
                book.setBookAbstract(rs.getString("BOOK_ABSTRACT"));
                categorizedBooks.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorizedBooks;
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> searcheddBooks = new ArrayList<>();

        String keywordLower = keyword.toLowerCase();
        String sql = "SELECT book_id, author, title, price, cover_image, TO_CHAR(book_abstract) AS book_abstract "
                + "FROM bookdb WHERE LOWER(title) LIKE '%" + keywordLower + "%' "
                + "UNION "
                + "SELECT book_id, author, title, price, cover_image, TO_CHAR(book_abstract) AS book_abstract "
                + "FROM bookdb WHERE LOWER(author) LIKE '%" + keywordLower + "%' "
                + "UNION "
                + "SELECT book_id, author, title, price, cover_image, TO_CHAR(book_abstract) AS book_abstract "
                + "FROM bookdb WHERE DBMS_LOB.INSTR(LOWER(book_abstract), '" + keywordLower + "') > 0";

        try (Connection con = DBConnection.makeConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("BOOK_ID"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setTitle(rs.getString("TITLE"));
                book.setPrice(rs.getInt("PRICE"));
                book.setImagePath(rs.getString("COVER_IMAGE"));
                book.setBookAbstract(rs.getString("BOOK_ABSTRACT"));
                searcheddBooks.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searcheddBooks;
    }

    public List<Book> getBookById(String id) {
        // String id는 p_0과 같은 형태
        List<Book> selectedBook = new ArrayList<>();

        String sql = "select * from bookdb where book_id = " + id;
        try (Connection con = DBConnection.makeConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("BOOK_ID"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setTitle(rs.getString("TITLE"));
                book.setPrice(rs.getInt("PRICE"));
                book.setImagePath(rs.getString("COVER_IMAGE"));
                book.setBookAbstract(rs.getString("BOOK_ABSTRACT"));
                selectedBook.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectedBook;
    }
}
