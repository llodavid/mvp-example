package be.llodavid.app.views;

public interface MoneyView {
    void addListener(MoneyViewListener listener);

    void setBalance(double balance);

    interface MoneyViewListener {

        void viewOpened();
    }
}
