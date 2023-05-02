import java.util.Calendar;
import java.util.Date;

public class Loan {
    
    Book book;
    Date issueDate;
    Date dueDate;

    public Loan(Book book) {
        this.book = book;
        this.issueDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 5);
        this.dueDate = calendar.getTime();
    }

    public Book getBook() {
        return book;
    }

    public String toString() {
        return (book + " | Issued: " + issueDate + " | Due: " + dueDate);
    }

}
