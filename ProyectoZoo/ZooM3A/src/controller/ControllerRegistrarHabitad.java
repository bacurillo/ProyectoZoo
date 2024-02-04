/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Alimento;
import model.Habitat;
import model.ModelHabitad;
import model.Zoologo;
import model.modelZoologo;
import view.viewLogin;
import view.viewRegistroHabitad;
import view.viewVistaHabitats;

/**
 *
 * @author ALEJO
 */
public class ControllerRegistrarHabitad {

    private viewRegistroHabitad vistaRegHabitat;
    private viewVistaHabitats vistaHab;
    private ModelHabitad modelHabitat;
    private modelZoologo modeloZool;
    boolean banvista = false;
    int i = 0;
    DefaultTableModel estructuraTabla;

    public ControllerRegistrarHabitad() {
    }

    public ControllerRegistrarHabitad(viewRegistroHabitad vistaRegHabitad, viewVistaHabitats vistaHab, ModelHabitad modelHabitad, modelZoologo modeloZool) {
        this.vistaRegHabitat = vistaRegHabitad;
        this.vistaHab = vistaHab;
        this.modelHabitat = modelHabitad;
        this.modeloZool = modeloZool;
        vistaRegHabitat.getTxtOtrobloque().setEditable(false);
        vistaRegHabitat.getTxtOtrotipo().setEditable(false);
        vistaRegHabitad.toFront();
        vistaRegHabitad.setVisible(true);
        banvista = true;
    }

    public ControllerRegistrarHabitad(viewRegistroHabitad vistaRegHabitad, ModelHabitad modelHabitad, modelZoologo modeloZool) {
        this.vistaRegHabitat = vistaRegHabitad;
        this.modelHabitat = modelHabitad;
        this.modeloZool = modeloZool;
        vistaRegHabitat.getTxtOtrobloque().setEditable(false);
        vistaRegHabitat.getTxtOtrotipo().setEditable(false);
        vistaRegHabitad.toFront();
        vistaRegHabitad.setVisible(true);
        banvista = false;
    }

