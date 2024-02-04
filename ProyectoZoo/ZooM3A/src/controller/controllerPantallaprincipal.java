/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import model.Empleado;
import model.modelEmpleado;
import model.modelZoologo;
import model.modelProveedor;
import model.ModelCliente;
import model.ModelAlimento;
import model.ModelDieta;
import model.ModelHabitad;
import model.ModelTickets;
import model.modelLogin;
import model.ModelAnimal;
import model.ModelFactura;
import model.modelCuidador;
import view.viewActualizarTicket;
import view.viewConsultarFacturas;
import view.viewLogin;
import view.viewPantallaPrincipal;
import view.viewRegistrarEmpleado;
import view.viewRegistrarCliente;
import view.viewRegistroAlimento;
import view.viewRegistroHabitad;
import view.viewVistaEmpleados;
import view.viewVistaCliente;
import view.viewVistaProveedor;
import view.viewVistaAlimento;
import view.viewRegistrarProveedor;
import view.viewRegistroDieta;
import view.viewRegistroAnimal;
import view.viewVistaAnimal;
import view.viewVistaDieta;
import view.viewVistaHabitats;
import view.viewVistaTickets;
import view.viewVentaTicket;

/**
 *
 * @author Bryan
 */
public class controllerPantallaprincipal {

    private viewPantallaPrincipal vista;
    private String usuario;
    private String password;
    private String rol;

    public controllerPantallaprincipal() {
    }

    public controllerPantallaprincipal(viewPantallaPrincipal vista, String usuario, String password) {
        this.vista = vista;
        this.usuario = usuario;
        this.password = password;
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        cargarDatosEmpleado();
        asignarBotones();
        vista.setTitle("ZOOMANIA");
        vista.setIconImage(new ImageIcon(getClass().getResource("/imagenes/leon_JF.png")).getImage());
    }

    public void iniciaControl() {
        vista.getBtnCerrarSesion().addActionListener(l -> cerrarSesion());
        vista.getjMIagregarPersona().addActionListener(l -> registroEmpleado());
        vista.getjMIvistaEmpleado().addActionListener(l -> vistaEmpleado());
        vista.getjMIagregarProveedor().addActionListener(l -> registroProveedor());
        vista.getJMIvistaProveedor().addActionListener(l -> vistaProveedor());
        vista.getjMIagregarCliente().addActionListener(l -> registroCliente());
        vista.getJMIvistaCliente().addActionListener(l -> vistaCliente());
        vista.getjMIagregarAlimento().addActionListener(l -> registroAlimento());
        vista.getjMIcrudAlimento().addActionListener(l -> vistaAlimento());
        vista.getMIActualizarPrecio().addActionListener(l -> vistaActualizarTicket());
        vista.getjMIAgregarDieta().addActionListener(l -> registroDieta());
        vista.getjMIVisualizarDietas().addActionListener(l -> vistaDieta());
        vista.getjMIAgregarHabitat().addActionListener(l -> registroHabitat());
        vista.getjMIvisualizarPrecios().addActionListener(l -> viewVistaTickets());
        vista.getjMIVisualizarHabitat().addActionListener(l -> vistaHabitat());
        vista.getjMIagregarAnimal().addActionListener(l -> registroAnimal());
        vista.getjMIvisualizarAnimal().addActionListener(l -> vistaAnimal());
        vista.getMIventaTickets().addActionListener(l -> vistaVentaTicket());
        vista.getMIconsultaFacturas().addActionListener(l -> vistaFACTURA());
        ////BOTONES

    }

