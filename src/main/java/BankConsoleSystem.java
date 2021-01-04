import java.util.HashMap;
import java.util.List;

public class BankConsoleSystem {
    private Client currentUser;
    private HashMap<Integer, Client> systemUsers;
    private final float MIN_DEPOSIT_USD = 10;
    private final float MIN_DEPOSIT_CLP = 2000;
    private final float MIN_WITHDRAW_USD = 10;
    private final float MIN_WITHDRAW_CLP = 2000;
    private final float MAX_WITHDRAW_USD = 100;
    private final float MAX_WITHDRAW_CLP = 200_000;
    private final int MAX_OPERATIONS_SESSION = 4;
    private int currentOperations;

    public BankConsoleSystem() {
        setup();
        //FIXME: logging (log4j or logback)
    }

    private void setup() {
        currentOperations = 0;
        currentUser = null;
        systemUsers = new HashMap<>();
        createUsers();
    }

    private void createUsers() {
        systemUsers.put(2021, new Client(2021, "new_year!"));
    }

    public SystemError deposit(long amount, boolean isUSD) {
        if (currentUser != null) {
            if (currentOperations > MAX_OPERATIONS_SESSION) {
                return SystemError.SESSION_NUMBER_OF_OPERATIONS_EXCEEDED;
            }
            Operation op;
            if (isUSD) {
                if (amount >= MIN_DEPOSIT_USD) {
                    op = new Operation(true, true, amount);
                    SystemError rc = currentUser.doOperation(op);
                    if (rc == SystemError.OK) {
                        currentOperations += 1;
                    }
                    return rc;
                } else {
                    return SystemError.INVALID_OPERATION_AMOUNT;
                }
            } else {
                if (amount >= MIN_DEPOSIT_CLP) {
                    op = new Operation(true, false, amount);
                    SystemError rc = currentUser.doOperation(op);
                    if (rc == SystemError.OK) {
                        currentOperations += 1;
                    }
                    return rc;
                } else {
                    return SystemError.INVALID_OPERATION_AMOUNT;
                }
            }
        } else {
            return SystemError.USER_NOT_LOGGED_IN;
        }
    }

    public SystemError withdraw(long amount, boolean isUSD) {
        if (currentUser != null) {
            if (currentOperations > MAX_OPERATIONS_SESSION) {
                return SystemError.SESSION_NUMBER_OF_OPERATIONS_EXCEEDED;
            }
            Operation op;
            if (isUSD) {
                if (amount >= MIN_WITHDRAW_USD && amount <= MAX_WITHDRAW_USD) {
                    op = new Operation(false, true, amount);
                    SystemError rc = currentUser.doOperation(op);
                    if (rc == SystemError.OK) {
                        currentOperations += 1;
                    }
                    return rc;
                } else {
                    return SystemError.INVALID_OPERATION_AMOUNT;
                }
            } else {
                if (amount >= MIN_WITHDRAW_CLP && amount <= MAX_WITHDRAW_CLP) {
                    op = new Operation(false, false, amount);
                    SystemError rc = currentUser.doOperation(op);
                    if (rc == SystemError.OK) {
                        currentOperations += 1;
                    }
                    return rc;
                } else {
                    return SystemError.INVALID_OPERATION_AMOUNT;
                }
            }
        } else {
            return SystemError.USER_NOT_LOGGED_IN;
        }
    }

    public SystemError logIn(int id, String password) {
        if (currentUser == null) {
            if (systemUsers.containsKey(id)) {
                Client client = systemUsers.get(id);
                if (client.validatePassword(password)) {
                    currentUser = client;
                    currentOperations = 0;
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

    public Pair<SystemError, List<Operation>> getHistory() {
        Pair<SystemError, List<Operation>> result = new Pair<>(SystemError.UNKNOWN, null);
        if (currentUser != null) {
            result.setFirst(SystemError.OK);
            result.setSecond(currentUser.getHistory());
        } else {
            result.setFirst(SystemError.USER_NOT_LOGGED_IN);
        }
        return result;
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
