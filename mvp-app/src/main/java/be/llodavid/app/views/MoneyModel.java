package be.llodavid.app.views;

import be.llodavid.app.resources.MoneyResource;

import java.util.ArrayList;
import java.util.List;

public class MoneyModel {
    private List<MoneyModelListener> listeners;
    private final MoneyResource moneyResource;

    public MoneyModel(MoneyResource moneyResource) {
        this.moneyResource = moneyResource;
        listeners = new ArrayList<>();
    }

    public void viewOpened() {
        communicateBalance();
    }

    private void communicateBalance() {
        listeners.forEach(listener -> listener.newBalance(moneyResource.getBalance()));
    }

    interface MoneyModelListener {
        void newBalance(double balance);
    }
}
