import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // initialize the library, which requires a Superuser to be constructed
        Superuser admin = new Superuser("admin", 0, "root");
        Library lib = Instantiator.instantiateLibrary(admin);

        System.out.println("");

        Scanner scanner = new Scanner(System.in);

        // prompt for regUser or Superuser login
        while(true) {
            System.out.println("LOGIN\n1 - user login\n2 - admin login\nx - exit");
            System.out.print("$ ");
            String action = scanner.nextLine();
            System.out.println("");
            if(action.equals("1")) {
                Menu.regUserLogin(admin, lib);
                break;
            }
            else if(action.equals("2")) {
                Menu.adminLogin(admin, lib);
                break;
            }
            else {
                break;
            }
        }

        scanner.close();
    }

}