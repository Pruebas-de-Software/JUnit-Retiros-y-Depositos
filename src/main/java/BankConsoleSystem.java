import java.util.ArrayList;
import java.util.HashMap;

public class BankConsoleSystem {
    private Client currentUser;
    private HashMap<Integer, Client> systemUsers;

    public BankConsoleSystem() {
        setup();
    }

    private void setup() {
        currentUser = null;
        systemUsers = new HashMap<>();
        createUsers();
    }

    private void createUsers() {
        systemUsers.put(2021, new Client(2021, "new_year!"));
    }

    public SystemError logIn(int id, String password) {
        return SystemError.UNKNOWN;
    }

    public void reloadDefaults() {
        // This resets accounts
    }

    public void interactive() {
        // This starts the interactive flow for users
    }
}
