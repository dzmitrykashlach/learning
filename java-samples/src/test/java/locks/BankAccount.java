package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private Lock balanceChangeLock;
    private Condition sufficientFundsCondition;

    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccount() {
        balance = 0;
        balanceChangeLock = new ReentrantLock();
        sufficientFundsCondition = balanceChangeLock.newCondition();
    }

    /**
     * Deposits money into the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balanceChangeLock.lock();
        try {
            System.out.print("Depositing " + amount);
            double newBalance = balance + amount;
            System.out.println(", new balance is " + newBalance);
            balance = newBalance;
            sufficientFundsCondition.signalAll();
        } finally {
            balanceChangeLock.unlock();
        }
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public boolean withdraw(double amount) {
        balanceChangeLock.lock();
        try {
            while (balance < amount) {
                if (!sufficientFundsCondition.await(7000, TimeUnit.MILLISECONDS)) {
                    System.out.println("Failed to withdraw  " + amount + " from " + this);
                    return false;
                }
            }
            System.out.print("Withdrawing " + amount);
            double newBalance = balance - amount;
            System.out.println(", new balance is " + newBalance);
            balance = newBalance;
            return true;
        } catch (InterruptedException e) {
            System.out.println("Failed to withdraw  " + amount + " from " + this);
            return false;
        } finally {
            balanceChangeLock.unlock();
        }
    }

    public class Transferer {
        private static Lock transferLock = new ReentrantLock();

        public static void perform(BankAccount from, BankAccount to, double amount) {
            try {
                if (transferLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    try {
                        if (!from.withdraw(amount)) {
                            return;
                        }
                        to.deposit(amount);
                    } finally {
                        transferLock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Failed to transfer  " + amount + " from " + from + " to " + to);
            }

        }
    }
}