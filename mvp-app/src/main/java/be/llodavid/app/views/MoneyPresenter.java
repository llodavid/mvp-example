package be.llodavid.app.views;

public class MoneyPresenter implements MoneyView.MoneyViewListener,
        MoneyModel.MoneyModelListener{
    private final MoneyView view;
    private final MoneyModel model;

    public MoneyPresenter(MoneyView view, MoneyModel model) {
        this.view = view;
        this.model = model;
        view.addListener(this);
        model.addListener(this);
    }

    @Override
    public void viewOpened() {
        model.viewOpened();
    }

    @Override
    public void depositClicked(double amount) {
        model.depositMoney(amount);
    }

    @Override
    public void withdrawClicked(double amount) {
        model.withdrawMoney(amount);
    }

    @Override
    public void newBalance(double balance) {
        view.setBalance(balance);
    }
}
