import java.math.*;
import java.time.*;
import java.util.*;

public class Account {
    private String accountId;
    private String accountHolder;
    private BigDecimal balance = BigDecimal.valueOf(0);
    private final List<Transaction> transactions = new ArrayList<>();

    public Account() {
        // Record initial balance as first transaction
        recordTransaction("Initial balance", balance);
    }

    public Account(String accountId, String accountHolder) {
        this();
        this.accountId = accountId;
        this.accountHolder = accountHolder;
    }

    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            System.out.println("Insufficient Funds! Debit amount is less than balance");
            return;
        }
        this.balance = balance.subtract(amount);
        recordTransaction("Debit", amount.negate());
    }

    public void credit(BigDecimal amount) {
        this.balance = balance.add(amount);
        recordTransaction("Credit", amount);
    }

    private void recordTransaction(String description, BigDecimal amount) {
        Transaction transaction = new Transaction(description, amount, LocalDateTime.now());
        transactions.add(transaction);
    }

    public void printHistory() {
        System.out.println("Account History for: " + accountHolder + " (ID: " + accountId + ")");
        System.out.println("----------------------------------------");
        BigDecimal runningBalance = BigDecimal.ZERO;
        for (Transaction t : transactions) {
            runningBalance = runningBalance.add(t.getAmount());
            System.out.printf("%s | %s | Amount: $%1.2f | Balance: $%1.2f%n",
                    t.getTimestamp().toString(),
                    t.getDescription(),
                    t.getAmount(),
                    runningBalance);
        }
        System.out.println("----------------------------------------");
        System.out.println("Current Balance: $" + balance);
    }
}