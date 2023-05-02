import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Superuser extends User {

    private PasswordHash password;

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

    // Insertion sort ascending
    public ArrayList<User> getUsersByNameAsc(Library library) {
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

    // Insertion sort ascending
    public ArrayList<User> getUsersByNameDesc(Library library) {
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

}
