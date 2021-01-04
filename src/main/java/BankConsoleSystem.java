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

    public SystemError deposit(long amount, boolean isUSD) {
        return SystemError.UNKNOWN;
    }

    public SystemError withdraw(long amount, boolean isUSD) {
        return SystemError.UNKNOWN;
    }

    public SystemError logIn(int id, String password) {
        if (currentUser == null) {
            if (systemUsers.containsKey(id)) {
                Client client = systemUsers.get(id);
                if (client.validatePassword(password)) {
                    currentUser = client;
                    return SystemError.OK;
                } else {
                    return SystemError.USER_INVALID_CREDENTIALS;
                }
            } else {
                return SystemError.USER_NOT_EXISTS;
            }
        } else {
            return SystemError.USER_ALREADY_LOGGED_IN;
        }
    }

    public SystemError logOut() {
        if (currentUser != null) {
            currentUser = null;
            return SystemError.OK;
        } else {
            return SystemError.USER_NOT_LOGGED_IN;
        }
    }

    public Client getCurrentUser() {
        return currentUser;
    }

    public void reloadDefaults() {
        setup();
    }

    public void interactive() {
        // This starts the interactive flow for users
    }
}
