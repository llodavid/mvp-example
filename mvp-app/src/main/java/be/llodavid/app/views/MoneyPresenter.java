package be.llodavid.app.views;

public class MoneyPresenter implements MoneyView.MoneyViewListener{
    private final MoneyView view;
    private final MoneyModel model;

    public MoneyPresenter(MoneyView view, MoneyModel model) {
        this.view = view;
        this.model = model;
        view.addListener(this);
    }

    @Override
    public void viewOpened() {
        setBalance();
    }

    @Override
    public void depositClicked(double amount) {
        model.depositMoney(amount);
        setBalance();
    }

    @Override
    public void withdrawClicked(double amount) {
        model.withdrawMoney(amount);
        setBalance();
    }

    private void setBalance() {
        view.setBalance(model.getBalance());
    }
}
