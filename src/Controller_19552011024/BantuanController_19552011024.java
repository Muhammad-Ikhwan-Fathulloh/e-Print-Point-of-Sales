/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_19552011024;

import View_19552011024.BantuanView_19552011024;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author User
 */
public class BantuanController_19552011024 {
    private static String className = "BantuanController";
    public void maximazieWindowsHome(BantuanView_19552011024 bantuanView) {
        try {
            bantuanView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception e) {
            
        }
    }
}
