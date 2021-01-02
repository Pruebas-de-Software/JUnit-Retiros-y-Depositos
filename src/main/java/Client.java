public class Client {
    private int userId;
    private String storedPassword;
    private final CurrencyAccount accountUSD;
    private final CurrencyAccount accountCLP;

    public Client(int id, String clearPassword) {
        accountCLP = new CurrencyAccount();
        accountUSD = new CurrencyAccount();
    }
}
