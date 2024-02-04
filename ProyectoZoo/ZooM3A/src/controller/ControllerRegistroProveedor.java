/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import model.modelEmpleado;
import view.viewRegistrarProveedor;
import view.viewVistaProveedor;
import javax.swing.table.DefaultTableModel;
import model.modelProveedor;
import model.Proveedor;
import model.modelProveedor;

/**
 *
 * @author ALEJO
 */
public class ControllerRegistroProveedor {

//    private viewPantallaPrincipal vistaP;
//    private controllerPantallaprincipal controllerpp;
    private modelProveedor modeloProv;
    private viewRegistrarProveedor vistaRegProv;
    private viewVistaProveedor vistaVistaProv;
    int i = 0;
    boolean banvista = false;

    DefaultTableModel estructuraTabla;
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    public ControllerRegistroProveedor() {
    }

    public ControllerRegistroProveedor(modelProveedor modeloProv, viewRegistrarProveedor vistaProv) {
        this.modeloProv = modeloProv;
        this.vistaRegProv = vistaProv;
        vistaProv.toFront();
        vistaProv.getTxtOtraCiudad().setEditable(false);
        vistaProv.setVisible(true);
        banvista = false;
    }

    public ControllerRegistroProveedor(modelProveedor modeloProv, viewRegistrarProveedor vistaProv, viewVistaProveedor vistaProvTbl) {
        this.modeloProv = modeloProv;
        this.vistaRegProv = vistaProv;
        this.vistaVistaProv = vistaProvTbl;
        vistaProv.toFront();
        vistaProv.getTxtOtraCiudad().setEditable(false);
        vistaProv.setVisible(true);
        banvista = true;
    }

    public void inicialControl() {
        vistaRegProv.getComboCiudad().addActionListener(l -> activarTxtCiudad());
        vistaRegProv.getBtregistrar().addActionListener(l -> crearEditarPersona());
        vistaRegProv.getBtcancelar().addActionListener(l -> vistaRegProv.dispose());
    }

    public void abrirRegistro(int op) {
        vistaRegProv.getTxtOtraCiudad().setEditable(false);
        vistaRegProv.toFront();
        String titulo;
//        cargarComboRol();
        if (op == 1) {
            limpiarCampos();
            titulo = "Crear";
            vistaRegProv.setName("Registro");
            vistaRegProv.getBtregistrar().setText("REGISTRAR");
            vistaRegProv.setVisible(true);
            this.inicialControl();
        } else {
            titulo = "Editar";
            if (llenarDatos()) {
                vistaRegProv.setName("Editar");
                vistaRegProv.getBtregistrar().setText("ACTUALIZAR");
                vistaRegProv.setVisible(true);
                this.inicialControl();
            }
        }
    }

    public void activarTxtCiudad() {
        if (vistaRegProv.getComboCiudad().getSelectedIndex() != vistaRegProv.getComboCiudad().getItemCount() - 1) {
            vistaRegProv.getTxtOtraCiudad().setText("");
            vistaRegProv.getTxtOtraCiudad().setEditable(false);
        } else {
            vistaRegProv.getTxtOtraCiudad().setEditable(true);
        }
    }

