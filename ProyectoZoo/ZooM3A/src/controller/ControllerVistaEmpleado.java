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
import model.modelEmpleado;
import view.viewVistaEmpleados;
import view.viewRegistrarEmpleado;
import model.modelPersona;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;

/**
 *
 * @author ALEJO
 */
public class ControllerVistaEmpleado {

    private viewPantallaPrincipal vistaP;
    private controllerPantallaprincipal controllerpp;
    private modelEmpleado modeloE;
    private modelPersona modeloP;
    private viewRegistrarEmpleado vistaRE;
    private viewVistaEmpleados vistaE;
    int i = 0;
    DefaultTableModel estructuraTabla;
//    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-yyyy");

    public ControllerVistaEmpleado(modelEmpleado modeloE, viewVistaEmpleados vistaE, viewPantallaPrincipal vistaP) {
        this.modeloE = modeloE;
        this.vistaE = vistaE;
        this.vistaP = vistaP;
//        desactivarDatosRol();        
        cargarDatos(1);
        vistaE.toFront();
        vistaE.setVisible(true);
    }

    public ControllerVistaEmpleado(modelEmpleado modeloE, viewVistaEmpleados vistaE) {
        this.modeloE = modeloE;
        this.vistaE = vistaE;
    }

    public void inicialControl() {
        vistaE.getjBtnElimina().addActionListener(l -> eliminarEmpleado());
//        vistaE.getjBtnActualizar().addActionListener(l -> cargarDatos(1));
        vistaE.getJbtnAgregar().addActionListener(l -> abrirRegistro(1));
        vistaE.getjBtnModificar().addActionListener(l -> abrirRegistro(2));
        vistaE.getTxtBuscar().addKeyListener(busquedaIncren);
        vistaE.getjBtnImprimir().addActionListener(l -> imprimeReporte());
    }

