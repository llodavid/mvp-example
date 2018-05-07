package be.llodavid.app.views;

import be.llodavid.app.resources.MoneyResource;

import java.util.ArrayList;
import java.util.List;

public class MoneyModel {
    private final MoneyResource moneyResource;

    public MoneyModel(MoneyResource moneyResource) {
        this.moneyResource = moneyResource;
    }

    public void depositMoney(double amount) {
        moneyResource.deposit(amount);
    }

    public void withdrawMoney(double amount) {
        moneyResource.withdraw(amount);
    }

    public double getBalance() {
        return moneyResource.getBalance();
    }
}
