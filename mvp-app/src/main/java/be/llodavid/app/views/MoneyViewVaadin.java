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
    private Button btnDeposit, btnWithdraw;

    public MoneyViewVaadin() {
        listeners = new ArrayList<>();

        TextField txtAmount = createTxtAmount();

        btnDeposit = new Button("Deposit",
                click -> listeners.forEach(
                        listener -> listener.depositClicked(Double.parseDouble(txtAmount.getValue()))));
        btnWithdraw = new Button("Withdraw",
                click -> listeners.forEach(
                        listener -> listener.withdrawClicked(Double.parseDouble(txtAmount.getValue()))));

        setCompositionRoot(renderComponents(createBalanceLayout(), txtAmount));
    }

    private TextField createTxtAmount() {
        TextField txtAmount = new TextField();
        txtAmount.setWidth("75px");
        txtAmount.setValue("100");
        txtAmount.setStyleName(ValoTheme.TEXTFIELD_ALIGN_CENTER);
        return txtAmount;
    }

    private VerticalLayout renderComponents(HorizontalLayout balanceLayout, TextField amount) {
        HorizontalLayout withdrawDepositLayout = new HorizontalLayout(btnDeposit, amount, btnWithdraw);

        VerticalLayout contentLayout = new VerticalLayout(balanceLayout, withdrawDepositLayout);

        contentLayout.setComponentAlignment(balanceLayout, Alignment.MIDDLE_CENTER);
        contentLayout.setComponentAlignment(withdrawDepositLayout, Alignment.MIDDLE_CENTER);

        withdrawDepositLayout.setStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        contentLayout.setStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        return new VerticalLayout(contentLayout);
    }

    private HorizontalLayout createBalanceLayout() {
        lblBalance = new Label();
        lblBalance.setStyleName(ValoTheme.LABEL_HUGE);

        return new HorizontalLayout(lblBalance);
    }

    @Override
    public void addListener(MoneyViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void setBalance(double balance) {
        lblBalance.setValue(String.format("€ %.2f", balance));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        listeners.forEach(listener -> listener.viewOpened());
    }
}
