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
        system.logIn(2021, "new_year!");
        result = system.deposit(300_000, false);
        assertEquals(SystemError.OK, result);
        assertEquals(1_300_000, system.getCurrentUser().getBalance(false));
    }

    @Test
    public void testDepositCLPNotLoggedIn() {
        result = system.deposit(300_000, false);
        assertEquals(SystemError.USER_NOT_LOGGED_IN, result);
    }

    @Test
    public void testDepositCLPMaxAmount() {
        system.logIn(2021, "new_year!");
        result = system.deposit(Long.MAX_VALUE, false);
        assertEquals(SystemError.INVALID_OPERATION_AMOUNT_MAX_OVERFLOW, result);
    }

    @Test
    public void testDepositCLPNegative() {
        system.logIn(2021, "new_year!");
        result = system.deposit(-200_000, false);
        assertEquals(SystemError.INVALID_OPERATION_AMOUNT, result);
    }

    @Test
    public void testDepositCLPMinAmount() {
        system.logIn(2021, "new_year!");
        result = system.deposit(1000, false);
        assertEquals(SystemError.INVALID_OPERATION_AMOUNT, result);
    }

    @Test
    public void testDepositUSD() {
        system.logIn(2021, "new_year!");
        result = system.deposit(200, true);
        assertEquals(SystemError.OK, result);
        assertEquals(200, system.getCurrentUser().getBalance(true));
    }

    @Test
    public void testDepositUSDNotLoggedIn() {
        result = system.deposit(300_000, true);
        assertEquals(SystemError.USER_NOT_LOGGED_IN, result);
    }

    @Test
    public void testDepositUSDMaxAmount() {
        system.logIn(2021, "new_year!");
        system.deposit(3_000, true);
        result = system.deposit(Long.MAX_VALUE, true);
        assertEquals(SystemError.INVALID_OPERATION_AMOUNT_MAX_OVERFLOW, result);
    }

    @Test
    public void testDepositUSDNegative() {
        system.logIn(2021, "new_year!");
        result = system.deposit(-2_000, true);
        assertEquals(SystemError.INVALID_OPERATION_AMOUNT, result);
    }

    @Test
    public void testDepositUSDMinAmount() {
        system.logIn(2021, "new_year!");
        result = system.deposit(5, true);
        assertEquals(SystemError.INVALID_OPERATION_AMOUNT, result);
    }

    @Test
    public void testWithdrawCLP() {
        fail();
    }

    @Test
    public void testWithdrawCLPMaxAmount() {
        fail();
    }

    @Test
    public void testWithdrawCLPNegative() {
        fail();
    }

    @Test
    public void testWithdrawCLPMinAmount() {
        fail();
    }

    @Test
    public void testWithdrawCLPAllFunds() {
        fail();
    }

    @Test
    public void testWithdrawCLPNoFunds() {
        fail();
    }

    @Test
    public void testWithdrawUSD() {
        fail();
    }

    @Test
    public void testWithdrawUSDMaxAmount() {
        fail();
    }

    @Test
    public void testWithdrawUSDNegative() {
        fail();
    }

    @Test
    public void testWithdrawUSDMinAmount() {
        fail();
    }

    @Test
    public void testWithdrawUSDAllFunds() {
        fail();
    }

    @Test
    public void testWithdrawUSDNoFunds() {
        fail();
    }

    @Test
    public void testNumberOfOperationsInSession() {
        fail();
    }

    @Test
    public void testNumberOfOperationsInSessionMax() {
        fail();
    }

    @Test
    public void testGetHistoryEmpty() {
        fail();
    }

    @Test
    public void testGetHistoryDepositCLP() {
        fail();
    }

    @Test
    public void testGetHistoryDepositUSD() {
        fail();
    }

    @Test
    public void testGetHistoryWithdrawCLP() {
        fail();
    }

    @Test
    public void testGetHistoryWithdrawUSD() {
        fail();
    }

    @Test
    public void testGetHistoryMultipleOperations() {
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
        system.logIn(2021, "new_year!");
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
        system.logIn(2021, "new_year!");
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
