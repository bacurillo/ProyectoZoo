/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.ModelHabitad;
import javax.swing.table.DefaultTableModel;
import model.Habitat;
import model.modelPGconexion;
import model.modelZoologo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;
import view.viewRegistroHabitad;
import view.viewVistaHabitats;

/**
 *
 * @author ALEJO
 */
public class ControllerVistaHabitat {

    private viewPantallaPrincipal vistaP;
    private viewVistaHabitats vistaHab;
    private controllerPantallaprincipal controllerpp;
    private ModelHabitad modeloHab;
    private modelZoologo modeloZol;
    int i = 0;

    DefaultTableModel estructuraTabla;
//    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    public ControllerVistaHabitat() {
    }

    public ControllerVistaHabitat(viewVistaHabitats vistaHab, ModelHabitad modeloHab) {
        this.vistaHab = vistaHab;
        this.modeloHab = modeloHab;
    }

    public ControllerVistaHabitat(viewPantallaPrincipal vistaP, viewVistaHabitats vistaHab, ModelHabitad modeloHab) {
        this.vistaP = vistaP;
        this.vistaHab = vistaHab;
        this.modeloHab = modeloHab;
        cargarDatos(1);
        vistaHab.toFront();
        vistaHab.setVisible(true);
    }

    public void inicialControl() {
        vistaHab.getBtnAgregar().addActionListener(l -> abrirRegistro(1));
        vistaHab.getBtnModificar().addActionListener(l -> abrirRegistro(2));
        vistaHab.getBtnEliminar().addActionListener(l -> eliminarAlimento());
        vistaHab.getjBtnImprimir().addActionListener(l -> imprimeReporte());
        vistaHab.getTxtbuscar().addKeyListener(busquedaIncren);
    }

    public void abrirRegistro(int op) {
        ModelHabitad modeloHab = new ModelHabitad();
        viewRegistroHabitad vistaRegistroHab = new viewRegistroHabitad();
        modelZoologo modelzol = new modelZoologo();
        if (op == 1) {

            //Agragar vista al desktop pane
            vistaP.getjDPprincipal().add(vistaRegistroHab);
            ControllerRegistrarHabitad controladorHab = new ControllerRegistrarHabitad(vistaRegistroHab, vistaHab, modeloHab, modelzol);
//            ControllerRegistrarAlimento controladorAli = new ControllerRegistrarAlimento(vistaRegistroHab, modeloHab, modeloProv, vistaHab);
            controladorHab.abrirRegistro(1);

        } else {
            ControllerRegistrarHabitad controladorHab = new ControllerRegistrarHabitad(vistaRegistroHab, vistaHab, modeloHab, modelzol);
            int fila = vistaHab.getjTblHabitat().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione el alimento a modificar");
            } else {
                vistaP.getjDPprincipal().add(vistaRegistroHab);
                controladorHab.abrirRegistro(2);
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
        System.out.println("actualizado");
        vistaHab.getjTblHabitat().setRowHeight(50);
        estructuraTabla = (DefaultTableModel) vistaHab.getjTblHabitat().getModel();
        estructuraTabla.setRowCount(0);

        List<Habitat> listaHab;
        if (opc == 1) {
            listaHab = modeloHab.getHabitad();
        } else {
            String busqueda = vistaHab.getTxtbuscar().getText().toLowerCase().trim();
            listaHab = modeloHab.busquedaincremental(busqueda);
        }

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaHab.stream().sorted((x, y)
                -> x.getTipohab().compareToIgnoreCase(y.getTipohab())).forEach(emp -> {
            estructuraTabla.addRow(new Object[7]);
            vistaHab.getjTblHabitat().setValueAt(emp.getId_habitat(), i, 0);
            vistaHab.getjTblHabitat().setValueAt(emp.getTipohab(), i, 1);
            vistaHab.getjTblHabitat().setValueAt(emp.getUbicacionhab(), i, 2);
            vistaHab.getjTblHabitat().setValueAt(emp.getCapacidadhap(), i, 3);
            vistaHab.getjTblHabitat().setValueAt(emp.getNombre(), i, 4);
            vistaHab.getjTblHabitat().setValueAt(emp.getRama(), i, 5);
            i++;
        });

    }

    public void eliminarAlimento() {
        ModelHabitad habitat = new ModelHabitad();
        int fila = vistaHab.getjTblHabitat().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el alimento a eliminar");
        } else {
            int response = JOptionPane.showConfirmDialog(vistaHab, "¿Esta seguro de eliminar el alimento?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(vistaHab.getjTblHabitat().getValueAt(fila, 0).toString());

                if (habitat.deleteHabitad(id)) {//Grabamos
                    JOptionPane.showMessageDialog(vistaHab, "Alimento eliminado correctamente");
                    cargarDatos(1);
                } else {
                    JOptionPane.showMessageDialog(vistaHab, "No se pudo eliminar el alimento");
                }
            }
        }
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReporteHabitat.jasper"));
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReporteHabitat.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE HABITAT");
            parametros.put("busqueda", vistaHab.getTxtbuscar().getText().toLowerCase());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vistaHab.getjTblHabitat().getRowCount() != 0) {
                jv.setVisible(true);
            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
