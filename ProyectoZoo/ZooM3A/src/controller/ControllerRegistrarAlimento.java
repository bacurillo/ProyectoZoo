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
import model.Cliente;
import model.ModelAlimento;
import model.Proveedor;
import model.modelProveedor;
import view.viewLogin;
import view.viewRegistroAlimento;
import view.viewVistaAlimento;

/**
 *
 * @author ALEJO
 */
public class ControllerRegistrarAlimento {

    private viewRegistroAlimento vistaRegAlimento;
    private viewVistaAlimento vistaAli;
    private ModelAlimento modelAlimento;
    private modelProveedor modeloProv;
    boolean banvista = false;
    int i = 0;
    DefaultTableModel estructuraTabla;

    public ControllerRegistrarAlimento() {
    }

    public ControllerRegistrarAlimento(viewRegistroAlimento vistaRegAlimento, ModelAlimento modelAlimento, modelProveedor modeloProv, viewVistaAlimento vistaAli) {
        this.vistaRegAlimento = vistaRegAlimento;
        this.modelAlimento = modelAlimento;
        this.modeloProv = modeloProv;
        this.vistaAli = vistaAli;
        vistaRegAlimento.toFront();
        vistaRegAlimento.setVisible(true);
        banvista = true;
    }

    public ControllerRegistrarAlimento(viewRegistroAlimento vistaRegAlimento, ModelAlimento modelAlimento, modelProveedor modeloProv) {
        this.vistaRegAlimento = vistaRegAlimento;
        this.modelAlimento = modelAlimento;
        this.modeloProv = modeloProv;
        vistaRegAlimento.toFront();
        vistaRegAlimento.setVisible(true);
        banvista = false;
    }

    public void iniciarControl() {
        vistaRegAlimento.getJbtnAgregar().addActionListener(l -> registrarActualizar());
        vistaRegAlimento.getJbtnCancelar().addActionListener(l -> vistaRegAlimento.dispose());
        vistaRegAlimento.getBtnSeleccionarProv().addActionListener(l -> abrirDlg());
        vistaRegAlimento.getBtnseleccionardlg().addActionListener(l -> llenarDatosProv());
        vistaRegAlimento.getTxtbuscardlg().addKeyListener(busquedaIncren);
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
        vistaRegAlimento.toFront();
        if (op == 1) {
            limpiarCampos();
            vistaRegAlimento.setName("Registro");
            vistaRegAlimento.getJbtnAgregar().setText("REGISTRAR");
            vistaRegAlimento.setVisible(true);
            this.iniciarControl();
        } else {
            if (llenarDatos()) {
                vistaRegAlimento.setName("Editar");
//                vistaRegAlimento.getTxtcedula().setEditable(false);
                vistaRegAlimento.getJbtnAgregar().setText("ACTUALIZAR");
                vistaRegAlimento.setVisible(true);
                this.iniciarControl();
            }
        }
    }

