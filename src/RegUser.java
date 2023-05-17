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

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void addLoan(Book book) {
        Loan l = new Loan(book);
        loans.add(l);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public String getLoansAsStr() {
        String out = "";

        for(Loan l : loans) {
            out += l + "\n";
        }
        
        return out;
    }

    public String toString() {
        String out = super.toString();
        String formattedLoans = "\n";
        for(Loan loan : loans) {
            formattedLoans += loan + "\n";
        }
        return out + " | Loans: " + formattedLoans + "\n\n";
    }

}
