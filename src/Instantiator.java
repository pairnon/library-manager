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

        regUsers = instantiateRegUsers(books);

        Library lib = new Library(books, admin, regUsers);

        return lib;
    }

    public static ArrayList<RegUser> instantiateRegUsers(ArrayList<Book> books) {

        String[] names = {
            "Alice", "Bob", "Carol", "Dave", "Eve", "Frank", "Grace", "Hank", "Isabel", "Jack",
            "Karen", "Liam", "Mandy", "Nancy", "Oliver", "Pamela", "Quentin", "Rachel", "Samuel",
            "Tina", "Ursula", "Victor", "Wendy", "Xander", "Yvonne", "Zack"
        };
        
        ArrayList<RegUser> out = new ArrayList<RegUser>();
        
        for(int i = 0; i < names.length; i++) {
            ArrayList<Loan> loans = new ArrayList<Loan>();
            for(int j = 0; j < 3; j++) {
                int index = (int)(Math.random() * 199);
                Loan loan = new Loan(books.get(index));
                loans.add(loan);
            }
            out.add(new RegUser(names[i], i+1, loans));
        }

        return out;
    }
}
