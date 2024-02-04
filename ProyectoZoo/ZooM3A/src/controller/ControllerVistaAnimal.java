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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import view.viewVistaAnimal;
import model.ModelAnimal;
import javax.swing.table.DefaultTableModel;
import model.Animales;
import model.modelCuidador;
import model.ModelHabitad;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;
import view.viewRegistroAlimento;
import view.viewRegistroAnimal;

/**
 *
 * @author ALEJO
 */
public class ControllerVistaAnimal {

    private viewPantallaPrincipal vistaP;
    private viewVistaAnimal vistaAni;
    private controllerPantallaprincipal controllerpp;
    private ModelAnimal modeloAni;
    private modelCuidador modeloCui;
    private ModelHabitad modeloHab;

    int i = 0;

    DefaultTableModel estructuraTabla;
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-yyyy");

    public ControllerVistaAnimal() {
    }

    public ControllerVistaAnimal(viewVistaAnimal vistaAni, ModelAnimal modeloAni) {
        this.vistaAni = vistaAni;
        this.modeloAni = modeloAni;
    }

    public ControllerVistaAnimal(viewPantallaPrincipal vistaP, viewVistaAnimal vistaAni, ModelAnimal modeloAni) {
        this.vistaP = vistaP;
        this.vistaAni = vistaAni;
        this.modeloAni = modeloAni;

        cargarDatos(1);
        vistaAni.setVisible(true);
    }

    public void inicialControl() {
        vistaAni.getJbtnAgregarAnimal().addActionListener(l -> abrirRegistro(1));
        vistaAni.getjBtnModificarAnimal().addActionListener(l -> abrirRegistro(2));
        vistaAni.getjBtnEliminarAnimal().addActionListener(l -> eliminarAlimento());
        vistaAni.getTxtbuscarAnimal().addKeyListener(busquedaIncren);
    }

    public void abrirRegistro(int op) {
        ModelAnimal modeloAni = new ModelAnimal();
        viewRegistroAnimal vistaRegistroAni = new viewRegistroAnimal();
        modelCuidador modeloCui = new modelCuidador();
        ModelHabitad modeloHab = new ModelHabitad();
        if (op == 1) {

            //Agragar vista al desktop pane
            vistaP.getjDPprincipal().add(vistaRegistroAni);
            ControllerRegistrarAnimal controladorAni = new ControllerRegistrarAnimal(modeloAni, modeloHab, modeloCui, vistaRegistroAni, vistaAni);
            controladorAni.abrirRegistro(1);

        } else {
            ControllerRegistrarAnimal controladorAni = new ControllerRegistrarAnimal(modeloAni, modeloHab, modeloCui, vistaRegistroAni, vistaAni);
            int fila = vistaAni.getjTblAnimal().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione el animal a modificar");
            } else {
                vistaP.getjDPprincipal().add(vistaRegistroAni);
                controladorAni.abrirRegistro(2);
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
        vistaAni.getjTblAnimal().setDefaultRenderer(Object.class, new imageTable());
        vistaAni.getjTblAnimal().setRowHeight(50);
        estructuraTabla = (DefaultTableModel) vistaAni.getjTblAnimal().getModel();
        estructuraTabla.setRowCount(0);

        List<Animales> listaAli;
        if (opc == 1) {
            listaAli = modeloAni.getAnimal();
        } else {
            String busqueda = vistaAni.getTxtbuscarAnimal().getText().toLowerCase().trim();
            listaAli = modeloAni.busquedaIncremental(busqueda);
        }

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaAli.stream().sorted((x, y)
                -> x.getEspecieAnimal().compareToIgnoreCase(y.getEspecieAnimal())).forEach(emp -> {
            estructuraTabla.addRow(new Object[8]);
            vistaAni.getjTblAnimal().setValueAt(emp.getIdAnimal(), i, 0);
            vistaAni.getjTblAnimal().setValueAt(emp.getNombreAnimal(), i, 1);
            vistaAni.getjTblAnimal().setValueAt(emp.getGeneroAnimal(), i, 2);
            vistaAni.getjTblAnimal().setValueAt(emp.getEspecieAnimal(), i, 3);
            vistaAni.getjTblAnimal().setValueAt(formatofecha.format(emp.getFecha_nacimientoAnimal()), i, 4);
            vistaAni.getjTblAnimal().setValueAt(emp.getTipoHabitat(), i, 5);
            vistaAni.getjTblAnimal().setValueAt(emp.getNombreCuidador(), i, 6);
            Image foto = emp.getFoto();
            if (foto != null) {
                foto = foto.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(foto);

                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setIcon(icono);
                vistaAni.getjTblAnimal().setValueAt(new JLabel(icono), i, 7);
            } else {
                vistaAni.getjTblAnimal().setValueAt(null, i, 7);
            }
            i++;
        });

    }

    public void eliminarAlimento() {
        ModelAnimal animal = new ModelAnimal();
        int fila = vistaAni.getjTblAnimal().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el alimento a eliminar");
        } else {
            int response = JOptionPane.showConfirmDialog(vistaAni, "¿Esta seguro de eliminar el alimento?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(vistaAni.getjTblAnimal().getValueAt(fila, 0).toString());

                if (animal.deleteAnimal(id)) {//Grabamos
                    JOptionPane.showMessageDialog(vistaAni, "Alimento eliminado correctamente");
                    cargarDatos(1);
                } else {
                    JOptionPane.showMessageDialog(vistaAni, "No se pudo eliminar el alimento");
                }
            }
        }
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
           // jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReporteAnimales.jasper"));
           jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReporteAnimales.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE ANIMALES");
            parametros.put("busqueda", vistaAni.getTxtbuscarAnimal().getText().toLowerCase());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vistaAni.getjTblAnimal().getRowCount() != 0) {
                jv.setVisible(true);

            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
