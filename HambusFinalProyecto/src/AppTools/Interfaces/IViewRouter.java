/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppTools.Interfaces;

import FormTools.Views;
import javax.swing.JPanel;

/**
 *
 * @author Ariel
 */
public interface IViewRouter {
    JPanel RouteToPage(Views route);
}
