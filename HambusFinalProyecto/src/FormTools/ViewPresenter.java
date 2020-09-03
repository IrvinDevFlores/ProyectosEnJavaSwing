package FormTools;

import App.InicioForm;
import AppTools.Interfaces.IView;
import AppTools.Interfaces.IViewPresenter;
import Menu.AdminMenuContainer;
import Orders.ChooseTableForm;
import Orders.MakeOrderView;

import Personal.AdminEmpleadosForm;
import java.util.ArrayList;

import javax.swing.JPanel;

public final class ViewPresenter implements IViewPresenter {

    public ViewPresenter() {
        ConfigViews();

    }

    private ArrayList<IView> views;

    @Override
    public ArrayList<IView> GetViews() {
        return views;
    }

    public void ConfigViews() {
        views = new ArrayList<>();

        views.add(new InicioForm(Views.INICIO));
        views.add(new AdminEmpleadosForm(Views.ADMIN_EMPLEADOS));
        
        views.add(new ChooseTableForm(Views.ELEGIR_MESA));
        views.add(new MakeOrderView(Views.HACER_ORDEN));
         views.add(new AdminMenuContainer(Views.ADMIN_MENU));
         views.add(new AdminMenuContainer(Views.ADMIN_USERS));         
    }

    @Override
    public void HideView(JPanel panel) {
        panel.setVisible(false);
    }

    @Override
    public IView ShowView(Views route) {
        IView view = GetViews().stream()
                .filter(v -> v.ViewName.equals(route))
                .findAny()
                .orElse(null);

        return view;

    }

}
