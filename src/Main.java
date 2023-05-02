import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Superuser admin = new Superuser("admin", 0, "root");
        
        boolean loggedIn = false;
        User identity;
        
        while(!loggedIn) {
            System.out.println("Admin Login");
            System.out.println("default login is admin, root");


            System.out.println("Username:");
            String username = scanner.nextLine();
            
            System.out.println("Password:");
            String password = scanner.nextLine();

            // TODO: Authentication

            loggedIn = true;
        }

    }

}