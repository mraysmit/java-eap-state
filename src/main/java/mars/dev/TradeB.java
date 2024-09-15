package mars.dev;

public class TradeB {
    private final String tradeId;
    private final String counterpartyId;
    private final double amount;

    public TradeB(String tradeId, String counterpartyId, double amount) {
        this.tradeId = tradeId;
        this.counterpartyId = counterpartyId;
        this.amount = amount;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return String.format("Trade Id: %s, Counterparty Id %s, amount: %s, status: %s", tradeId, counterpartyId, amount);
    }
}