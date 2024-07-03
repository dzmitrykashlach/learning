package locks;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void withdraw() {
        var from = new BankAccount();
        var to = new BankAccount();
        for (int i = 0; i <= 10; i++) {
            Thread.startVirtualThread(() -> {
                BankAccount.Transferer.perform(from, to, 3);
            });
        }
        for (int i = 0; i <= 30; i++) {
            Thread.startVirtualThread(() -> {
                from.deposit(1);
            });
        }
    }
}