    //CARGAR DATOS
    public void cargarDatosEmpleado() {
        modelEmpleado modeloE = new modelEmpleado();
        List<Empleado> listaE;
        listaE = modeloE.getempleadoLogin(usuario, password);

        listaE.stream().forEach(emp -> {
            vista.getJlblNombrePP().setText(emp.getNombre());
            vista.getJlblrolPP().setText(emp.getApellido());//NOMBRE DEL ROL
            vista.getJlblCedulaPP().setText(emp.getCedula());
            Image foto = emp.getFoto();
            if (foto != null) {
                foto = foto.getScaledInstance(98, 106, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(foto);

                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setIcon(icono);
                vista.getJlblFotoPP().setIcon(icono);
            } else {
                ImageIcon iconoUsuario = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
//                ImageIcon iconoUsuario = new ImageIcon("src\\imagenes\\usuario.png");
                vista.getJlblFotoPP().setIcon(iconoUsuario);
            }
            rol = emp.getApellido();
        });
        System.out.println(rol);
    }

    public void asignarBotones() {
        switch (rol) {
            case "Gerente":
                //BOTONES LATERALES
                vista.getCrudAlimento().addActionListener(l -> vistaAlimento());
                vista.getCrudAnimal().addActionListener(l -> vistaAnimal());
                vista.getCrudClientes().addActionListener(l -> vistaCliente());
                vista.getCrudDieta().addActionListener(l -> vistaDieta());
                vista.getCrudPersonal().addActionListener(l -> vistaEmpleado());
                vista.getCrudProveedor().addActionListener(l -> vistaProveedor());
                vista.getCrudTicket().addActionListener(l -> vistaFACTURA());
                break;
            case "Cuidador":
                //LATERALES
                vista.getCrudAlimento().addActionListener(l -> vistaAlimento());
                vista.getCrudAnimal().addActionListener(l -> vistaAnimal());
                vista.getCrudDieta().addActionListener(l -> vistaDieta());
                vista.getCrudPersonal().setVisible(false);
                vista.getCrudPersonal().setEnabled(false);
                vista.getCrudTicket().setVisible(false);
                vista.getCrudTicket().setEnabled(false);
                vista.getCrudProveedor().setVisible(false);
                vista.getCrudProveedor().setEnabled(false);
                vista.getCrudClientes().setVisible(false);
                vista.getCrudClientes().setEnabled(false);
                //MENU
                vista.getMenuPersonal().setVisible(false);
                vista.getMenuPersonal().setEnabled(false);
                vista.getMenuTicket().setVisible(false);
                vista.getMenuTicket().setEnabled(false);
                vista.getMenuProveedor().setVisible(false);
                vista.getMenuProveedor().setEnabled(false);
                vista.getMenuClientes().setVisible(false);
                vista.getMenuClientes().setEnabled(false);
                vista.getMenuFactura().setVisible(false);
                vista.getMenuFactura().setEnabled(false);
                break;
            case "Zoologo":
                //LATERALES
                vista.getCrudAlimento().addActionListener(l -> vistaAlimento());
                vista.getCrudAnimal().addActionListener(l -> vistaAnimal());
                vista.getCrudDieta().addActionListener(l -> vistaDieta());
                vista.getCrudPersonal().setVisible(false);
                vista.getCrudPersonal().setEnabled(false);
                vista.getCrudTicket().setVisible(false);
                vista.getCrudTicket().setEnabled(false);
                vista.getCrudProveedor().setVisible(false);
                vista.getCrudProveedor().setEnabled(false);
                vista.getCrudClientes().setVisible(false);
                vista.getCrudClientes().setEnabled(false);
                //MENU
                vista.getMenuPersonal().setVisible(false);
                vista.getMenuPersonal().setEnabled(false);
                vista.getMenuTicket().setVisible(false);
                vista.getMenuTicket().setEnabled(false);
                vista.getMenuProveedor().setVisible(false);
                vista.getMenuProveedor().setEnabled(false);
                vista.getMenuClientes().setVisible(false);
                vista.getMenuClientes().setEnabled(false);
                vista.getMenuFactura().setVisible(false);
                vista.getMenuFactura().setEnabled(false);
                break;
            case "Secretaria":
                //BOTONES LATERALES
                vista.getCrudAlimento().addActionListener(l -> vistaAlimento());
                vista.getCrudAnimal().addActionListener(l -> vistaAnimal());
                vista.getCrudClientes().addActionListener(l -> vistaCliente());
                vista.getCrudDieta().addActionListener(l -> vistaDieta());
                vista.getCrudPersonal().addActionListener(l -> vistaEmpleado());
                vista.getCrudProveedor().addActionListener(l -> vistaProveedor());
                vista.getCrudTicket().addActionListener(l -> vistaVentaTicket());
                //BOTONES MENU
                vista.getMIActualizarPrecio().setVisible(false);
                vista.getMIActualizarPrecio().setEnabled(false);
                break;
            default:
        }
    }

    //CERRAR SESION
    public void cerrarSesion() {
        vista.dispose();
        modelLogin modeloL = new modelLogin();
        viewLogin vistaL = new viewLogin();
        controllerLogin controllerL = new controllerLogin(modeloL, vistaL);
        controllerL.inicialControl();

    }

    //////////////////////////////////////////////////////////////////////////////////////
    //EMPLEADOS
    public void registroEmpleado() {
//        vista.getjDPprincipal().removeAll();
        //Instancio las clases del modelo y la vista
        modelEmpleado modeloEmpleado = new modelEmpleado();
        viewRegistrarEmpleado vistaRegistroEmpleado = new viewRegistrarEmpleado();

        //Agragar vista al desktop pane
        vistaRegistroEmpleado.setName("Registro");
        vista.getjDPprincipal().add(vistaRegistroEmpleado);

        ControllerRegistroEmpleado controladorEmpleado = new ControllerRegistroEmpleado(modeloEmpleado, vistaRegistroEmpleado);
        controladorEmpleado.inicialControl();
    }

    public void vistaEmpleado() {
//        vista.getjDPprincipal().removeAll();
        //Instancio las clases del modelo y la vista
//        viewRegistrarEmpleado vistaRegistroEmpleado = new viewRegistrarEmpleado();
//        vistaRegistroEmpleado.setName("Registro");
//        vista.getjDPprincipal().add(vistaRegistroEmpleado);

        modelEmpleado modeloEmpleado = new modelEmpleado();
        viewVistaEmpleados vistaEmpleado = new viewVistaEmpleados();

        //Agragar vista al desktop pane        
        vista.getjDPprincipal().add(vistaEmpleado);

//        ControllerRegistroEmpleado controladorEmpleado = new ControllerRegistroEmpleado(modeloEmpleado,  vistaEmpleado,vista);
//        controladorEmpleado.inicialControl2();
        ControllerVistaEmpleado controllerVistaEmpleado = new ControllerVistaEmpleado(modeloEmpleado, vistaEmpleado, vista);
        controllerVistaEmpleado.inicialControl();
    }

    //PROVEEDORES
    public void registroProveedor() {
        //Instancio las clases del modelo y la vista
        modelProveedor mp = new modelProveedor();
        viewRegistrarProveedor vre = new viewRegistrarProveedor();

        //Agragar vista al desktop pane
        vre.setName("Registro");
        vista.getjDPprincipal().add(vre);
        ControllerRegistroProveedor cemp = new ControllerRegistroProveedor(mp, vre);
        cemp.inicialControl();
    }

    public void vistaProveedor() {
        modelProveedor modeloProv = new modelProveedor();
        viewVistaProveedor vistaProv = new viewVistaProveedor();

        //Agragar vista al desktop pane        
        vista.getjDPprincipal().add(vistaProv);

        ControllerVistaProveedor controllerVistaProv = new ControllerVistaProveedor(vista, vistaProv, modeloProv);
        controllerVistaProv.inicialControl();
    }

    //CLIENTES
    public void registroCliente() {
        //Instancio las clases del modelo y la vista        
        ModelCliente mc = new ModelCliente();
        viewRegistrarCliente vRc = new viewRegistrarCliente();

        //Agragar vista al desktop pane
        vRc.setName("Registro");
        vista.getjDPprincipal().add(vRc);
        ControllerRegistrarCliente ccli = new ControllerRegistrarCliente(vRc, mc);
        ccli.iniciarControl();
    }

    public void vistaCliente() {
        ModelCliente modeloCli = new ModelCliente();
        viewVistaCliente vistaCli = new viewVistaCliente();
//        viewVentaTicket vt = new viewVentaTicket();

        //Agragar vista al desktop pane                
        vista.getjDPprincipal().add(vistaCli);
        ControllerVistaCliente controllerVCli = new ControllerVistaCliente(vista, vistaCli, modeloCli);
        controllerVCli.inicialControl();
    }

    //ALIMENTO
    public void registroAlimento() {
        //Instancio las clases del modelo y la vista        
        ModelAlimento modelAli = new ModelAlimento();
        viewRegistroAlimento vistaRegAli = new viewRegistroAlimento();
        modelProveedor modeloProv = new modelProveedor();

        //Agragar vista al desktop pane
        vistaRegAli.setName("Registro");
        vista.getjDPprincipal().add(vistaRegAli);
        ControllerRegistrarAlimento controReglAli = new ControllerRegistrarAlimento(vistaRegAli, modelAli, modeloProv);
        controReglAli.iniciarControl();
    }

    public void vistaAlimento() {
        ModelAlimento modeloAli = new ModelAlimento();
        viewVistaAlimento vistaAli = new viewVistaAlimento();

        //Agragar vista al desktop pane                
        vista.getjDPprincipal().add(vistaAli);
        ControllerVistaAlimento controllerVali = new ControllerVistaAlimento(vista, vistaAli, modeloAli);
        controllerVali.inicialControl();
    }
//Habitad

    public void registroHabitat() {
        //Instancio las clases del modelo y la vista        
        ModelHabitad modelHab = new ModelHabitad();
        viewRegistroHabitad vistaRegHab = new viewRegistroHabitad();
        modelZoologo modeloZol = new modelZoologo();

        //Agragar vista al desktop pane
        vistaRegHab.setName("Registro");
        vista.getjDPprincipal().add(vistaRegHab);
        ControllerRegistrarHabitad controReglAli = new ControllerRegistrarHabitad(vistaRegHab, modelHab, modeloZol);
        controReglAli.iniciarControl();
        System.out.println(vista.getjDPprincipal().getComponentCount());
    }

    public void vistaHabitat() {
        ModelHabitad modelHab = new ModelHabitad();
        viewVistaHabitats vistaHab = new viewVistaHabitats();

        //Agragar vista al desktop pane                
        vista.getjDPprincipal().add(vistaHab);
        ControllerVistaHabitat controllerVhab = new ControllerVistaHabitat(vista, vistaHab, modelHab);
        controllerVhab.inicialControl();
    }

    ///DIETA
    public void registroDieta() {
        //Instancio las clases del modelo y la vista        
        ModelAlimento modelAli = new ModelAlimento();
        ModelAnimal modelAni = new ModelAnimal();
        viewRegistroDieta vistaRegDieta = new viewRegistroDieta();
        ModelDieta modeloDie = new ModelDieta();

        //Agragar vista al desktop pane
        vistaRegDieta.setName("Registro");
        vista.getjDPprincipal().add(vistaRegDieta);
        ControllerRegistrarDieta controReglAli = new ControllerRegistrarDieta(vistaRegDieta, modeloDie, modelAli, modelAni);
        controReglAli.iniciarControles();
    }

    public void vistaDieta() {
        ModelDieta modeloDie = new ModelDieta();
        viewVistaDieta vistaDie = new viewVistaDieta();

        //Agragar vista al desktop pane                
        vista.getjDPprincipal().add(vistaDie);
        ControllerVistaDieta controllerDie = new ControllerVistaDieta(vista, vistaDie, modeloDie);
        controllerDie.inicialControl();
    }

    ////////
    public void vistaActualizarTicket() {
        ModelTickets mt = new ModelTickets();
        viewActualizarTicket vat = new viewActualizarTicket();

        vista.getjDPprincipal().add(vat);
        controllerActualizarTickets ct = new controllerActualizarTickets(vat, mt);
        ct.iniciarControl();

    }
///TICKET

    public void viewVistaTickets() {

        ModelTickets mt = new ModelTickets();
        viewVistaTickets vvt = new viewVistaTickets();

        vista.getjDPprincipal().add(vvt);
        ControllerVistaTickets cvt = new ControllerVistaTickets(vvt, mt);
        cvt.iniciarControl();
    }

    ///DIETA
    public void registroAnimal() {
        //Instancio las clases del modelo y la vista        
        ModelAnimal modelAni = new ModelAnimal();
        viewRegistroAnimal vistaRegAnimal = new viewRegistroAnimal();
        ModelHabitad modeloHab = new ModelHabitad();
        modelCuidador modeloCui = new modelCuidador();

        //Agragar vista al desktop pane
        vistaRegAnimal.setName("Registro");
        vista.getjDPprincipal().add(vistaRegAnimal);
        ControllerRegistrarAnimal controReglAni = new ControllerRegistrarAnimal(modelAni, modeloHab, modeloCui, vistaRegAnimal);
        controReglAni.inicialControl();
    }

    public void vistaAnimal() {
        ModelAnimal modelAni = new ModelAnimal();
        viewVistaAnimal vistaAni = new viewVistaAnimal();
        ModelHabitad modeloHab = new ModelHabitad();
        modelCuidador modeloCui = new modelCuidador();

        //Agragar vista al desktop pane                
        vista.getjDPprincipal().add(vistaAni);
        ControllerVistaAnimal controViewAni = new ControllerVistaAnimal(vista, vistaAni, modelAni);
        controViewAni.inicialControl();
    }

    ///VENTA
    public void vistaVentaTicket() {
        ModelCliente modelcli = new ModelCliente();
        ModelTickets modelticket = new ModelTickets();
        viewVentaTicket vistaVenta = new viewVentaTicket();

        //Agragar vista al desktop pane                
        vista.getjDPprincipal().add(vistaVenta);
        controllerVentaTicket controllerVenta = new controllerVentaTicket(vista, vistaVenta, modelticket, modelcli);
        controllerVenta.iniciarControl();
    }

    //FACTURA
    public void vistaFACTURA() {
        ModelFactura modelFac = new ModelFactura();
        viewConsultarFacturas vistaConsultaF = new viewConsultarFacturas();

        //Agragar vista al desktop pane                
        vista.getjDPprincipal().add(vistaConsultaF);
        ControllerConsultaFacturas controConsultaFac = new ControllerConsultaFacturas(vistaConsultaF, vista, modelFac);
        controConsultaFac.inicialControl();
    }
}
