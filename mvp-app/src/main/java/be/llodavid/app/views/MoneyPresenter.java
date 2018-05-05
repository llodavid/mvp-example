package be.llodavid.app.views;

public class MoneyPresenter implements MoneyView.MoneyViewListener,
        MoneyModel.MoneyModelListener{
    private final MoneyView view;
    private final MoneyModel model;

    public MoneyPresenter(MoneyView view, MoneyModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void viewOpened() {
        model.viewOpened();
    }

    @Override
    public void newBalance(double balance) {
        view.setBalance(balance);
    }
}
