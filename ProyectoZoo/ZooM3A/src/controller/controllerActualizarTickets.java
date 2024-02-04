/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelTickets;
import model.Tickets;
import view.viewActualizarTicket;

/**
 *
 * @author ALEJO
 */
public class controllerActualizarTickets {

    private viewActualizarTicket vrt;
    private ModelTickets mt;
    int i = 0;

    DefaultTableModel estructuraTabla;

    public controllerActualizarTickets() {
    }

    public controllerActualizarTickets(viewActualizarTicket vrt, ModelTickets mt) {
        this.vrt = vrt;
        this.mt = mt;
        cargarComboCategoria();
        vrt.toFront();
        vrt.setVisible(true);
    }

    public void iniciarControl() {
        vrt.getBtncancelarticket().addActionListener(l -> vrt.dispose());
        vrt.getBtnactualizarticket().addActionListener(l -> ActualizarTicket());
        vrt.getCombocategoria().addActionListener(l -> cargarPrecios());
    }

    public void abrirActualizarTicket(int op) {
        String titulo;
//        cargarComboRol();
        if (op == 1) {
            limpiarCampos();
            vrt.setName("ACTUALIZACIÓN DE TICKET");

            vrt.setVisible(true);
            this.iniciarControl();
        }
    }

    public void cargarComboCategoria() {
//        vista.getComborol().removeAllItems();
        List<Tickets> listaTickets = mt.getTickets();
        listaTickets.stream().forEach(r -> {
            vrt.getCombocategoria().addItem(r.getTic_categoria());
        });
    }

    public void cargarPrecios() {
        int id = vrt.getCombocategoria().getSelectedIndex();
        ModelTickets tic = new ModelTickets();
        tic.setTic_id(id);

        List<Tickets> listaT = tic.getTicketsPrecio();
        listaT.stream().forEach(ticket -> {
//            if (id == ticket.getTic_id()) {
            vrt.getTxtprecio().setText(String.valueOf(ticket.getTic_precio()));
//            }
        });
        if (id == 0) {
            vrt.getTxtprecio().setText("");
            vrt.getTxtprecio().setEditable(false);
        }
    }

    public void ActualizarTicket() {
        validaciones mivalidacion = new validaciones();
        if (validar()) {

            String txtprecio = vrt.getTxtprecio().getText();

            ModelTickets tic = new ModelTickets();
            tic.setTic_precio(mivalidacion.validarDouble(txtprecio));

            int id = vrt.getCombocategoria().getSelectedIndex();
            tic.setTic_id(id);

            int response = JOptionPane.showConfirmDialog(vrt, "¿Seguro que desea actualizar el ticket?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                if (tic.updateTicket()) {
                    JOptionPane.showMessageDialog(vrt, "ACTUALIZADO CORRECTAMENTE");
                }
            } else {
                JOptionPane.showMessageDialog(vrt, "NO SE PUDO ACTUALIZAR CORRECTAMENTE");
            }
        }
    }

    public boolean validar() {
        boolean ban = true;
        validaciones mivalidacion = new validaciones();

        if (vrt.getCombocategoria().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vrt, "Seleccione una categoria");
            ban = false;
        } else {
            if (!vrt.getTxtprecio().getText().isEmpty()) {
                if (mivalidacion.validarDouble(vrt.getTxtprecio().getText()) == 0) {
                    JOptionPane.showMessageDialog(vrt, "Precio invalido");
                    ban = false;
                }
            } else {
                JOptionPane.showMessageDialog(vrt, "Ingrese el precio");
                ban = false;
            }
        }

        return ban;
    }

    public void limpiarCampos() {
        vrt.getCombocategoria().setSelectedItem(1);
        vrt.getTxtprecio().setText("");
    }
}
