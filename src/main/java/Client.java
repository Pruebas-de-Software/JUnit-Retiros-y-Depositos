import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Client {
    private int userId;
    private String storedPassword;
    private final CurrencyAccount accountUSD;
    private final CurrencyAccount accountCLP;
    private MessageDigest hashing;

    public Client(int id, String clearPassword) {
        accountCLP = new CurrencyAccount();
        accountUSD = new CurrencyAccount();
        try {
            hashing = MessageDigest.getInstance("MD5"); // This could be a test, but is not needed by the spec (?)
        } catch (NoSuchAlgorithmException exception) {
            System.exit(2);
        }
        hashing.update(clearPassword.getBytes(StandardCharsets.UTF_8));
        storedPassword = DatatypeConverter.printHexBinary(hashing.digest()).toLowerCase(Locale.ROOT);
        userId = id;
    }

    public boolean validatePassword(String password) {
        hashing.update(password.getBytes(StandardCharsets.UTF_8));
        String hashDigest = DatatypeConverter.printHexBinary(hashing.digest()).toLowerCase(Locale.ROOT);
        return storedPassword.equals(hashDigest);
    }

    public int getUserId() {
        return userId;
    }
}
