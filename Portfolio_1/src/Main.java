import java.math.BigDecimal;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {
            String uniqueID = UUID.randomUUID().toString();

            Account account = new Account(uniqueID, "Derek Punaro");

            account.debit(new BigDecimal("50.00"));
            account.credit(new BigDecimal("75.00"));
            account.debit(new BigDecimal("25.00"));
            account.debit(new BigDecimal("50.00"));
            account.credit(new BigDecimal("75.00"));
            account.debit(new BigDecimal("65.00"));

            account.printHistory();
            account.getBalanceAsString();
        }
}