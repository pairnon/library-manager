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

        System.out.println("login success\n");

        adminMenu(admin, lib);
    }

    public static void adminMenu(Superuser admin, Library lib) {

        if(!admin.getLogInStatus()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("LIBRARY ADMINISTRATION\nActions\n1 - sort registered users\n2 - sort books\n9 - whoami\nx - exit");
            System.out.println("Action:");
            String action = scanner.nextLine();
            System.out.println("");
            if(action.equals("1")) {
                while(true) {
                    System.out.println("SORT REGISTERED USERS\nActions\n1 - sort by name asc.\n2 - sort by name desc.\n3 - sort by id asc.\n4 - sort by id desc.\nx - exit");
                    System.out.println("Action:");
                    action = scanner.nextLine();
                    System.out.println("");
                    if(action.equals("1")) {
                        System.out.println(admin.getRegUsersByNameAsc(lib));
                    }
                    else if(action.equals("2")) {
                        System.out.println(admin.getRegUsersByNameDesc(lib));
                    }
                    else if(action.equals("3")) {
                        System.out.println(admin.getRegUsersByIdAsc(lib));
                    }
                    else if(action.equals("4")) {
                        System.out.println(admin.getRegUsersByIdDesc(lib));
                    }
                    else {
                        break;
                    }
                }
            }
            else if(action.equals("2")) {
                while(true) {
                    System.out.println("SORT BOOKS\nActions\n1 - sort by author asc.\n2 - sort by author desc.\n3 - sort by title asc.\n4 - sort by title desc.\nx - exit");
                    System.out.println("Action:");
                    action = scanner.nextLine();
                    System.out.println("");
                    if(action.equals("1")) {
                        System.out.println(admin.getBooksByAuthorAsc(lib));
                    }
                    else if(action.equals("2")) {
                        System.out.println(admin.getBooksByAuthorDesc(lib));
                    }
                    else if(action.equals("3")) {
                        System.out.println(admin.getBooksByTitleAsc(lib));
                    }
                    else if(action.equals("4")) {
                        System.out.println(admin.getBooksByTitleDesc(lib));
                    }
                    else {
                        break;
                    }
                }
            }
            else if(action.equals("3")) {
                // TODO
            }
            else if(action.equals("4")) {
                // TODO
            }
            else if(action.equals("9")) {
                System.out.println(admin.getName() + "\n");
            }
            else {
                break;
            }
        }
        scanner.close();
    }

}