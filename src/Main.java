import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Superuser admin = new Superuser("admin", 0, "root");
        try (Scanner scanner = new Scanner(System.in)) {
            
            boolean loggedIn = admin.getLogInStatus();

            while(!loggedIn) {
                System.out.println("Admin Login");
                System.out.println("default password is 'root'");

                System.out.println("Password:");
                String password = scanner.nextLine();

                loggedIn = admin.authenticate(password);
            }
        }
        System.out.println("login success");

    }

}