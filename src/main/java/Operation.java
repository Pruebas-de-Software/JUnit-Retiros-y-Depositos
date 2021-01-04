public class Operation {
    private final long value;
    private final boolean isUSD;
    private final boolean isDeposit;

    public Operation(boolean isDeposit, boolean isUSD, long value) {
        this.value = value;
        this.isDeposit = isDeposit;
        this.isUSD = isUSD;
    }

    public long getValue() {
        return value;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public boolean isUSD() {
        return isUSD;
    }
}
