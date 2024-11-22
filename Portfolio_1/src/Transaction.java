import java.math.BigDecimal;
import java.time.LocalDateTime;

class Transaction {
    private final String description;
    private final BigDecimal amount;
    private final LocalDateTime timestamp;
    private double runningBalance;
    // Constructor / Setter
    public Transaction(String description, BigDecimal amount, LocalDateTime timestamp) {
        this.description = description;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters
    public String getDescription() { return description; }
    public BigDecimal getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public double getRunningBalance() { return runningBalance; }
}