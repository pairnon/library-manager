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
    public ArrayList<RegUser> getRegUsersByNameAsc(Library library) {

        if(!loggedIn) return null;

        ArrayList<RegUser> regUsers = library.getRegUsers();

        for(int i = 1; i < regUsers.size(); i++) {
            RegUser regUser = regUsers.get(i);
            int back = i - 1;

            while(back >= 0 && regUser.getName().compareTo(regUsers.get(back).getName()) < 0) {
                regUsers.set(back+1, regUsers.get(back));
                back--;
            }

            regUsers.set(back + 1, regUser);

        }

        return regUsers;
    }

    // Insertion sort descending
    public ArrayList<RegUser> getRegUsersByNameDesc(Library library) {

        if(!loggedIn) return null;

        ArrayList<RegUser> regusers = library.getRegUsers();

        for(int i = 1; i < regusers.size(); i++) {
            RegUser reguser = regusers.get(i);
            int back = i - 1;

            while(back >= 0 && reguser.getName().compareTo(regusers.get(back).getName()) > 0) {
                regusers.set(back+1, regusers.get(back));
                back--;
            }

            regusers.set(back + 1, reguser);

        }

        return regusers;
    }

    // Insertion sort ascending
    public ArrayList<RegUser> getRegUsersByIdAsc(Library library) {

        if(!loggedIn) return null;

        ArrayList<RegUser> regusers = library.getRegUsers();

        for(int i = 1; i < regusers.size(); i++) {
            RegUser reg = regusers.get(i);
            int back = i - 1;

            while(back >= 0 && reg.getId() < regusers.get(back).getId()) {
                regusers.set(back+1, regusers.get(back));
                back--;
            }

            regusers.set(back + 1, reg);

        }

        return regusers;
    }

    // Insertion sort descending
    public ArrayList<RegUser> getRegUsersByIdDesc(Library library) {

        if(!loggedIn) return null;

        ArrayList<RegUser> regusers = library.getRegUsers();

        for(int i = 1; i < regusers.size(); i++) {
            RegUser reguser = regusers.get(i);
            int back = i - 1;

            while(back >= 0 && reguser.getId() > regusers.get(back).getId()) {
                regusers.set(back+1, regusers.get(back));
                back--;
            }

            regusers.set(back + 1, reguser);

        }

        return regusers;
    }

}
