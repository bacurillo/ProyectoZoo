/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ModelCliente;
import model.modelPersona;
import view.viewLogin;
import view.viewRegistrarCliente;
import view.viewVentaTicket;
import view.viewVistaCliente;

/**
 *
 * @author ALEJO
 */
public class ControllerRegistrarCliente {

    private viewRegistrarCliente vrc;
    private viewVistaCliente vvc;
    private ModelCliente mc;
    boolean banvista = false;
    boolean banventa = false;
    private viewVentaTicket vistaventa;

//    private viewLogin vl;
    public ControllerRegistrarCliente() {
    }

    public ControllerRegistrarCliente(viewRegistrarCliente vrc, ModelCliente mc, viewVentaTicket vistaventa) {
        this.vrc = vrc;
        this.mc = mc;
        this.vistaventa=vistaventa;
        banventa=true;
        vrc.toFront();
        vrc.setVisible(true);
        banvista = false;
        System.out.println("ban= "+banventa);
    }

    public ControllerRegistrarCliente(viewRegistrarCliente vrc, ModelCliente mc) {
        this.vrc = vrc;
        this.mc = mc;
        vrc.toFront();
        vrc.setVisible(true);
        banvista = false;
    }

    public ControllerRegistrarCliente(viewRegistrarCliente vrc, viewVistaCliente vvc, ModelCliente mc) {
        this.vrc = vrc;
        this.vvc = vvc;
        this.mc = mc;
        vrc.toFront();
        vrc.setVisible(true);
        banvista = true;
    }

    public void iniciarControl() {
        vrc.getBtregistrar().addActionListener(l -> registrarCliente());
        vrc.getBtcancelar().addActionListener(l -> vrc.dispose());
    }

    public void abrirRegistro(int op) {
        String titulo;
        vrc.toFront();
        if (op == 1) {
            limpiarCampos();
            titulo = "Crear";
            vrc.setName("Registro");
            vrc.getBtregistrar().setText("REGISTRAR");
            vrc.setVisible(true);
            this.iniciarControl();
        } else {
            titulo = "Editar";
            System.out.println(titulo);
            if (llenarDatos()) {
                vrc.setName("Editar");
                vrc.getTxtcedula().setEditable(false);
                vrc.getBtregistrar().setText("ACTUALIZAR");
                vrc.setVisible(true);
                this.iniciarControl();
            }
        }
    }

