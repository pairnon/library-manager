import java.util.ArrayList;

public class RegUser extends User {
    
    private ArrayList<Loan> loans;

    public RegUser(String name, int id) {
        super(name, id);
        this.loans = new ArrayList<Loan>();
    }

    public RegUser(String name, int id, ArrayList<Loan> loans) {
        super(name, id);
        this.loans = loans;
    }

}
