import java.util.Calendar;
import java.util.Date;

public class Loan {
    
    private Book book;
    private Date issueDate;
    private Date dueDate;

    // amount of time between issueDate and dueDate in days
    private final int loanLength = 5;

    // specify the Loan's book and relevant dates
    public Loan(Book book) {
        this.book = book;
        this.issueDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, loanLength);
        this.dueDate = calendar.getTime();
    }

    public Book getBook() {
        return book;
    }

    public String toString() {
        return (book + " | Issued: " + issueDate + " | Due: " + dueDate);
    }

}
