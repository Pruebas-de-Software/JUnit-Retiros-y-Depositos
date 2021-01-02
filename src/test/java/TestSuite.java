import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSuite {
    private final BankConsoleSystem system;
    private SystemError result;

    public TestSuite() {
        this.system = new BankConsoleSystem();
        this.system.reloadDefaults();
    }

    @Test
    public void testDoDepositCLP() {
        assertEquals(true, false);
    }

    @Test
    public void testDoDepositUSD() {
        assertEquals(true, false);
    }

    @Test
    public void testDoWithdrawCLP() {
        assertEquals(true, false);
    }

    @Test
    public void testDoWithdrawUSD() {
        assertEquals(true, false);
    }

    @Test
    public void testMaxNumberOfOperations() {
        assertEquals(true, false);
    }

    @Test
    public void testGetHistoryOfTransactions() {
        assertEquals(true, false);
    }

    @Test
    public void testLogIn() {
        system.reloadDefaults();
        result = system.logIn(2021, "new_year!");
        assertEquals(SystemError.OK, result);
        assertEquals(2021, system.getCurrentUser().getUserId());
    }

    @Test
    public void testLogInAlreadyLoggedIn() {
        assertEquals(true, false);
    }

    @Test
    public void testLogInInvalidCredentials() {
        system.reloadDefaults();
        result = system.logIn(2021, "invalid_password");
        assertEquals(SystemError.USER_INVALID_CREDENTIALS, result);
        assertNull(system.getCurrentUser());
    }

    @Test
    public void testLogInUserNotExists() {
        system.reloadDefaults();
        result = system.logIn(2020, "valid_password");
        assertEquals(SystemError.USER_NOT_EXISTS, result);
        assertNull(system.getCurrentUser());
    }

    @Test
    public void testLogOut() {
        system.reloadDefaults();
        result = system.logIn(2021, "new_year!");
        assertEquals(SystemError.OK, result);
        result = system.logOut();
        assertEquals(SystemError.OK, result);
    }

    @Test
    public void testLogOutNotLoggedIn() {
        system.reloadDefaults();
        result = system.logOut();
        assertEquals(SystemError.NOT_LOGGED_IN, result);
    }

}