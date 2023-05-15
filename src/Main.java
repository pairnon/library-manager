import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Superuser admin = new Superuser("admin", 0, "root");

        Library lib = Instantiator.instantiateLibrary(admin);

        System.out.println("");
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = admin.getLogInStatus();

            while(!loggedIn) {
                System.out.println("Admin Login");
                System.out.println("default password is 'root'");

                System.out.println("Password:");
                String password = scanner.nextLine();

                System.out.println("");

                loggedIn = admin.authenticate(password);
            }

        System.out.println("login success");

        adminMenu(admin, lib);
    }

    public static void adminMenu(Superuser admin, Library lib) {

        if(!admin.getLogInStatus()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Actions\n1 - list registered users\n2 - list books in system\nx - exit");
            System.out.println("Action:");
            String action = scanner.nextLine();
            System.out.println("");
            if(action.equals("1")) {
                System.out.println(lib.getRegUsers());
            }
            else if(action.equals("2")) {
                System.out.println(lib.getBooks());
            }
            else {
                break;
            }
        }
        scanner.close();
    }

}