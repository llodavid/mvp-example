package be.llodavid.app.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class MoneyViewVaadin extends CustomComponent implements View, MoneyView {
    private List<MoneyViewListener> listeners;
    private Label lblBalance;
    public MoneyViewVaadin() {
        listeners = new ArrayList<>();

        lblBalance = new Label("default");
        lblBalance.setStyleName(ValoTheme.LABEL_HUGE);

        Button btnDeposit = new Button("Deposit");
        TextField txtAmount = new TextField();
        txtAmount.setWidth("150px");
        Button btnWithdraw = new Button("Withdraw");

        HorizontalLayout withdrawDepositLayout = new HorizontalLayout(btnDeposit,txtAmount,btnWithdraw);
        VerticalLayout contentLayout = new VerticalLayout(lblBalance,withdrawDepositLayout);
        VerticalLayout mainLayout = new VerticalLayout(contentLayout);
        setCompositionRoot(mainLayout);
    }

    @Override
    public void addListener(MoneyViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void setBalance(double balance) {
        lblBalance.setValue(String.format("text : %.2f",balance));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        listeners.forEach(listener -> listener.viewOpened());
    }
}
