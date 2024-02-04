/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import model.modelEmpleado;
import model.modelLogin;
import view.viewPantallaPrincipal;
import view.viewLogin;

/**
 *
 * @author Bryan
 */
public class controllerLogin {

    viewPantallaPrincipal pp = new viewPantallaPrincipal();
    private modelEmpleado modeloE;
    private modelLogin modeloL;
    private viewLogin vista;
    private viewPantallaPrincipal vistaP;
    validaciones mivalidacion = new validaciones();

    public controllerLogin(modelLogin modeloL, viewLogin vista) {
        this.modeloL = modeloL;
        this.vista = vista;
        vista.setVisible(true);
        vista.setTitle("ZOOMANIA");
        vista.setIconImage(new ImageIcon(getClass().getResource("/imagenes/leon_JF.png")).getImage());
    }

    public void inicialControl() {
        vista.getBtiniciarsesion().addActionListener(l -> abrirPrincipal());
        vista.getJbtnClose().addActionListener(l -> System.exit(0));
        vista.getTxtusuarioingreso().addKeyListener(inicioSesion);
        vista.getTxtcontraingreso().addKeyListener(inicioSesion);
        vista.getTxtusuarioingreso().addMouseListener(user);
        vista.getTxtcontraingreso().addMouseListener(pass);
        vista.getTxtusuarioingreso().addFocusListener(focousu);
        vista.getTxtcontraingreso().addFocusListener(focopass);
    }

    public void abrirPrincipal() {
//        viewPantallaPrincipal vistaP = new viewPantallaPrincipal();
        if (mivalidacion.validarLogin(vista.getTxtusuarioingreso().getText(), vista.getTxtcontraingreso().getText())) {
            viewPantallaPrincipal vistap = new viewPantallaPrincipal();
            controllerPantallaprincipal controller = new controllerPantallaprincipal(vistap, vista.getTxtusuarioingreso().getText(), vista.getTxtcontraingreso().getText());
            controller.iniciaControl();
            vista.dispose();
        }
    }

    MouseListener user = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (vista.getTxtusuarioingreso().getText().equalsIgnoreCase("Ingrese su nombre de usuario")) {
                vista.getTxtusuarioingreso().setText("");
                vista.getTxtusuarioingreso().setForeground(Color.BLACK);
            }
            if (vista.getTxtcontraingreso().getText().isEmpty()) {
                vista.getTxtcontraingreso().setText("***************");
                vista.getTxtcontraingreso().setForeground(Color.gray);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    MouseListener pass = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (vista.getTxtcontraingreso().getText().equalsIgnoreCase("***************")) {
                vista.getTxtcontraingreso().setText("");
                vista.getTxtcontraingreso().setForeground(Color.BLACK);
            }
            if (vista.getTxtusuarioingreso().getText().isEmpty()) {
                vista.getTxtusuarioingreso().setText("Ingrese su nombre de usuario");
                vista.getTxtusuarioingreso().setForeground(Color.gray);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
    FocusListener focousu = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (vista.getTxtusuarioingreso().getText().equalsIgnoreCase("Ingrese su nombre de usuario")) {
                vista.getTxtusuarioingreso().setText("");
                vista.getTxtusuarioingreso().setForeground(Color.BLACK);
            }
            if (vista.getTxtcontraingreso().getText().isEmpty()) {
                vista.getTxtcontraingreso().setText("***************");
                vista.getTxtcontraingreso().setForeground(Color.gray);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (vista.getTxtusuarioingreso().getText().equalsIgnoreCase("Ingrese su nombre de usuario")) {
                vista.getTxtusuarioingreso().setText("");
                vista.getTxtusuarioingreso().setForeground(Color.BLACK);
            }
            if (vista.getTxtcontraingreso().getText().isEmpty()) {
                vista.getTxtcontraingreso().setText("***************");
                vista.getTxtcontraingreso().setForeground(Color.gray);
            }
        }
    };

    FocusListener focopass = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (vista.getTxtcontraingreso().getText().equalsIgnoreCase("***************")) {
                vista.getTxtcontraingreso().setText("");
                vista.getTxtcontraingreso().setForeground(Color.BLACK);
            }
            if (vista.getTxtusuarioingreso().getText().isEmpty()) {
                vista.getTxtusuarioingreso().setText("Ingrese su nombre de usuario");
                vista.getTxtusuarioingreso().setForeground(Color.gray);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (vista.getTxtcontraingreso().getText().equalsIgnoreCase("***************")) {
                vista.getTxtcontraingreso().setText("");
                vista.getTxtcontraingreso().setForeground(Color.BLACK);
            }
            if (vista.getTxtusuarioingreso().getText().isEmpty()) {
                vista.getTxtusuarioingreso().setText("Ingrese su nombre de usuario");
                vista.getTxtusuarioingreso().setForeground(Color.gray);
            }
        }
    };

    KeyListener inicioSesion = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                abrirPrincipal();
            }
        }
    };

}
