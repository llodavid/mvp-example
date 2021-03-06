package be.llodavid.app.views;

public class MoneyPresenter implements MoneyView.MoneyViewListener{
    private final MoneyView view;
    private final MoneyModel model;

    public MoneyPresenter(MoneyView view, MoneyModel model) {
        this.view = view;
        this.model = model;
        view.addListener(this);
    }
}
