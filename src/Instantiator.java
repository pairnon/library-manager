import java.util.ArrayList;

public class Instantiator {
    public static Library instantiateLibrary(Superuser admin) {
        ArrayList<RegUser> regUsers = new ArrayList<RegUser>();
        ArrayList<Book> books = new ArrayList<Book>();

        for (int i = 0; i < 200; i++) {
            String title = "Book " + i;
            String author = "Author " + i;
            Book book = new Book(title, author);
            books.add(book);
        }

        ArrayList<Loan> loans1 = new ArrayList<Loan>();
        ArrayList<Loan> loans2 = new ArrayList<Loan>();
        ArrayList<Loan> loans3 = new ArrayList<Loan>();
        ArrayList<Loan> loans4 = new ArrayList<Loan>();
        ArrayList<Loan> loans5 = new ArrayList<Loan>();

        for(int i = 0; i < 10; i++) {
            int index = (int)(Math.random() * 199);
            Loan loan = new Loan(books.get(index));
            loans1.add(loan);

            index = (int)(Math.random() * 199);
            loan = new Loan(books.get(index));
            loans2.add(loan);

            index = (int)(Math.random() * 199);
            loan = new Loan(books.get(index));
            loans3.add(loan);

            index = (int)(Math.random() * 199);
            loan = new Loan(books.get(index));
            loans4.add(loan);

            index = (int)(Math.random() * 199);
            loan = new Loan(books.get(index));
            loans5.add(loan);
        }

        RegUser regUser1 = new RegUser("Alice", 1, loans1);
        RegUser regUser2 = new RegUser("Bob", 2, loans2);
        RegUser regUser3 = new RegUser("Carol", 3, loans3);
        RegUser regUser4 = new RegUser("Dave", 4, loans4);
        RegUser regUser5 = new RegUser("Eve", 5, loans5);

        regUsers.add(regUser1);
        regUsers.add(regUser2);
        regUsers.add(regUser3);
        regUsers.add(regUser4);
        regUsers.add(regUser5);

        Library lib = new Library(books, admin, regUsers);

        return lib;
    }
}
