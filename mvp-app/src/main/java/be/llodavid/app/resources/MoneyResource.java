package be.llodavid.app.resources;

import org.springframework.stereotype.Component;

@Component
public class MoneyResource {
    double balance = 1500.49;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
