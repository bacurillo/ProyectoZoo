/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import model.modelEmpleado;
import view.viewConsultarFacturas;
import view.viewConsultarFacturas;
import controller.controllerVentaTicket;
import java.util.HashMap;
import java.util.Map;
import model.modelPersona;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import model.ModelCliente;
import model.ModelFactura;
import model.factura;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;
import view.viewVentaTicket;

/**
 *
 * @author ALEJO
 */
public class ControllerConsultaFacturas {

    private controllerPantallaprincipal controllerpp;
    private viewConsultarFacturas vistaConsultaF;
    private viewPantallaPrincipal vistaP;
    private viewVentaTicket vistaVenta;
    private ModelFactura modelFactura;
    private ModelCliente modelCliente;

    int i = 0;
    DefaultTableModel estructuraTabla;
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-yyyy");

    public ControllerConsultaFacturas(viewConsultarFacturas vistaConsultaF, viewPantallaPrincipal vistaP, ModelFactura modelFactura) {
        this.vistaConsultaF = vistaConsultaF;
        this.vistaP = vistaP;
        this.modelFactura = modelFactura;
        vistaConsultaF.toFront();
        cargarDatos(1);
        vistaConsultaF.setVisible(true);
    }

    public ControllerConsultaFacturas(viewConsultarFacturas vistaConsultaF) {
        this.vistaConsultaF = vistaConsultaF;
        this.modelFactura = modelFactura;
    }

    public void inicialControl() {
        vistaConsultaF.getTxtBuscar().addKeyListener(busquedaIncren);
        vistaConsultaF.getjBtnImprimirReporte().addActionListener(l -> imprimeReporte());
        vistaConsultaF.getjBtnImprimir().addActionListener(l -> verFactura());
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
//        vistaConsultaF.getjTblFactura().setDefaultRenderer(Object.class, new imageTable());
        vistaConsultaF.getjTblFactura().setRowHeight(30);
        estructuraTabla = (DefaultTableModel) vistaConsultaF.getjTblFactura().getModel();
        estructuraTabla.setRowCount(0);
        List<factura> listaFac;
        if (opc == 1) {
            listaFac = modelFactura.getFacturas();
        } else {
            String busqueda = vistaConsultaF.getTxtBuscar().getText().toLowerCase().trim();
            listaFac = modelFactura.getFacturasBuscar(busqueda);
        }

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaFac.stream().sorted((x, y)
                -> x.getEnca_fecha().compareTo(y.getEnca_fecha())).forEach(emp -> {
            estructuraTabla.addRow(new Object[13]);
            //ENCABEZADO
            vistaConsultaF.getjTblFactura().setValueAt(emp.getEnca_id(), i, 0);
            vistaConsultaF.getjTblFactura().setValueAt(formatofecha.format(emp.getEnca_fecha()), i, 1);
            //CLIENTE
            vistaConsultaF.getjTblFactura().setValueAt(emp.getCli_cedula(), i, 2);
            vistaConsultaF.getjTblFactura().setValueAt(emp.getNombre(), i, 3);
            vistaConsultaF.getjTblFactura().setValueAt(emp.getTelefono(), i, 4);
            vistaConsultaF.getjTblFactura().setValueAt(emp.getCorreo(), i, 5);
            vistaConsultaF.getjTblFactura().setValueAt(emp.getCli_direccion(), i, 6);
            //DETALLE
            vistaConsultaF.getjTblFactura().setValueAt(emp.getItems(), i, 7);
            vistaConsultaF.getjTblFactura().setValueAt(emp.getCantTotal(), i, 8);
            //PIE
            vistaConsultaF.getjTblFactura().setValueAt(("$ " + emp.getPie_subTotal()), i, 9);
            vistaConsultaF.getjTblFactura().setValueAt((emp.getPie_descuento() + " %"), i, 10);
            vistaConsultaF.getjTblFactura().setValueAt(("$ " + emp.getPie_TOTAL()), i, 11);
            i++;
        });

    }

    public boolean verFactura() {
        int fila = vistaConsultaF.getjTblFactura().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaConsultaF, "Seleccione la factura que desea visualizar");
            return false;
        } else {
            int id = Integer.parseInt(vistaConsultaF.getjTblFactura().getValueAt(fila, 0).toString());
            controllerVentaTicket contultaFac = new controllerVentaTicket();
            contultaFac.imprimeFactura(id);
            return true;
        }
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReporteFacturas.jasper"));
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReporteFacturas.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE VENTAS");
            parametros.put("busqueda", vistaConsultaF.getTxtBuscar().getText().toLowerCase());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vistaConsultaF.getjTblFactura().getRowCount() != 0) {
                jv.setVisible(true);

            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
