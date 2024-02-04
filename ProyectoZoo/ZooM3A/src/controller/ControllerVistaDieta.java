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
import model.ModelAlimento;
import javax.swing.table.DefaultTableModel;
import model.Dieta;
import model.ModelAnimal;
import model.ModelDieta;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;
import view.viewRegistroDieta;
import view.viewVistaDieta;

/**
 *
 * @author ALEJO
 */
public class ControllerVistaDieta {

    private viewPantallaPrincipal vistaP;
    private viewVistaDieta vistaDie;
    private controllerPantallaprincipal controllerpp;
    private ModelAlimento modeloAli;
    private ModelAnimal modeloAni;
    private ModelDieta modeloDie;
    int i = 0;

    DefaultTableModel estructuraTabla;
//    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    public ControllerVistaDieta() {
    }

    public ControllerVistaDieta(viewVistaDieta vistaDie, ModelDieta modeloDie) {
        this.vistaDie = vistaDie;
        this.modeloDie = modeloDie;
    }

    public ControllerVistaDieta(viewPantallaPrincipal vistaP, viewVistaDieta vistaDie, ModelDieta modeloDie) {
        this.vistaP = vistaP;
        this.vistaDie = vistaDie;
        this.modeloDie = modeloDie;
        cargarDatos(1);
        vistaDie.toFront();
        vistaDie.setVisible(true);
    }

    public void inicialControl() {
        vistaDie.getBtnAgregar().addActionListener(l -> abrirRegistro(1));
        vistaDie.getBtnModificar().addActionListener(l -> abrirRegistro(2));
        vistaDie.getBtnEliminar().addActionListener(l -> eliminarAlimento());
        vistaDie.getjBtnImprimir().addActionListener(l -> imprimeReporte());
        vistaDie.getTxtbuscar().addKeyListener(busquedaIncren);
    }

    public void abrirRegistro(int op) {
        ModelDieta modeloDie = new ModelDieta();
        viewRegistroDieta vistaRegistroDie = new viewRegistroDieta();
        ModelAlimento modelAli = new ModelAlimento();
        ModelAnimal modelAni = new ModelAnimal();

        if (op == 1) {

            //Agragar vista al desktop pane
            vistaP.getjDPprincipal().add(vistaRegistroDie);
            ControllerRegistrarDieta controladorDie = new ControllerRegistrarDieta(vistaRegistroDie, vistaDie, modeloDie, modelAli, modelAni);
//            ControllerRegistrarAlimento controladorAli = new ControllerRegistrarAlimento(vistaRegistroHab, modeloHab, modeloProv, vistaHab);
            controladorDie.abrirRegistro(1);

        } else {
            ControllerRegistrarDieta controladorDie = new ControllerRegistrarDieta(vistaRegistroDie, vistaDie, modeloDie, modelAli, modelAni);
            int fila = vistaDie.getjTblDieta().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione la dieta a modificar");
            } else {
                vistaP.getjDPprincipal().add(vistaRegistroDie);
                controladorDie.abrirRegistro(2);
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
        vistaDie.getjTblDieta().setRowHeight(50);
        estructuraTabla = (DefaultTableModel) vistaDie.getjTblDieta().getModel();
        estructuraTabla.setRowCount(0);

        List<Dieta> listaHab;
        if (opc == 1) {
            listaHab = modeloDie.getDieta();
        } else {
            String busqueda = vistaDie.getTxtbuscar().getText().toLowerCase().trim();
            listaHab = modeloDie.busquedaIncrementalDieta(busqueda);
        }

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaHab.stream().sorted((x, y)
                -> x.getEspecieAnimal().compareToIgnoreCase(y.getEspecieAnimal())).forEach(emp -> {
            estructuraTabla.addRow(new Object[7]);
            vistaDie.getjTblDieta().setValueAt(emp.getDie_id(), i, 0);
            vistaDie.getjTblDieta().setValueAt(emp.getDie_horario(), i, 1);
            vistaDie.getjTblDieta().setValueAt(emp.getDie_porcion(), i, 2);
            vistaDie.getjTblDieta().setValueAt(emp.getNombreAli(), i, 3);
            vistaDie.getjTblDieta().setValueAt(emp.getDescripcionAli(), i, 4);
            vistaDie.getjTblDieta().setValueAt(emp.getNombreAnimal(), i, 5);
            vistaDie.getjTblDieta().setValueAt(emp.getEspecieAnimal(), i, 6);
            i++;
        });

    }

    public void eliminarAlimento() {
        ModelDieta dieta = new ModelDieta();
        int fila = vistaDie.getjTblDieta().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione la dieta a eliminar");
        } else {
            int response = JOptionPane.showConfirmDialog(vistaDie, "¿Esta seguro de eliminar la dieta?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(vistaDie.getjTblDieta().getValueAt(fila, 0).toString());

                if (dieta.deleteDieta(id)) {//Grabamos
                    JOptionPane.showMessageDialog(vistaDie, "Alimento eliminado correctamente");
                    cargarDatos(1);
                } else {
                    JOptionPane.showMessageDialog(vistaDie, "No se pudo eliminar el alimento");
                }
            }
        }
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReporteDieta.jasper"));
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReporteDieta.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE DIETA");
            parametros.put("busqueda", vistaDie.getTxtbuscar().getText().toLowerCase());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vistaDie.getjTblDieta().getRowCount() != 0) {
                jv.setVisible(true);

            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
