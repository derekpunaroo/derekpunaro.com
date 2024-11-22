import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private final List<Transaction> transactions = new ArrayList<>();
    private double currentBalance = 0.0;

    public void recordTransaction(String description, BigDecimal amount) {
        Transaction transaction = new Transaction(description, amount, LocalDateTime.now());
        transactions.add(transaction);
        currentBalance = currentBalance + amount.doubleValue();
    }

    public List<Transaction> getHistory() {
        return new ArrayList<>(transactions); // Return a copy to prevent modification
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void printHistory() {
        System.out.println("Account History:");
        System.out.println("----------------");
        for (Transaction t : transactions) {
            System.out.printf("%s | Amount: $%.2f | Balance: $%.2f | Description: %s%n",
                    t.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    t.getAmount(),
                    t.getRunningBalance(),
                    t.getDescription());
        }
        System.out.println("----------------");
        System.out.printf("Current Balance: $%.2f%n", currentBalance);
    }
}