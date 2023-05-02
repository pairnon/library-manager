public class PasswordHash {

    private String passwordHash;

    public PasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String toString() {
        return passwordHash;
    }

}