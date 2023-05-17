import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void regUserLogin(Superuser admin, Library lib) {
        
        Scanner scanner = new Scanner(System.in);
        
        RegUser selectedRegUser = null;

        while(selectedRegUser == null) {
            ArrayList<RegUser> libRegUsers = lib.getRegUsers();

            System.out.println("User Login");
            System.out.println("ID:");
            String id = scanner.nextLine();
            System.out.println("");
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("");
            if(checkUser(libRegUsers, id, name) == null) {
                System.out.println("invalid ID and/or name\n");
            }
            else {
                selectedRegUser = checkUser(libRegUsers, id, name);
            }
            
        }

        System.out.println("login success\nlogged in as " + selectedRegUser.getName() + "\n");

        regUserMenu(admin, lib, selectedRegUser);

        scanner.close();

    }

    public static RegUser checkUser(ArrayList<RegUser> libRegUsers, String id, String name) {
        for(RegUser r : libRegUsers) {
            boolean isValidRegUser = (String.valueOf(r.getId()).equals(id) && r.getName().toLowerCase().equals(name.toLowerCase()));
            if(isValidRegUser) {
                return r;
            }
        }
        
        return null;
    }

    public static void regUserMenu(Superuser admin, Library lib, RegUser selectedRegUser) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("LIBRARY MENU\nActions\n1 - browse library books\n2 - search for book\n3 - list my loans\n4 - borrow a book\n9 - whoami\nx - exit");
            System.out.println("Action:");
            String action = scanner.nextLine();
            System.out.println("");
            if(action.equals("1")) {
                while(true) {
                    System.out.println("SORT BOOKS\nActions\n1 - sort by author asc.\n2 - sort by author desc.\n3 - sort by title asc.\n4 - sort by title desc.\nx - exit");
                    System.out.println("Action:");
                    action = scanner.nextLine();
                    System.out.println("");
                    if(action.equals("1")) {
                        System.out.println(admin.getBooksByAuthorAsc(lib) + "\n");
                    }
                    else if(action.equals("2")) {
                        System.out.println(admin.getBooksByAuthorDesc(lib) + "\n");
                    }
                    else if(action.equals("3")) {
                        System.out.println(admin.getBooksByTitleAsc(lib) + "\n");
                    }
                    else if(action.equals("4")) {
                        System.out.println(admin.getBooksByTitleDesc(lib) + "\n");
                    }
                    else {
                        break;
                    }
                }
            }
            else if(action.equals("2")) {
                while(true) {
                    System.out.println("SEARCH FOR BOOK\nActions\n1 - search by author\n2 - search by title\n3 - search by author and title\nx - exit");
                    System.out.println("Action:");
                    action = scanner.nextLine();
                    System.out.println("");
                    if(action.equals("1")) {
                        System.out.println("Author:");
                        String author = scanner.nextLine();
                        System.out.println("");
                        System.out.println(selectedRegUser.searchBooksByAuthor(lib, author) + "\n");
                        
                    }
                    else if(action.equals("2")) {
                        System.out.println("Title:");
                        String title = scanner.nextLine();
                        System.out.println("");
                        System.out.println(selectedRegUser.searchBooksByTitle(lib, title) + "\n");
                    }
                    else if(action.equals("3")) {
                        System.out.println("Author:");
                        String author = scanner.nextLine();
                        System.out.println("");
                        System.out.println("Title:");
                        String title = scanner.nextLine();
                        System.out.println("");
                        if(selectedRegUser.searchBookExactMatch(lib, author, title) == null) {
                            System.out.println("book not found\n");
                        }
                        else {
                            System.out.println(selectedRegUser.searchBookExactMatch(lib, author, title));
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            else if(action.equals("3")) {
                System.out.println(selectedRegUser.getLoansAsStr());
            }
            else if(action.equals("4")) {
                System.out.println("BORROW A BOOK");
                System.out.println("Author:");
                String author = scanner.nextLine();
                System.out.println("");
                System.out.println("Title:");
                String title = scanner.nextLine();
                System.out.println("");
                Book request = selectedRegUser.searchBookExactMatch(lib, author, title);
                if(request == null) {
                    System.out.println("book not found\n");
                }
                else {
                    System.out.println(request);
                    System.out.println("Borrow this book? [y/N]");
                    String confirm = scanner.nextLine();
                    if(confirm.toLowerCase().equals("y")) {
                        selectedRegUser.addLoan(request);
                        System.out.println("\nadded loan\n" + selectedRegUser.getLoans().get(selectedRegUser.getLoans().size() - 1) + "\n");
                    }
                    else {
                        System.out.println("cancelling\n");
                    }
                }
            }
            else if(action.equals("9")) {
                System.out.println(selectedRegUser.getName() + "\n");
            }
            else {
                break;
            }
        }

        scanner.close();
        
    }

    public static void adminLogin(Superuser admin, Library lib) {

        Scanner scanner = new Scanner(System.in);

        boolean adminLoggedIn = admin.getLogInStatus();

            while(!adminLoggedIn) {
                System.out.println("Admin Login");
                System.out.println("default password is 'root'");

                System.out.println("Password:");
                String password = scanner.nextLine();

                System.out.println("");

                adminLoggedIn = admin.authenticate(password);
            }

        System.out.println("login success\n");

        adminMenu(admin, lib);

        scanner.close();
    }

    public static void adminMenu(Superuser admin, Library lib) {

        if(!admin.getLogInStatus()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("LIBRARY ADMINISTRATION\nActions\n1 - sort registered users\n2 - sort books\n3 - search for registered user\n9 - whoami\nx - exit");
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
                        System.out.println(admin.getBooksByAuthorAsc(lib) + "\n");
                    }
                    else if(action.equals("2")) {
                        System.out.println(admin.getBooksByAuthorDesc(lib) + "\n");
                    }
                    else if(action.equals("3")) {
                        System.out.println(admin.getBooksByTitleAsc(lib) + "\n");
                    }
                    else if(action.equals("4")) {
                        System.out.println(admin.getBooksByTitleDesc(lib) + "\n");
                    }
                    else {
                        break;
                    }
                }
            }
            else if(action.equals("3")) {
                while(true) {
                    System.out.println("SEARCH FOR REGISTERED USER\nActions\n1 - search by name\n2 - search by id\nx - exit");
                    System.out.println("Action:");
                    action = scanner.nextLine();
                    System.out.println("");
                    if(action.equals("1")) {
                        System.out.println("Name:");
                        String name = scanner.nextLine();
                        System.out.println("");
                        System.out.println(admin.searchRegUserByName(name, lib) + "\n");
                        
                    }
                    else if(action.equals("2")) {
                        System.out.println("ID:");
                        String id = scanner.nextLine();
                        System.out.println("");
                        System.out.println(admin.searchRegUserById(id, lib) + "\n");
                    }
                    else {
                        break;
                    }
                }
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
