import java.util.ArrayList;

public class User {
    
    private String name;
    private int id;
    private ArrayList<Loan> loans;

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

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

}
