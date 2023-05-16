import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Superuser admin = new Superuser("admin", 0, "root");

        Library lib = Instantiator.instantiateLibrary(admin);

        System.out.println("");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("LOGIN\n1 - user login\n2 - admin login\nx - exit");
            System.out.println("Action:");
            String action = scanner.nextLine();
            System.out.println("");
            if(action.equals("1")) {
                // TODO
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