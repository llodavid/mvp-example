package be.llodavid.app.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CustomComponent;

import java.util.ArrayList;
import java.util.List;

public class MoneyViewVaadin extends CustomComponent implements View, MoneyView {
    private List<MoneyViewListener> listeners;

    public MoneyViewVaadin() {
        listeners = new ArrayList<>();
    }

    @Override
    public void addListener(MoneyViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
