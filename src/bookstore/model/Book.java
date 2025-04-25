package bookstore.model;

public class Book {

    // public static String[][] recommendBookId = {
    //     {"p_28", "", "", "", "", "", ""},{"p_17", "", "", "", "", "", ""},{"p_16", "", "", "", "", "", ""},{"p_29", "", "", "", "", "", ""}
    // };
    // public static String[][] latesetBookId = {
    //     {"p_28", "", "", "", "", "", ""},{"p_17", "", "", "", "", "", ""},{"p_16", "", "", "", "", "", ""},{"p_29", "", "", "", "", "", ""}
    // };
    private String bookId;
    private String author;
    private String title;
    private int price;
    private String imagePath;
    private String bookAbstract;

    public Book(String bookId, String author, String title, int price, String imagePath, String bookAbstract) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.price = price;
        this.imagePath = imagePath;
        this.bookAbstract = bookAbstract;
    }
    public Book(){}

    public String getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getBookAbstract() {
        return bookAbstract;
    }
    
    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

}
