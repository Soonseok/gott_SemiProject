package bookstore.model;

import bookstore.controller.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static List<Book> books = new ArrayList<>();

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

        String sql = "select * from bookdb where book_id = '" + id + "'";
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

    public String getAuthorBiographyByBookId(String bookId) {
        String biography = "";

        String sql = "SELECT author_abstract " +
                     "FROM bookdb b JOIN authordb a ON b.author = a.author " +
                     "WHERE b.book_id = ?";

        try (Connection con = DBConnection.makeConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, bookId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                biography = rs.getString("author_abstract");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return biography;
    }

    public String[][] getBooksByIds(List<String> ids) {
        String[][] result = new String[ids.size()][6];
    
        String sql = "SELECT * FROM bookdb WHERE book_id = ?";
    
        try (Connection con = DBConnection.makeConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
    
            for (int i = 0; i < ids.size(); i++) {
                stmt.setString(1, ids.get(i));
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        result[i][0] = rs.getString("book_id");
                        result[i][1] = rs.getString("author");
                        result[i][2] = rs.getString("title");
                        result[i][3] = String.valueOf(rs.getInt("price"));
                        result[i][4] = rs.getString("cover_image");
                        result[i][5] = rs.getString("book_abstract");
                    }
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return result;
    }
}
