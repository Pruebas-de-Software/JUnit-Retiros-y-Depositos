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
        result = system.logIn(2021, "new_year1!");
        assertEquals(SystemError.OK, result);
    }

    @Test
    public void testLogInInvalidCredentials() {
        system.reloadDefaults();
        result = system.logIn(2021, "invalid_password");
        assertEquals(SystemError.USER_INVALID_CREDENTIALS, result);
    }

    @Test
    public void testLogInUserNotExists() {
        assertEquals(true, false);
    }

    @Test
    public void testLogOut() {
        assertEquals(true, false);
    }

    @Test
    public void testLogOutNotLoggedIn() {
        assertEquals(true, false);
    }
}