    public void abrirRegistro(int op) {
        modelEmpleado modeloEmpleado = new modelEmpleado();
        viewRegistrarEmpleado vistaRegistroEmpleado = new viewRegistrarEmpleado();
        ControllerRegistroEmpleado controladorEmpleado = new ControllerRegistroEmpleado(modeloEmpleado, vistaRegistroEmpleado, vistaE);

        if (op == 1) {

            //Agragar vista al desktop pane
            vistaP.getjDPprincipal().add(vistaRegistroEmpleado);

//            ControllerRegistroEmpleado controladorEmpleado = new ControllerRegistroEmpleado(modeloEmpleado, vistaRegistroEmpleado, vistaE);
            controladorEmpleado.abrirRegistro(1);

        } else {
            //Agragar vista al desktop pane
//            ControllerRegistroEmpleado controladorEmpleado = new ControllerRegistroEmpleado(modeloEmpleado, vistaRegistroEmpleado, vistaE);
            int fila = vistaE.getjTblEmpleado().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione la persona a modificar");
            } else {
                vistaP.getjDPprincipal().add(vistaRegistroEmpleado);
                controladorEmpleado.abrirRegistro(2);
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
        vistaE.getjTblEmpleado().setDefaultRenderer(Object.class, new imageTable());
        vistaE.getjTblEmpleado().setRowHeight(60);
        estructuraTabla = (DefaultTableModel) vistaE.getjTblEmpleado().getModel();
        estructuraTabla.setRowCount(0);
        List<Empleado> listaE;
        if (opc == 1) {
            listaE = modeloE.getempleado();
        } else {
            String busqueda = vistaE.getTxtBuscar().getText().toLowerCase().trim();
            listaE = modeloE.busquedaIncrementalPersona(busqueda);
        }

//        Holder<Integer> i = new Holder<>(0);
        i = 0;
        listaE.stream().sorted((x, y)
                -> x.getNombre().compareToIgnoreCase(y.getNombre())).forEach(emp -> {
            estructuraTabla.addRow(new Object[8]);
            vistaE.getjTblEmpleado().setValueAt(emp.getIdEmp(), i, 0);
            vistaE.getjTblEmpleado().setValueAt(emp.getCedula(), i, 1);
            vistaE.getjTblEmpleado().setValueAt(emp.getNombre(), i, 2);
            vistaE.getjTblEmpleado().setValueAt(emp.getApellido(), i, 3);
            vistaE.getjTblEmpleado().setValueAt(emp.getTelefono(), i, 4);
            vistaE.getjTblEmpleado().setValueAt(formatofecha.format(emp.getFechanacimiento()), i, 5);
//            vistaE.getjTblEmpleado().setValueAt(emp.getFechanacimiento().toString(), i, 5);
            vistaE.getjTblEmpleado().setValueAt(emp.getCorreo(), i, 6);
            vistaE.getjTblEmpleado().setValueAt(emp.getGenero(), i, 7);
            vistaE.getjTblEmpleado().setValueAt(modeloE.obtenerRol(emp.getRol()), i, 8);
            vistaE.getjTblEmpleado().setValueAt(emp.getUsuario(), i, 9);
            vistaE.getjTblEmpleado().setValueAt(emp.getContraseña(), i, 10);
            vistaE.getjTblEmpleado().setValueAt(formatofecha.format(emp.getFechaRegistro()), i, 11);

            Image foto = emp.getFoto();
            if (foto != null) {
                foto = foto.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(foto);

                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setIcon(icono);
                vistaE.getjTblEmpleado().setValueAt(new JLabel(icono), i, 12);
            } else {
                vistaE.getjTblEmpleado().setValueAt(null, i, 12);
            }
            i++;
        });

    }

    public void eliminarEmpleado() {
        modelEmpleado empleado = new modelEmpleado();
        int fila = vistaE.getjTblEmpleado().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el empleado a eliminar");
        } else {
            int response = JOptionPane.showConfirmDialog(vistaRE, "¿Esta seguro de eliminar al empleado?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String cedula = vistaE.getjTblEmpleado().getValueAt(fila, 1).toString();
                int codigo = Integer.parseInt(vistaE.getjTblEmpleado().getValueAt(fila, 0).toString());
                String opc = vistaE.getjTblEmpleado().getValueAt(fila, 8).toString();
                switch (opc) {
                    case "Gerente":
                        //Gerente
                        if (empleado.deleteGerente(codigo, cedula)) {//Grabamos
                            JOptionPane.showMessageDialog(vistaRE, "Empleado eliminado correctamente");
                            cargarDatos(1);
                        } else {
                            JOptionPane.showMessageDialog(vistaRE, "No se pudo eliminar al empleado");
                        }
                        break;
                    case "Secretaria":
                        //Secretaria
                        if (empleado.deletesecretaria(codigo, cedula)) {//Grabamos
                            JOptionPane.showMessageDialog(vistaRE, "Empleado eliminado correctamente");
                            cargarDatos(1);
                        } else {
                            JOptionPane.showMessageDialog(vistaRE, "No se pudo eliminar al empleado");
                        }
                        break;
                    case "Zoologo":
                        //Zoologo
                        if (empleado.deleteZoologo(codigo, cedula)) {//Grabamos
                            JOptionPane.showMessageDialog(vistaRE, "Empleado eliminado correctamente");
                            cargarDatos(1);
                        } else {
                            JOptionPane.showMessageDialog(vistaRE, "No se pudo eliminar al empleado");
                        }
                        break;
                    case "Cuidador":
                        //Cuidador
                        if (empleado.deletecuidador(codigo, cedula)) {//Grabamos
                            JOptionPane.showMessageDialog(vistaRE, "Empleado eliminado correctamente");
                            cargarDatos(1);
                        } else {
                            JOptionPane.showMessageDialog(vistaRE, "No se pudo eliminar al empleado");
                        }
                        break;
                }
            }
        }
    }

    private void imprimeReporte() {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/ReportePersonal.jasper"));
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/ReportePersonal.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("titulo", "REPORTE DE PERSONAL");
            parametros.put("busqueda", vistaE.getTxtBuscar().getText().toLowerCase());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            if (vistaE.getjTblEmpleado().getRowCount() != 0) {
                jv.setVisible(true);

            }
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
