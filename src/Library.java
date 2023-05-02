import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library(ArrayList<Book> books) {
        this.books = books;
        this.users = new ArrayList<User>();
    }

    public Library(ArrayList<Book> books, ArrayList<User> users) {
        this.books = books;
        this.users = users;
    }

    public Library(Book[] books) {
        this.books = new ArrayList<Book>();
        for(Book book : books) {
            if(book!=null) {
                this.books.add(book);
            }
        }
        this.users = new ArrayList<User>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public String toString() {
        String out = "";
        for(Book book : books) {
            out += book + " | ";
        }
        out += "\n";
        for(User user : users) {
            out += user + " | ";
        }
        return out;
    }

}
