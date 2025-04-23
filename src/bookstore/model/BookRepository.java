package bookstore.model;
// 테스트 데이터. 나중에 SQL로 바꿔야 함.

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static List<Book> books = new ArrayList<>();
    private static boolean initialized = false;

    public static void addBook(Book book) {
        books.add(book);
    }

    public static List<Book> getAllBooks() {

        return books;
    }

}
