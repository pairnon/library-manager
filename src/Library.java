import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public Library(Book[] books) {
        this.books = new ArrayList<Book>();
        for(Book book : books) {
            if(book!=null) {
                this.books.add(book);
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String toString() {
        String out = "";
        for(Book book : books) {
            out += book + "\n";
        }
        return out;
    }

}
