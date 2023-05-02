import java.security.NoSuchAlgorithmException;

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
    
}
