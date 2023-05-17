import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA256 {

    // returns a 'human readable' SHA-256 digest from an input String
    public static String getDigest(String str) throws NoSuchAlgorithmException {

        // create an instance of the MessageDigest class using SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        // update the MessageDigest with the input String converted to bytes
        messageDigest.update(str.getBytes());
        // generate the digest; this is where the magic happens
        byte[] digest = messageDigest.digest();
        // return the digest as a 'human readable' String
        return Base64.getEncoder().encodeToString(digest);

    }

}
