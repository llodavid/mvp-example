package be.llodavid.app;

import be.llodavid.app.resources.MoneyResource;
import be.llodavid.app.views.MoneyModel;
import be.llodavid.app.views.MoneyPresenter;
import be.llodavid.app.views.MoneyViewVaadin;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class MvpUI extends UI {

    private MoneyResource moneyResource;

    @Autowired
    public MvpUI(MoneyResource moneyResource) {
        this.moneyResource = moneyResource;
    }

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);

        MoneyViewVaadin moneyView = new MoneyViewVaadin();
        MoneyModel moneyModel = new MoneyModel(moneyResource);
        MoneyPresenter moneyPresenter = new MoneyPresenter(moneyView,moneyModel)
                ;
        navigator.addView("", moneyView);
    }
}
