package FormTools;

import AppTools.Interfaces.IViewRouter;
import AppTools.Interfaces.IView;
import AppTools.Interfaces.IViewPresenter;
import javax.swing.JPanel;

public class FormRouter implements IViewRouter {

    WM messageWritter;
    IViewPresenter presenter;

    public FormRouter() {

        presenter = new ViewPresenter();
    }

    public void SetMainPage() {

    }

    @Override
    public JPanel RouteToPage(Views route) {

        switch (route) {
            case INICIO:
                IView inicio = presenter.ShowView(route);

                return inicio.GetView();

            case ADMIN_EMPLEADOS:
                IView admin = presenter.ShowView(route);

                return admin.GetView();

            case HACER_ORDEN:
                IView hacerOrden = presenter.ShowView(route);
                return hacerOrden.GetView();

            case ELEGIR_MESA:
                IView elegirMesaForm = presenter.ShowView(route);
                return elegirMesaForm.GetView();

            case ADMIN_MENU:
                IView adminMenu = presenter.ShowView(route);
                return adminMenu.GetView();

            case ADMIN_USERS:
                IView adminUser = presenter.ShowView(route);
                return adminUser.GetView();

            default:
                messageWritter.W("No existe una ruta con ese nombre");
                return null;
        }
    }
}
