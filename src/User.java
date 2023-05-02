import java.util.ArrayList;

public class User {
    
    private String name;
    private int id;
    private ArrayList<Loan> loans;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.loans = new ArrayList<Loan>();
    }

    public User(String name, int id, ArrayList<Loan> loans) {
        this.name = name;
        this.id = id;
        this.loans = new ArrayList<Loan>();
        for(Loan loan : loans) {
            this.loans.add(loan);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public String toString() {
        String out = "";
        out += "Name: " + name + " | ID: " + id + "\nLoans\n";
        for(Loan loan : loans) {
            out += loan + "\n";
        }
        return out;
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

}