    public void iniciarControl() {
        vistaRegHabitat.getBtregistrar().addActionListener(l -> registrarActualizar());
        vistaRegHabitat.getBtcancelar().addActionListener(l -> vistaRegHabitat.dispose());
        vistaRegHabitat.getJbtnSelecZoologo().addActionListener(l -> abrirDlg());
        vistaRegHabitat.getBtnseleccionardlg().addActionListener(l -> llenarDatosZoologo());
        vistaRegHabitat.getTxtbuscardlg().addKeyListener(busquedaIncren);
        vistaRegHabitat.getComboTipoHab().addActionListener(l -> activarTxtTipo());
        vistaRegHabitat.getComboUbicacion().addActionListener(l -> activarTxtBloque());
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
            cargarDatosDlg(2);
        }
    };

    public void abrirRegistro(int op) {
        vistaRegHabitat.toFront();
        if (op == 1) {
            limpiarCampos();
            vistaRegHabitat.setName("Registro");
            vistaRegHabitat.getBtregistrar().setText("REGISTRAR");
            vistaRegHabitat.setVisible(true);
            this.iniciarControl();
        } else {
            if (llenarDatos()) {
                vistaRegHabitat.setName("Editar");
//                vistaRegAlimento.getTxtcedula().setEditable(false);
                vistaRegHabitat.getBtregistrar().setText("ACTUALIZAR");
                vistaRegHabitat.setVisible(true);
                this.iniciarControl();
            }
        }
    }

    public void activarTxtBloque() {
        if (vistaRegHabitat.getComboUbicacion().getSelectedIndex() != vistaRegHabitat.getComboUbicacion().getItemCount() - 1) {
            vistaRegHabitat.getTxtOtrobloque().setText("");
            vistaRegHabitat.getTxtOtrobloque().setEditable(false);
        } else {
            vistaRegHabitat.getTxtOtrobloque().setEditable(true);
        }
    }

    public void activarTxtTipo() {
        if (vistaRegHabitat.getComboTipoHab().getSelectedIndex() != vistaRegHabitat.getComboTipoHab().getItemCount() - 1) {
            vistaRegHabitat.getTxtOtrotipo().setText("");
            vistaRegHabitat.getTxtOtrotipo().setEditable(false);
        } else {
            vistaRegHabitat.getTxtOtrotipo().setEditable(true);
        }
    }

    public void registrarActualizar() {
        validaciones mivalidacion = new validaciones();

        if (validar()) {
            //Habitad
            String tipo = "",
                    ubicacion = "";
            int capacidad = (int) vistaRegHabitat.getjSpiCapacidad().getValue(),
                    idZoologo = Integer.parseInt(vistaRegHabitat.getTxtidZoologoNoborrar().getText());

            if (vistaRegHabitat.getComboTipoHab().getSelectedIndex() == vistaRegHabitat.getComboTipoHab().getItemCount() - 1) {
                tipo = vistaRegHabitat.getTxtOtrotipo().getText();
            } else {
                tipo = vistaRegHabitat.getComboTipoHab().getSelectedItem().toString();
            }

            if (vistaRegHabitat.getComboUbicacion().getSelectedIndex() == vistaRegHabitat.getComboUbicacion().getItemCount() - 1) {
                ubicacion = vistaRegHabitat.getTxtOtrobloque().getText();
            } else {
                ubicacion = vistaRegHabitat.getComboUbicacion().getSelectedItem().toString();
            }
//            int fila = vistaRegHabitad.getTabladlg().getSelectedRow();

            ModelHabitad habitad = new ModelHabitad();
            habitad.setTipohab(tipo);
            habitad.setCapacidadhap(capacidad);
            habitad.setIdZoologohab(idZoologo);
            habitad.setUbicacionhab(ubicacion);
            habitad.setEstadohab(true);

            if (vistaRegHabitat.getName().equals("Registro")) {
                int response = JOptionPane.showConfirmDialog(vistaRegHabitat, "¿Agregar Habitat?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
//                    if (alimento.comprobarDuplicado(cedula)) {
                    if (habitad.setHabitad()) {
                        JOptionPane.showMessageDialog(vistaRegHabitat, "Habitat agregado/a correctamente");
                        vistaRegHabitat.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegHabitat, "No se pudo agregar el Habitat");
                    }
//                    } else {
//                        JOptionPane.showMessageDialog(vistaRegAlimento, "El cliente ya se encuentra registrado");
//                    }

                }
            } else {
                //UPDATE
                int id = Integer.parseInt(vistaRegHabitat.getTxtidHabitadNoborrar().getText());
                habitad.setId_habitat(id);
                int response = JOptionPane.showConfirmDialog(vistaRegHabitat, "¿Seguro que desea actualizar los datos del cliente?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (habitad.updateHabitad()) {//Grabamos
                        JOptionPane.showMessageDialog(vistaRegHabitat, "Alimento actualizado correctamente");
                        vistaRegHabitat.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegHabitat, "No se pudo actualizar a los datos del alimento");
                    }
                }
            }

            System.out.println(banvista);
            if (banvista) {
                ControllerVistaHabitat controlHab = new ControllerVistaHabitat(vistaHab, modelHabitat);
                controlHab.cargarDatos(1);
            }
        }
    }

    public void limpiarCampos() {
        vistaRegHabitat.getComboTipoHab().setSelectedIndex(0);
        vistaRegHabitat.getTxtOtrotipo().setText("");
        vistaRegHabitat.getTxtbuscardlg().setText("");
        vistaRegHabitat.getComboUbicacion().setSelectedIndex(0);
        vistaRegHabitat.getTxtOtrobloque().setText("");
        vistaRegHabitat.getTxtnombreZol().setText("");
        vistaRegHabitat.getTxtramaZol().setText("");
        vistaRegHabitat.getTxtidHabitadNoborrar().setText("");
        vistaRegHabitat.getTxtidZoologoNoborrar().setText("");
    }

    public boolean llenarDatos() {
        vistaRegHabitat.getTxtidHabitadNoborrar().setVisible(false);
        int fila = vistaHab.getjTblHabitat().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el proveedor a modificar");
            return false;
        } else {

            int id = Integer.parseInt(vistaHab.getjTblHabitat().getValueAt(fila, 0).toString());
            List<Habitat> listap = modelHabitat.getHabitad();
            listap.stream().forEach(hab -> {
                if (id == hab.getId_habitat()) {
                    vistaRegHabitat.getTxtidHabitadNoborrar().setText(String.valueOf(hab.getId_habitat()));
                    vistaRegHabitat.getjSpiCapacidad().setValue(hab.getCapacidadhap());
                    vistaRegHabitat.getTxtnombreZol().setText(hab.getNombre());
                    vistaRegHabitat.getTxtramaZol().setText(hab.getRama());
                    vistaRegHabitat.getTxtidZoologoNoborrar().setText(String.valueOf(hab.getIdZoologohab()));
                    //tipo habitat
                    for (int j = 0; j < vistaRegHabitat.getComboTipoHab().getItemCount(); j++) {
                        if (vistaRegHabitat.getComboTipoHab().getItemAt(j).equalsIgnoreCase(hab.getTipohab())) {
                            vistaRegHabitat.getComboTipoHab().setSelectedIndex(j);
                        }
                    }
                    if (vistaRegHabitat.getComboTipoHab().getSelectedIndex() == 0) {
                        vistaRegHabitat.getComboTipoHab().setSelectedIndex(vistaRegHabitat.getComboTipoHab().getItemCount() - 1);
                        vistaRegHabitat.getTxtOtrotipo().setText(hab.getTipohab());
                    }

                    //ubicacion
                    for (int j = 0; j < vistaRegHabitat.getComboUbicacion().getItemCount(); j++) {
                        if (vistaRegHabitat.getComboUbicacion().getItemAt(j).equalsIgnoreCase(hab.getUbicacionhab())) {
                            vistaRegHabitat.getComboUbicacion().setSelectedIndex(j);
                        }
                    }
                    if (vistaRegHabitat.getComboUbicacion().getSelectedIndex() == 0) {
                        vistaRegHabitat.getComboUbicacion().setSelectedIndex(vistaRegHabitat.getComboUbicacion().getItemCount() - 1);
                        vistaRegHabitat.getTxtOtrobloque().setText(hab.getUbicacionhab());
                    }
                }

            });
//            vistaE.dispose();

            return true;
        }

    }

    public void llenarDatosZoologo() {
        if (vistaRegHabitat.getTabladlg().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(vistaRegHabitat.getTabladlg(), "No ha seleccionado ningun zoologo");
        } else {
            vistaRegHabitat.getTxtidHabitadNoborrar().setVisible(false);
            vistaRegHabitat.getTxtidZoologoNoborrar().setVisible(false);

            int fila = vistaRegHabitat.getTabladlg().getSelectedRow();
//        int idProv = Integer.parseInt(vistaRegAlimento.getTabladlg().getValueAt(fila, 0).toString());
            String nombre = vistaRegHabitat.getTabladlg().getValueAt(fila, 1).toString(),
                    rama = vistaRegHabitat.getTabladlg().getValueAt(fila, 2).toString(),
                    id = vistaRegHabitat.getTabladlg().getValueAt(fila, 0).toString();

            vistaRegHabitat.getTxtidZoologoNoborrar().setText(id);
            vistaRegHabitat.getTxtnombreZol().setText(nombre);
            vistaRegHabitat.getTxtramaZol().setText(rama);
            vistaRegHabitat.getjDlgZoologo().dispose();
            vistaRegHabitat.getTxtbuscardlg().setText("");
        }
    }

    public void abrirDlg() {
        vistaRegHabitat.getjDlgZoologo().setLocationRelativeTo(vistaRegHabitat);
        vistaRegHabitat.getjDlgZoologo().setVisible(true);
        cargarDatosDlg(1);
    }

    public void cargarDatosDlg(int opc) {

        vistaRegHabitat.getTabladlg().setRowHeight(25);
        estructuraTabla = (DefaultTableModel) vistaRegHabitat.getTabladlg().getModel();
        estructuraTabla.setRowCount(0);

        List<Zoologo> listaZol;
//        if (opc == 1) {
//            listaProv = modeloProv.getProveedor();
//        } else {
        String busqueda = vistaRegHabitat.getTxtbuscardlg().getText().toLowerCase().trim();
        listaZol = modeloZool.busquedaincremental(busqueda);
//        }

        i = 0;
        listaZol.stream().sorted((x, y)
                -> x.getNombre().compareToIgnoreCase(y.getNombre())).forEach(emp -> {
            estructuraTabla.addRow(new Object[listaZol.size()]);
            vistaRegHabitat.getTabladlg().setValueAt(emp.getIdZoo(), i, 0);
            vistaRegHabitat.getTabladlg().setValueAt(emp.getNombre(), i, 1);
            vistaRegHabitat.getTabladlg().setValueAt(emp.getRama(), i, 2);
            i++;
        });

    }

    public boolean validar() {
        boolean ban = true;
        validaciones mivalidacion = new validaciones();

        if (vistaRegHabitat.getComboTipoHab().getSelectedIndex() == 0 && vistaRegHabitat.getTxtOtrotipo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegHabitat, "Seleccione un tipo de habitat");
            ban = false;
        }
        if (vistaRegHabitat.getComboUbicacion().getSelectedIndex() == 0 && vistaRegHabitat.getTxtOtrobloque().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegHabitat, "Seleccione el bloque donde se encuentra ubicado el habitat");
            ban = false;
        }
        if (vistaRegHabitat.getTxtnombreZol().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegHabitat, "Seleccione el zoologo acargo");
            ban = false;
        }
        if (vistaRegHabitat.getTxtidZoologoNoborrar().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegHabitat, "Seleccione el zoologo acargo");
            ban = false;
        }
        return ban;
    }

}
