/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restApp;

import javax.swing.JPanel;

/**
 *
 * @author Ariel
 */
public interface IViewPresenter extends IViewManager
{
    IView ShowView(Views route);
    void HideView(JPanel panel);
}
