import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private Superuser admin;
    private ArrayList<User> users;

    public Library(Superuser admin) {
        this.books = new ArrayList<Book>();
        this.admin = admin;
        this.users = new ArrayList<User>();
    }
    
    public Library(ArrayList<Book> books, Superuser admin) {
        this.books = books;
        this.admin = admin;
        this.users = new ArrayList<User>();
    }

    public Library(ArrayList<Book> books, Superuser admin, ArrayList<User> users) {
        this.books = books;
        this.admin = admin;
        this.users = users;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getAdminName() {
        return admin.getName();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public String toString() {
        String out = "";
        out += "Library Admin: " + admin.getName() + "\n";
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
