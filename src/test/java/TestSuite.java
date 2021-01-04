import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSuite {
    private final BankConsoleSystem system;
    private SystemError result;

    public TestSuite() {
        this.system = new BankConsoleSystem();
    }

    @BeforeEach
    private void reloadDefaults() {
        this.system.reloadDefaults();
    }

    @Test
    public void testDepositCLP() {
        result = system.deposit(300_000, false);
        assertEquals(SystemError.OK, result);
        assertEquals(1_300_000, system.getCurrentUser().getBalance(false));
    }

    @Test
    public void testDepositCLPMaxAmount() {
        fail();
    }

    @Test
    public void testDepositCLPNegative() {
        fail();
    }

    @Test
    public void testDepositCLPMinAmount() {
        fail();
    }

    @Test
    public void testDepositUSD() {
        result = system.deposit(200, true);
        assertEquals(SystemError.OK, result);
        assertEquals(200, system.getCurrentUser().getBalance(true));
    }

    @Test
    public void testDepositUSDMaxAmount() {
        fail();
    }

    @Test
    public void testDepositUSDNegative() {
        fail();
    }

    @Test
    public void testDepositUSDMinAmount() {
        fail();
    }

    @Test
    public void testWithdrawCLP() {
        fail();
    }

    @Test
    public void testWithdrawUSD() {
        fail();
    }

    @Test
    public void testMaxNumberOfOperations() {
        fail();
    }

    @Test
    public void testGetHistoryOfTransactions() {
        fail();
    }

    @Test
    public void testLogIn() {
        result = system.logIn(2021, "new_year!");
        assertEquals(SystemError.OK, result);
        assertEquals(2021, system.getCurrentUser().getUserId());
    }

    @Test
    public void testLogInAlreadyLoggedIn() {
        result = system.logIn(2021, "new_year!");
        assertEquals(SystemError.OK, result);
        result = system.logIn(2020, "valid_password");
        assertEquals(SystemError.USER_ALREADY_LOGGED_IN, result);
        assertEquals(2021, system.getCurrentUser().getUserId());
    }

    @Test
    public void testLogInInvalidCredentials() {
        result = system.logIn(2021, "invalid_password");
        assertEquals(SystemError.USER_INVALID_CREDENTIALS, result);
        assertNull(system.getCurrentUser());
    }

    @Test
    public void testLogInUserNotExists() {
        result = system.logIn(2020, "valid_password");
        assertEquals(SystemError.USER_NOT_EXISTS, result);
        assertNull(system.getCurrentUser());
    }

    @Test
    public void testLogOut() {
        result = system.logIn(2021, "new_year!");
        assertEquals(SystemError.OK, result);
        result = system.logOut();
        assertEquals(SystemError.OK, result);
        assertNull(system.getCurrentUser());
    }

    @Test
    public void testLogOutNotLoggedIn() {
        result = system.logOut();
        assertEquals(SystemError.USER_NOT_LOGGED_IN, result);
        assertNull(system.getCurrentUser());
    }

}
