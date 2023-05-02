import java.security.NoSuchAlgorithmException;

public class Superuser extends User {

    private PasswordHash password;

    public Superuser(String name, int id, String password) throws NoSuchAlgorithmException {
        super(name, id);
        this.password = new PasswordHash(SHA256.getDigest(password));
    }

    public PasswordHash getPassword() {
        return password;
    }
    
}
