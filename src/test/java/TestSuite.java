import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSuite {
    private final BankConsoleSystem system;

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
        assertEquals(true, false);
    }

    @Test
    public void testLogOut() {
        assertEquals(true, false);
    }
}