    private void crearEditarPersona() {
        if (validar()) {
            //Datos proveedor
            String nombre = vistaRegProv.getTxtnombre().getText(),
                    telefono = vistaRegProv.getTxttelefono().getText(),
                    ciudad = "";
            if (vistaRegProv.getComboCiudad().getSelectedIndex() == vistaRegProv.getComboCiudad().getItemCount() - 1) {
                ciudad = vistaRegProv.getTxtOtraCiudad().getText();
            } else {
                ciudad = vistaRegProv.getComboCiudad().getSelectedItem().toString();
            }

            modelProveedor prov = new modelProveedor();
//            prov.setId_proveedor(id);
            prov.setNombre_pro(nombre);
            prov.setCiudad_pro(ciudad);
            prov.setTelefono(telefono);
            prov.setEstadoProv(true);

            if (vistaRegProv.getName().equals("Registro")) {
                if (modeloProv.comprobarDuplicado(nombre, ciudad)) {
                    //INSERT
                    int response = JOptionPane.showConfirmDialog(vistaRegProv, "¿Esta seguro que desea agregar un proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        if (prov.setProveedor()) {//Grabamos
                            JOptionPane.showMessageDialog(vistaRegProv, "Proovedor agregado correctamente");
                            vistaRegProv.dispose();
//                            cargarDatos(1);
                        } else {
                            JOptionPane.showMessageDialog(vistaRegProv, "No se pudo agregar a la proveedor");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaRegProv, "El proveedor ya se encuentra registrado");
                }
            } else {
                //UPDATE
                int id = Integer.parseInt(vistaRegProv.getTxtid_prov().getText());
                prov.setId_proveedor(id);

                int response = JOptionPane.showConfirmDialog(vistaRegProv, "¿Seguro que desea actualizar al proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (prov.updateProveedor()) {//Grabamos
                        System.out.println("ciudad" + prov.getCiudad_pro());
                        JOptionPane.showMessageDialog(vistaRegProv, "Proovedor actualizado correctamente");
                        vistaRegProv.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegProv, "No se pudo actualizar a la proveedor");
                    }
                }
            }
            if (banvista) {
                ControllerVistaProveedor controlVprov = new ControllerVistaProveedor(modeloProv, vistaVistaProv);
                controlVprov.cargarDatos(1);
            }
        }
    }

    public boolean llenarDatos() {
        vistaRegProv.getTxtid_prov().setVisible(false);
        int fila = vistaVistaProv.getjTblProveedor().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el proveedor a modificar");
            return false;
        } else {

            int id = Integer.parseInt(vistaVistaProv.getjTblProveedor().getValueAt(fila, 0).toString());
            List<Proveedor> listap = modeloProv.getProveedor();
            listap.stream().forEach(prov -> {
                if (id == prov.getId_proveedor()) {
                    vistaRegProv.getTxtid_prov().setText(String.valueOf(prov.getId_proveedor()));
                    vistaRegProv.getTxtnombre().setText(prov.getNombre_pro());
//                    vistaProv.getTxtOtraCiudad().setText(prov.getCiudad_pro());
                    vistaRegProv.getTxttelefono().setText(prov.getTelefono());
                    vistaRegProv.getTxttelefono().setText(prov.getTelefono());

                    for (int j = 0; j < vistaRegProv.getComboCiudad().getItemCount(); j++) {
                        if (vistaRegProv.getComboCiudad().getItemAt(j).equalsIgnoreCase(prov.getCiudad_pro())) {
                            vistaRegProv.getComboCiudad().setSelectedIndex(j);
                        }
                    }
                    if (vistaRegProv.getComboCiudad().getSelectedIndex() == 0) {
                        vistaRegProv.getComboCiudad().setSelectedIndex(vistaRegProv.getComboCiudad().getItemCount() - 1);
                        vistaRegProv.getTxtOtraCiudad().setText(prov.getCiudad_pro());
                    }
                }

            });
//            vistaE.dispose();

            return true;
        }

    }

    public boolean validar() {
        boolean ban = true;
        validaciones mivalidacion = new validaciones();
        //NOMBRE
        if (!vistaRegProv.getTxtnombre().getText().isEmpty()) {
            if (!mivalidacion.validarNombApeEspacios(vistaRegProv.getTxtnombre().getText())) {
                JOptionPane.showMessageDialog(vistaRegProv, "Nombre invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vistaRegProv, "Ingrese el nombre");
            ban = false;
        }
        //TELEFONO
        if (!vistaRegProv.getTxttelefono().getText().isEmpty()) {
            if (!mivalidacion.validarTelefono(vistaRegProv.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(vistaRegProv, "Telefono invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vistaRegProv, "Ingrese el numero de telefono");
            ban = false;
        }
        //COMBO
        if (vistaRegProv.getComboCiudad().getSelectedIndex() == 0 && vistaRegProv.getTxtOtraCiudad().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegProv, "Seleccione una ciudad");
            ban = false;
        }

        return ban;
    }

    public void limpiarCampos() {
        vistaRegProv.getTxtnombre().setText("");
        vistaRegProv.getTxttelefono().setText("");
        vistaRegProv.getTxtOtraCiudad().setText("");
        vistaRegProv.getComboCiudad().setSelectedIndex(0);
    }

}
