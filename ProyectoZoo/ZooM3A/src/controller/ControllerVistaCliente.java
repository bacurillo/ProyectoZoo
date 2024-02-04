/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.log.Logger;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import view.viewVistaCliente;
import model.ModelCliente;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;
import view.viewRegistrarCliente;

/**
 *
 * @author ALEJO
 */
public class ControllerVistaCliente {

    private viewPantallaPrincipal vistaP;
    private viewVistaCliente vistaCli;
    private controllerPantallaprincipal controllerpp;
    private ModelCliente modeloCli;

    int i = 0;

    DefaultTableModel estructuraTabla;
//    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-yyyy");

    public ControllerVistaCliente() {
    }

    public ControllerVistaCliente(viewVistaCliente vistaCli, ModelCliente modeloCli) {
        this.vistaCli = vistaCli;
        this.modeloCli = modeloCli;
    }

    public ControllerVistaCliente(viewPantallaPrincipal vistaP, viewVistaCliente vistaCli, ModelCliente modeloCli) {
        this.vistaP = vistaP;
        this.vistaCli = vistaCli;
        this.modeloCli = modeloCli;
        cargarDatos(1);
        vistaCli.setVisible(true);
    }

    public void inicialControl() {
        vistaCli.getBtnAgregarCliente().addActionListener(l -> abrirRegistro(1));
        vistaCli.getBtnModificarCliente().addActionListener(l -> abrirRegistro(2));
        vistaCli.getBtnEliminarCliente().addActionListener(l -> eliminarCliente());
        vistaCli.getTxtbuscar().addKeyListener(busquedaIncren);

        vistaCli.getjBtnImprimirCliente().addActionListener(l -> imprimeReporte());
    }

    public void abrirRegistro(int op) {
        ModelCliente modeloCli = new ModelCliente();
        viewRegistrarCliente vistaRegistroCli = new viewRegistrarCliente();

        if (op == 1) {

            //Agragar vista al desktop pane
            vistaP.getjDPprincipal().add(vistaRegistroCli);

            ControllerRegistrarCliente controladorCli = new ControllerRegistrarCliente(vistaRegistroCli, vistaCli, modeloCli);
            controladorCli.abrirRegistro(1);

        } else {
            ControllerRegistrarCliente controladorCli = new ControllerRegistrarCliente(vistaRegistroCli, vistaCli, modeloCli);
            int fila = vistaCli.getjTblCliente().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione la persona a modificar");
            } else {
                vistaP.getjDPprincipal().add(vistaRegistroCli);
                controladorCli.abrirRegistro(2);
            }
            cargarDatos(1);
        }
    }

    KeyListener busquedaIncren = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            cargarDatos(2);
        }
    };

    public void cargarDatos(int opc) {
//        vistaCli.getjTblCliente().setDefaultRenderer(Object.class, new imageTable());
        vistaCli.getjTblCliente().setRowHeight(50);
        estructuraTabla = (DefaultTableModel) vistaCli.getjTblCliente().getModel();
        estructuraTabla.setRowCount(0);

        List<Cliente> listaCli;
        if (opc == 1) {
            listaCli = modeloCli.getClientes();
        } else {
            String busqueda = vistaCli.getTxtbuscar().getText().toLowerCase().trim();
            listaCli = modeloCli.busquedaincremental(busqueda);
        }

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaCli.stream().sorted((x, y)
                -> x.getNombre().compareToIgnoreCase(y.getNombre())).forEach(emp -> {
            estructuraTabla.addRow(new Object[4]);
            vistaCli.getjTblCliente().setValueAt(emp.getCli_id(), i, 0);
            vistaCli.getjTblCliente().setValueAt(emp.getCedula(), i, 1);
            vistaCli.getjTblCliente().setValueAt(emp.getNombre(), i, 2);
            vistaCli.getjTblCliente().setValueAt(emp.getApellido(), i, 3);
            vistaCli.getjTblCliente().setValueAt(emp.getCorreo(), i, 4);
            vistaCli.getjTblCliente().setValueAt(emp.getCli_direccion(), i, 5);
            vistaCli.getjTblCliente().setValueAt(emp.getTelefono(), i, 6);
            vistaCli.getjTblCliente().setValueAt(formatofecha.format(emp.getFechaRegistro()), i, 7);
            i++;
        });

    }

    public void eliminarCliente() {
        ModelCliente cliente = new ModelCliente();
        int fila = vistaCli.getjTblCliente().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el cliente a eliminar");
        } else {
            int response = JOptionPane.showConfirmDialog(vistaCli, "¿Esta seguro de eliminar al cliente?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String cedula = vistaCli.getjTblCliente().getValueAt(fila, 1).toString();

                if (cliente.deleteCliente(cedula)) {//Grabamos
                    JOptionPane.showMessageDialog(vistaCli, "Proveedor eliminado correctamente");
                    cargarDatos(1);
                } else {
                    JOptionPane.showMessageDialog(vistaCli, "No se pudo eliminar al Proveedor");
                }
            }
        }
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReporteClientes.jasper"));
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReporteClientes.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE CLIENTES");
            parametros.put("busqueda", vistaCli.getTxtbuscar().getText().toLowerCase());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vistaCli.getjTblCliente().getRowCount() != 0) {
                jv.setVisible(true);

            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
