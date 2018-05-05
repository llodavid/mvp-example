package be.llodavid.app.views;

public interface MoneyView {
    void addListener(MoneyViewListener listener);
    void setBalance(double balance);

    interface MoneyViewListener {
        void viewOpened();
        void depositClicked(double amount);
        void withdrawClicked(double amount);
    }
}
