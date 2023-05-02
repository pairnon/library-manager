import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Superuser extends User {

    private PasswordHash password;
    private boolean loggedIn = false;

    public Superuser(String name, int id, String password) {
        super(name, id);
        try {
            this.password = new PasswordHash(SHA256.getDigest(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public PasswordHash getPassword() {
        return password;
    }

    public boolean getLogInStatus() {
        return loggedIn;
    }

    public boolean authenticate(String passwordAttempt) {
        
        PasswordHash hashedAttempt;
        
        try {
            hashedAttempt = new PasswordHash(SHA256.getDigest(passwordAttempt));
            if(this.password.equals(hashedAttempt)) {
                loggedIn = true;
                return true;
            }

            else return false;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Insertion sort ascending
    public ArrayList<User> getUsersByNameAsc(Library library) {

        if(!loggedIn) return null;

        ArrayList<User> users = library.getUsers();

        for(int i = 1; i < users.size(); i++) {
            User user = users.get(i);
            int back = i - 1;

            while(back >= 0 && user.getName().compareTo(users.get(back).getName()) < 0) {
                users.set(back+1, users.get(back));
                back--;
            }

            users.set(back + 1, user);

        }

        return users;
    }

    // Insertion sort descending
    public ArrayList<User> getUsersByNameDesc(Library library) {

        if(!loggedIn) return null;

        ArrayList<User> users = library.getUsers();

        for(int i = 1; i < users.size(); i++) {
            User user = users.get(i);
            int back = i - 1;

            while(back >= 0 && user.getName().compareTo(users.get(back).getName()) > 0) {
                users.set(back+1, users.get(back));
                back--;
            }

            users.set(back + 1, user);

        }

        return users;
    }

    // Insertion sort ascending
    public ArrayList<User> getUsersByIdAsc(Library library) {

        if(!loggedIn) return null;

        ArrayList<User> users = library.getUsers();

        for(int i = 1; i < users.size(); i++) {
            User user = users.get(i);
            int back = i - 1;

            while(back >= 0 && user.getId() < users.get(back).getId()) {
                users.set(back+1, users.get(back));
                back--;
            }

            users.set(back + 1, user);

        }

        return users;
    }

    // Insertion sort descending
    public ArrayList<User> getUsersByIdDesc(Library library) {

        if(!loggedIn) return null;

        ArrayList<User> users = library.getUsers();

        for(int i = 1; i < users.size(); i++) {
            User user = users.get(i);
            int back = i - 1;

            while(back >= 0 && user.getId() > users.get(back).getId()) {
                users.set(back+1, users.get(back));
                back--;
            }

            users.set(back + 1, user);

        }

        return users;
    }

}
