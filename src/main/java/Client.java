import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;

public class Client {
    private final int userId;
    private final String storedPassword;
    private final CurrencyAccount accountUSD;
    private final CurrencyAccount accountCLP;
    private final ArrayList<Operation> history;
    private MessageDigest hashing;

    public Client(int id, String clearPassword) {
        accountCLP = new CurrencyAccount();
        accountUSD = new CurrencyAccount();
        try {
            // This could be a test, but is not needed by the spec (?)
            // FIXME: When all test are finished add a new test for this
            hashing = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException exception) {
            System.exit(2);
        }
        hashing.update(clearPassword.getBytes(StandardCharsets.UTF_8));
        storedPassword = DatatypeConverter.printHexBinary(hashing.digest()).toLowerCase(Locale.ROOT);
        userId = id;
        history = new ArrayList<>();
    }

    public boolean validatePassword(String password) {
        hashing.update(password.getBytes(StandardCharsets.UTF_8));
        String hashDigest = DatatypeConverter.printHexBinary(hashing.digest()).toLowerCase(Locale.ROOT);
        return storedPassword.equals(hashDigest);
    }

    public long getBalance(boolean isUSD) {
        return -1;
    }

    public int getUserId() {
        return userId;
    }

    public SystemError doOperation(Operation op) {
        return SystemError.UNKNOWN;
    }
}
