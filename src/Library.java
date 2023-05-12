import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private Superuser admin;
    private ArrayList<RegUser> regUsers;

    public Library(Superuser admin) {
        this.books = new ArrayList<Book>();
        this.admin = admin;
        this.regUsers = new ArrayList<RegUser>();
    }
    
    public Library(ArrayList<Book> books, Superuser admin) {
        this.books = books;
        this.admin = admin;
        this.regUsers = new ArrayList<RegUser>();
    }

    public Library(ArrayList<Book> books, Superuser admin, ArrayList<RegUser> regUsers) {
        this.books = books;
        this.admin = admin;
        this.regUsers = regUsers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getAdminName() {
        return admin.getName();
    }

    public ArrayList<RegUser> getRegUsers() {
        return regUsers;
    }

    public void addRegUser(RegUser regUser) {
        regUsers.add(regUser);
    }

    public void addRegUser(String name, int id) {
        RegUser regUser = new RegUser(name, id);
        regUsers.add(regUser);
    }

    public void addRegUser(String name, int id, ArrayList<Loan> loans) {
        RegUser regUser = new RegUser(name, id, loans);
        regUsers.add(regUser);
    }

    public int findBookIndexByTitle(String title) {
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public Book findBookByTitle(String title) {
        int index = findBookIndexByTitle(title);
        if(index >= 0) {
            return books.get(index);
        }
        return null;
    }

    public String toString() {
        String out = "";
        out += "Library Admin: " + admin.getName() + "\n";
        for(Book book : books) {
            out += book + " | ";
        }
        out += "\n";
        for(RegUser regUser : regUsers) {
            out += regUser + " | ";
        }
        return out;
    }

}
