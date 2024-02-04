/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import model.ModelTickets;
import model.Tickets;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewActualizarTicket;
import view.viewVistaTickets;

/**
 *
 * @author ALEJO
 */
public class ControllerVistaTickets {

    private viewVistaTickets vvt;
    private ModelTickets mt;
    DefaultTableModel estructuraTabla;
    int i = 0;
    private viewActualizarTicket vat;

    public ControllerVistaTickets() {
    }

    public ControllerVistaTickets(viewVistaTickets vvt, ModelTickets mt) {
        this.vvt = vvt;
        this.mt = mt;
        cargarDatos();
        vvt.setVisible(true);
    }

    public ControllerVistaTickets(viewVistaTickets vvt, ModelTickets mt, DefaultTableModel estructuraTabla) {
        this.vvt = vvt;
        this.mt = mt;
        this.estructuraTabla = estructuraTabla;
    }

    public void iniciarControl() {
        vvt.getjBtnImprimir().addActionListener(l -> imprimeReporte());
    }

    public void cargarDatos() {
//        vistaCli.getjTblCliente().setDefaultRenderer(Object.class, new imageTable());
        vvt.getjTblTickets().setRowHeight(136);
//        vvt.getjTblTickets().setC
        estructuraTabla = (DefaultTableModel) vvt.getjTblTickets().getModel();
        estructuraTabla.setRowCount(0);

        List<Tickets> listaTickets;
        listaTickets = mt.getTickets();

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaTickets.stream().forEach(tic -> {
            estructuraTabla.addRow(new Object[3]);
            vvt.getjTblTickets().setValueAt(tic.getTic_id(), i, 0);
            vvt.getjTblTickets().setValueAt(tic.getTic_categoria(), i, 1);
            vvt.getjTblTickets().setValueAt(tic.getTic_precio(), i, 2);
            i++;
        });
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReporteTickets.jasper"));
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReporteTickets.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE PRECIOS");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vvt.getjTblTickets().getRowCount() != 0) {
                jv.setVisible(true);

            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
}
