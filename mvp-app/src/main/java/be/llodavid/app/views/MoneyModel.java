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

    public void addListener(MoneyModelListener listener) {
        listeners.add(listener);
    }

    interface MoneyModelListener {

    }
}
