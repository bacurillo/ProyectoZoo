/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoom3a;

import controller.controllerLogin;
import controller.controllerPantallaprincipal;
import model.modelLogin;
import view.viewPantallaPrincipal;
import view.viewLogin;

/**
 *
 * @author ALEJO
 */
public class ZooM3A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//
//        viewPantallaPrincipal vista = new viewPantallaPrincipal();
//        controllerPantallaprincipal controller = new controllerPantallaprincipal(vista);
//        controller.iniciaControl();

        modelLogin modeloL = new modelLogin();
        viewLogin vistaL = new viewLogin();
        controllerLogin controllerL = new controllerLogin(modeloL, vistaL);
        controllerL.inicialControl();           

    }

}
