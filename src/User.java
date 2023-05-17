import java.util.ArrayList;

public class User {
    
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Insertion sort ascending
    public ArrayList<Book> getBooksByAuthorAsc(Library library) {
        ArrayList<Book> books = library.getBooks();

        for(int i = 1; i < books.size(); i++) {
            Book book = books.get(i);
            int back = i - 1;

            while(back >= 0 && book.getAuthor().compareTo(books.get(back).getAuthor()) < 0) {
                books.set(back+1, books.get(back));
                back--;
            }

            books.set(back + 1, book);

        }

        return books;
    }

    // Insertion sort descending
    public ArrayList<Book> getBooksByAuthorDesc(Library library) {
        ArrayList<Book> books = library.getBooks();

        for(int i = 1; i < books.size(); i++) {
            Book book = books.get(i);
            int back = i - 1;

            while(back >= 0 && book.getAuthor().compareTo(books.get(back).getAuthor()) > 0) {
                books.set(back+1, books.get(back));
                back--;
            }

            books.set(back + 1, book);

        }

        return books;
    }

    // Insertion sort ascending
    public ArrayList<Book> getBooksByTitleAsc(Library library) {
        ArrayList<Book> books = library.getBooks();

        for(int i = 1; i < books.size(); i++) {
            Book book = books.get(i);
            int back = i - 1;

            while(back >= 0 && book.getTitle().compareTo(books.get(back).getTitle()) < 0) {
                books.set(back+1, books.get(back));
                back--;
            }

            books.set(back + 1, book);

        }

        return books;
    }

    // Insertion sort descending
    public ArrayList<Book> getBooksByTitleDesc(Library library) {
        ArrayList<Book> books = library.getBooks();

        for(int i = 1; i < books.size(); i++) {
            Book book = books.get(i);
            int back = i - 1;

            while(back >= 0 && book.getTitle().compareTo(books.get(back).getTitle()) > 0) {
                books.set(back+1, books.get(back));
                back--;
            }

            books.set(back + 1, book);

        }

        return books;
    }

    public ArrayList<Book> searchBooksByAuthor(Library library, String author) {
        ArrayList<Book> books = library.getBooks();
        ArrayList<Book> out = new ArrayList<Book>();

        for(Book b : books) {
            if(b.getAuthor().toLowerCase().equals(author.toLowerCase())) {
                out.add(b);
            }
        }

        return out;
    }

    public ArrayList<Book> searchBooksByTitle(Library library, String title) {
        ArrayList<Book> books = library.getBooks();
        ArrayList<Book> out = new ArrayList<Book>();

        for(Book b : books) {
            if(b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                out.add(b);
            }
        }

        return out;
    }

    public Book searchBookExactMatch(Library library, String author, String title) {
        ArrayList<Book> books = library.getBooks();

        for(Book b : books) {
            if(b.getAuthor().toLowerCase().equals(author.toLowerCase()) && b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return(b);
            }
        }

        return null;

    }

    public String toString() {
        String out = "";
        out += "Name: " + name + " | ID: " + id;
        return out;
    }

}
