import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA256 {
    public static String getDigest(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes());
        byte[] digest = messageDigest.digest();
        return Base64.getEncoder().encodeToString(digest);
    }
}
