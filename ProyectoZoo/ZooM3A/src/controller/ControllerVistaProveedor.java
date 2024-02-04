/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import view.viewVistaProveedor;
import model.modelProveedor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Proveedor;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;
import view.viewRegistrarProveedor;

/**
 *
 * @author ALEJO
 */
public class ControllerVistaProveedor {

    private viewPantallaPrincipal vistaPP;
    private viewVistaProveedor vistaProv;
    private controllerPantallaprincipal controllerpp;
    private modelProveedor modeloProv;

    int i = 0;

    DefaultTableModel estructuraTabla;
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    public ControllerVistaProveedor() {
    }

    public ControllerVistaProveedor(modelProveedor modeloProv, viewVistaProveedor vistaProv) {
        this.modeloProv = modeloProv;
        this.vistaProv = vistaProv;
    }

    public ControllerVistaProveedor(viewPantallaPrincipal vistaP, viewVistaProveedor vistaProv, modelProveedor modeloProv) {
        this.vistaPP = vistaP;
        this.vistaProv = vistaProv;
        this.modeloProv = modeloProv;
        cargarDatos(1);
        vistaProv.setVisible(true);
    }

    public void inicialControl() {
        vistaProv.getJbtnAgregar().addActionListener(l -> abrirRegistro(1));
        vistaProv.getjBtnModificar().addActionListener(l -> abrirRegistro(2));
        vistaProv.getjBtnElimina().addActionListener(l -> eliminarEmpleado());
        vistaProv.getjBtnImprimir().addActionListener(l -> imprimeReporte());
        vistaProv.getTxtBuscar().addKeyListener(busquedaIncren);
    }

    public void abrirRegistro(int op) {
        modelProveedor modeloProveedor = new modelProveedor();
        viewRegistrarProveedor vistaRegistroProv = new viewRegistrarProveedor();

        if (op == 1) {

            //Agragar vista al desktop pane
            vistaPP.getjDPprincipal().add(vistaRegistroProv);

            ControllerRegistroProveedor controladorProv = new ControllerRegistroProveedor(modeloProv, vistaRegistroProv, vistaProv);
            controladorProv.abrirRegistro(1);

        } else {
            ControllerRegistroProveedor controladorProv = new ControllerRegistroProveedor(modeloProveedor, vistaRegistroProv, vistaProv);
            int fila = vistaProv.getjTblProveedor().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione la persona a modificar");
            } else {
                vistaPP.getjDPprincipal().add(vistaRegistroProv);
                controladorProv.abrirRegistro(2);
            }
        }
        cargarDatos(1);
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
//        vistaProv.getjTblProveedor().setDefaultRenderer(Object.class, new imageTable());
        vistaProv.getjTblProveedor().setRowHeight(50);
        estructuraTabla = (DefaultTableModel) vistaProv.getjTblProveedor().getModel();
        estructuraTabla.setRowCount(0);

        List<Proveedor> listaProv;
        if (opc == 1) {
            listaProv = modeloProv.getProveedor();
        } else {
            String busqueda = vistaProv.getTxtBuscar().getText().toLowerCase().trim();
            listaProv = modeloProv.busquedaIncrementalProveedor(busqueda);
        }

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaProv.stream().sorted((x, y)
                -> x.getCiudad_pro().compareToIgnoreCase(y.getCiudad_pro())).forEach(emp -> {
            estructuraTabla.addRow(new Object[4]);
            vistaProv.getjTblProveedor().setValueAt(emp.getId_proveedor(), i, 0);
            vistaProv.getjTblProveedor().setValueAt(emp.getNombre_pro(), i, 1);
            vistaProv.getjTblProveedor().setValueAt(emp.getCiudad_pro(), i, 2);
            vistaProv.getjTblProveedor().setValueAt(emp.getTelefono(), i, 3);
            i++;
        });

    }

    public void eliminarEmpleado() {
        modelProveedor proveedor = new modelProveedor();
        int fila = vistaProv.getjTblProveedor().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el proveedor a eliminar");
        } else {
            int response = JOptionPane.showConfirmDialog(vistaProv, "¿Esta seguro de eliminar al proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(vistaProv.getjTblProveedor().getValueAt(fila, 0).toString());

                if (proveedor.deleteProveedor(id)) {//Grabamos
                    JOptionPane.showMessageDialog(vistaProv, "Proveedor eliminado correctamente");
                    cargarDatos(1);
                } else {
                    JOptionPane.showMessageDialog(vistaProv, "No se pudo eliminar al Proveedor");
                }
            }
        }
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReporteProveedor.jasper"));
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReporteProveedor.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE PROVEEDORES");
            parametros.put("busqueda", vistaProv.getTxtBuscar().getText().toLowerCase());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vistaProv.getjTblProveedor().getRowCount() != 0) {
                jv.setVisible(true);

            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