    public void registrarCliente() {

        if (validar()) {
            String cedula = vrc.getTxtcedula().getText(),
                    nombre = vrc.getTxtnombre().getText(),
                    apellido = vrc.getTxtapellido().getText(),
                    correo = vrc.getTxtcorreo().getText(),
                    telefono = vrc.getTxttelefono().getText(),
                    direccion = vrc.getTxtdireccion().getText();
            Date fechaRegistro = java.sql.Date.valueOf(LocalDate.now());

            modelPersona persona = new modelPersona();
            persona.setCedula(cedula);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setCorreo(correo);
            persona.setTelefono(telefono);
            persona.setFechaRegistro(fechaRegistro);
            persona.setEstadoPer(true);

            ModelCliente cli = new ModelCliente();
            cli.setEstadoPer(true);
            cli.setCli_cedula(cedula);
            cli.setCli_direccion(direccion);
            cli.setCli_estado(true);
            cli.setFechaRegistro(fechaRegistro);

            if (vrc.getName().equals("Registro")) {
                int response = JOptionPane.showConfirmDialog(vrc, "¿Agregar cliente?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (persona.comprobarDuplicado(cedula)) {
                        if (persona.setPersona() && cli.setCliente()) {
                            JOptionPane.showMessageDialog(vrc, "Cliente agregado/a correctamente");
                            vrc.dispose();
                        } else {
                            JOptionPane.showMessageDialog(vrc, "No se pudo agregar al cliente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(vrc, "El cliente ya se encuentra registrado");
                    }

                }
            } else {
                //UPDATE
                int response = JOptionPane.showConfirmDialog(vrc, "¿Seguro que desea actualizar los datos del cliente?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (persona.updatePersona() && cli.updateCliente()) {//Grabamos
                        JOptionPane.showMessageDialog(vrc, "Cliente actualizado correctamente");
                        vrc.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vrc, "No se pudo actualizar a los datos del cliente");
                    }
                }
            }

        }
        if (banvista) {
            ControllerVistaCliente controlCli = new ControllerVistaCliente(vvc, mc);
            controlCli.cargarDatos(1);
        }
        if (banventa) {
            System.out.println("ia llegue");

            controllerVentaTicket controlventa = new controllerVentaTicket(vistaventa, mc, vrc.getTxtcedula().getText().trim());
//            controlventa.llenarDatos(vis);
        }
    }

    public void limpiarCampos() {
        vrc.getTxtcedula().setText("");
        vrc.getTxtnombre().setText("");
        vrc.getTxtapellido().setText("");
        vrc.getTxtdireccion().setText("");
        vrc.getTxtcorreo().setText("");
        vrc.getTxttelefono().setText("");
    }

    public boolean llenarDatos() {
        int fila = vvc.getjTblCliente().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vvc, "Seleccione un cliente a modificar");
            return false;
        } else {
            int id = Integer.parseInt(vvc.getjTblCliente().getValueAt(fila, 0).toString());
            List<Cliente> listap = mc.getClientes();
            listap.stream().forEach(cli -> {
                if (id == cli.getCli_id()) {
                    vrc.getTxtcedula().setText(cli.getCli_cedula());
                    vrc.getTxtnombre().setText(cli.getNombre());
                    vrc.getTxtapellido().setText(cli.getApellido());
                    vrc.getTxtcorreo().setText(cli.getCorreo());
                    vrc.getTxttelefono().setText(cli.getTelefono());
                    vrc.getTxtdireccion().setText(cli.getCli_direccion());
                }
            });
            return true;
        }
    }

    public boolean validar() {
        boolean ban = true;
        validaciones mivalidacion = new validaciones();
        //DNI
        if (!vrc.getTxtcedula().getText().isEmpty()) {
            if (!mivalidacion.validarCedula(vrc.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(vrc, "Cedula invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vrc, "Ingrese la cedula");
            ban = false;
        }
        //NOMBRE
        if (!vrc.getTxtnombre().getText().isEmpty()) {
            if (!mivalidacion.validarNombApeEspacios(vrc.getTxtnombre().getText())) {
                JOptionPane.showMessageDialog(vrc, "Nombre invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vrc, "Ingrese el nombre");
            ban = false;
        }
        //APELLIDO
        if (!vrc.getTxtapellido().getText().isEmpty()) {
            if (!mivalidacion.validarNombApeEspacios(vrc.getTxtapellido().getText())) {
                JOptionPane.showMessageDialog(vrc, "Apellido invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vrc, "Ingrese el Apellido");
            ban = false;
        }
        //TELEFONO
        if (!vrc.getTxttelefono().getText().isEmpty()) {
            if (!mivalidacion.validarTelefono(vrc.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(vrc, "Telefono invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vrc, "Ingrese el numero de telefono");
            ban = false;
        }
        //CORREO
        if (!vrc.getTxtcorreo().getText().isEmpty()) {
            if (!mivalidacion.validarCorreo(vrc.getTxtcorreo().getText())) {
                JOptionPane.showMessageDialog(vrc, "Correo invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vrc, "Ingrese un correo electronico");
            ban = false;
        }
        //DIRECCION
        if (!vrc.getTxtdireccion().getText().isEmpty()) {
            if (!mivalidacion.validarDireccion(vrc.getTxtdireccion().getText())) {
                JOptionPane.showMessageDialog(vrc, "Direccion invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vrc, "Ingrese una direccion valida");
            ban = false;
        }

        return ban;
    }
;
}