    public void registrarActualizar() {
        validaciones mivalidacion = new validaciones();

        if (validar()) {
            //ALIMENTO
            String nombre = vistaRegAlimento.getTxtnombrealimento().getText(),
                    precio = vistaRegAlimento.getTxtPrecio().getText(),
                    descripcion = vistaRegAlimento.getTxtAdescripcion().getText();
            //PROVEEDOR
            int fila = vistaRegAlimento.getTabladlg().getSelectedRow();
            int idProv = Integer.parseInt(vistaRegAlimento.getTxtidPorv().getText());

            ModelAlimento alimento = new ModelAlimento();
            alimento.setNombreAli(nombre);
            alimento.setPrecioAli(mivalidacion.validarDouble(precio));
            alimento.setDescripcionAli(descripcion);
            alimento.setIdproveedor(idProv);
            alimento.setEstadoAli(true);

            if (vistaRegAlimento.getName().equals("Registro")) {
                int response = JOptionPane.showConfirmDialog(vistaRegAlimento, "¿Agregar Alimento?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
//                    if (alimento.comprobarDuplicado(cedula)) {
                    if (alimento.setAlimento()) {
                        JOptionPane.showMessageDialog(vistaRegAlimento, "Alimento agregado/a correctamente");
                        vistaRegAlimento.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegAlimento, "No se pudo agregar el alimento");
                    }
//                    } else {
//                        JOptionPane.showMessageDialog(vistaRegAlimento, "El cliente ya se encuentra registrado");
//                    }

                }
            } else {
                //UPDATE
                int id = Integer.parseInt(vistaRegAlimento.getTxtidAli().getText());
                alimento.setIdalimento(id);
                int response = JOptionPane.showConfirmDialog(vistaRegAlimento, "¿Seguro que desea actualizar los datos del alimento?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (alimento.updateAlimento()) {//Grabamos
                        JOptionPane.showMessageDialog(vistaRegAlimento, "Alimento actualizado correctamente");
                        vistaRegAlimento.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegAlimento, "No se pudo actualizar a los datos del alimento");
                    }
                }
            }
            if (banvista) {
                ControllerVistaAlimento controlAli = new ControllerVistaAlimento(vistaAli, modelAlimento);
                controlAli.cargarDatos(1);
            }
        }
    }

    public void limpiarCampos() {
        vistaRegAlimento.getTxtAdescripcion().setText("");
        vistaRegAlimento.getTxtPrecio().setText("");
        vistaRegAlimento.getTxtbuscardlg().setText("");
        vistaRegAlimento.getTxtciudadProv().setText("");
        vistaRegAlimento.getTxtnombreProv().setText("");
        vistaRegAlimento.getTxtnombrealimento().setText("");
        vistaRegAlimento.getTxtnombreProv().setText("");
    }

    public boolean llenarDatos() {
        int fila = vistaAli.getjTblAlimento().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaAli, "Seleccione un alimento a modificar");
            return false;
        } else {
            int id = Integer.parseInt(vistaAli.getjTblAlimento().getValueAt(fila, 0).toString());
            List<Alimento> listap = modelAlimento.getAlimento();
            listap.stream().forEach(ali -> {
                if (id == ali.getIdalimento()) {
                    vistaRegAlimento.getTxtidAli().setText(String.valueOf(ali.getIdalimento()));
                    vistaRegAlimento.getTxtnombrealimento().setText(ali.getNombreAli());
                    vistaRegAlimento.getTxtPrecio().setText(String.valueOf(ali.getPrecioAli()));
                    vistaRegAlimento.getTxtAdescripcion().setText(ali.getDescripcionAli());
                    vistaRegAlimento.getTxtidPorv().setText(String.valueOf(ali.getIdproveedor()));
                    vistaRegAlimento.getTxtnombreProv().setText(ali.getNombre_pro());
                    vistaRegAlimento.getTxtciudadProv().setText(ali.getCiudad_pro());
                    vistaRegAlimento.getTxttelefonoProv().setText(ali.getTelefono());

                }
            });
            return true;
        }
    }

    public void llenarDatosProv() {
        if (vistaRegAlimento.getTabladlg().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(vistaRegAlimento.getTabladlg(), "No ha seleccionado ningun proveedor");
        } else {
            vistaRegAlimento.getTxtidAli().setVisible(false);
            vistaRegAlimento.getTxtidPorv().setVisible(false);

            int fila = vistaRegAlimento.getTabladlg().getSelectedRow();
//        int idProv = Integer.parseInt(vistaRegAlimento.getTabladlg().getValueAt(fila, 0).toString());
            String nombre = vistaRegAlimento.getTabladlg().getValueAt(fila, 1).toString(),
                    ciudad = vistaRegAlimento.getTabladlg().getValueAt(fila, 2).toString(),
                    telefono = vistaRegAlimento.getTabladlg().getValueAt(fila, 3).toString(),
                    id = vistaRegAlimento.getTabladlg().getValueAt(fila, 0).toString();

            vistaRegAlimento.getTxtidPorv().setText(id);
            vistaRegAlimento.getTxtnombreProv().setText(nombre);
            vistaRegAlimento.getTxtciudadProv().setText(ciudad);
            vistaRegAlimento.getTxttelefonoProv().setText(telefono);
            vistaRegAlimento.getjDlgProveedor().dispose();
            vistaRegAlimento.getTxtbuscardlg().setText("");
        }
    }

    public void abrirDlg() {
        vistaRegAlimento.getjDlgProveedor().setLocationRelativeTo(vistaRegAlimento);
        vistaRegAlimento.getjDlgProveedor().setVisible(true);
        cargarDatosDlg(1);
    }

    public void cargarDatosDlg(int opc) {

        vistaRegAlimento.getTabladlg().setRowHeight(25);
        estructuraTabla = (DefaultTableModel) vistaRegAlimento.getTabladlg().getModel();
        estructuraTabla.setRowCount(0);

        List<Proveedor> listaProv;
//        if (opc == 1) {
//            listaProv = modeloProv.getProveedor();
//        } else {
        String busqueda = vistaRegAlimento.getTxtbuscardlg().getText().toLowerCase().trim();
        listaProv = modeloProv.busquedaIncrementalProveedor(busqueda);
//        }

        i = 0;
        listaProv.stream().sorted((x, y)
                -> x.getCiudad_pro().compareToIgnoreCase(y.getCiudad_pro())).forEach(prov -> {
            if (prov.isEstadoProv()) {

                estructuraTabla.addRow(new Object[listaProv.size()]);
                vistaRegAlimento.getTabladlg().setValueAt(prov.getId_proveedor(), i, 0);
                vistaRegAlimento.getTabladlg().setValueAt(prov.getNombre_pro(), i, 1);
                vistaRegAlimento.getTabladlg().setValueAt(prov.getCiudad_pro(), i, 2);
                vistaRegAlimento.getTabladlg().setValueAt(prov.getTelefono(), i, 3);
            }
            i++;
        });
    }

    public boolean validar() {
        boolean ban = true;
        validaciones mivalidacion = new validaciones();

        if (!vistaRegAlimento.getTxtnombrealimento().getText().isEmpty()) {
            if (!mivalidacion.validarNombApeEspacios(vistaRegAlimento.getTxtnombrealimento().getText())) {
                JOptionPane.showMessageDialog(vistaRegAlimento, "Nombre invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vistaRegAlimento, "Ingrese el nombre");
            ban = false;
        }

        if (!vistaRegAlimento.getTxtPrecio().getText().isEmpty()) {
            if (mivalidacion.validarDouble(vistaRegAlimento.getTxtPrecio().getText()) == 0) {
                JOptionPane.showMessageDialog(vistaRegAlimento, "Precio invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vistaRegAlimento, "Ingrese el precio");
            ban = false;
        }

        if (vistaRegAlimento.getTxtAdescripcion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegAlimento, "Ingrese la descripcion");
            ban = false;
        }
        if (vistaRegAlimento.getTxtnombreProv().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegAlimento, "Seleccione el Proveedor");
            ban = false;
        }
        return ban;
    }

}
//    public DefaultTableModel DatosTabla() {
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("Id");
//        modelo.addColumn("Nombre");
//        modelo.addColumn("Ciudad");
//        modelo.addColumn("Telefono");
//        return modelo;
//    }
//

//        vistaRegAlimento.getTabladlg().setRowHeight(25);
//        vistaRegAlimento.getTabladlg().setModel(estructuraTabla);
//        List<Proveedor> listaProv;
////        if (opc == 1) {
////            listaProv = modeloProv.getProveedor();
////        } else {
//        String busqueda = vistaRegAlimento.getTxtbuscardlg().getText().toLowerCase().trim();
//        listaProv = modeloProv.busquedaIncrementalProveedor(busqueda);
////        }
//
////        Holder<Integer> i = new Holder<>(0);
//        i = 0;
//        listaProv.stream().sorted((x, y)
//                -> x.getCiudad_pro().compareToIgnoreCase(y.getCiudad_pro())).forEach(emp -> {
//            estructuraTabla.addRow(new Object[listaProv.size()]);
//            vistaRegAlimento.getTabladlg().setValueAt(emp.getId_proveedor(), i, 0);
//            vistaRegAlimento.getTabladlg().setValueAt(emp.getNombre_pro(), i, 1);
//            vistaRegAlimento.getTabladlg().setValueAt(emp.getCiudad_pro(), i, 2);
//            vistaRegAlimento.getTabladlg().setValueAt(emp.getTelefono(), i, 3);
//            i++;
//        });
