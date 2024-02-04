/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.modelEmpleado;
import view.viewVistaEmpleados;
import view.viewRegistrarEmpleado;
import model.modelPersona;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import model.modelCuidador;
import model.modelGerente;
import model.modelSecretaria;
import model.modelZoologo;
import model.rol;
import view.viewPantallaPrincipal;

/**
 *
 * @author ALEJO
 */
public class ControllerRegistroEmpleado {

    private viewPantallaPrincipal vistaP;
    private controllerPantallaprincipal controllerpp;
    private modelEmpleado modeloE;
    private modelPersona modeloP;
    private viewRegistrarEmpleado vista;
    private viewVistaEmpleados vistaE;
    private JFileChooser jfc;
    int i = 0;
    boolean banvista = false;
    DefaultTableModel estructuraTabla;
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    public ControllerRegistroEmpleado(modelEmpleado modelo, viewRegistrarEmpleado vista) {
        this.modeloE = modelo;
        this.vista = vista;
        desactivarDatosRol();
        cargarComboRol();
//        vista.setLo;
//        ((javax.swing.plaf.basic.BasicInternalFrameUI) vista.getUI()).setNorthPane(null);
        vista.toFront();
        vista.setVisible(true);
        banvista = false;
    }

    public ControllerRegistroEmpleado(modelEmpleado modeloE, viewRegistrarEmpleado vista, viewVistaEmpleados vistaE) {
        this.modeloE = modeloE;
        this.vistaE = vistaE;
        this.vista = vista;
        banvista = true;
        desactivarDatosRol();
        cargarComboRol();
//        vista.setLo;
//        ((javax.swing.plaf.basic.BasicInternalFrameUI) vista.getUI()).setNorthPane(null);
        vista.toFront();
        vista.setVisible(true);
    }

    public void inicialControl() {
        vista.getComborol().addActionListener(l -> activarDatosRol());
        vista.getBtagregarfoto().addActionListener(l -> examinarFoto());
        vista.getBtregistrar().addActionListener(l -> crearEditarPersona());
        vista.getBtcancelar().addActionListener(l -> vista.dispose());
    }

    public void abrirRegistro(int op) {
        vista.toFront();
        vista.getLblfoto().setIcon(null);
        String titulo;
//        cargarComboRol();
        if (op == 1) {
            limpiarCampos();
            titulo = "Crear";
            vista.setName("Registro");
            vista.getBtregistrar().setText("REGISTRAR");
            desactivarDatosRol();
            vista.setVisible(true);
            this.inicialControl();
//            abrirRegistroEmpleado();
        } else {
            titulo = "Editar";
            if (llenarDatos()) {
                vista.setName("Editar");
                vista.getTxtcedula().setEditable(false);
                vista.getBtregistrar().setText("ACTUALIZAR");
                desactivarDatosRol();
                vista.setVisible(true);
                this.inicialControl();
//                abrirRegistroEmpleado();
            }
        }
        activarDatosRol();
    }

    public void examinarFoto() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG,PNG y JPG", "jpeg", "png", "jpg");
        jfc = new JFileChooser();
        jfc.setFileFilter(filtro);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vista);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblfoto().getWidth(),
                        vista.getLblfoto().getHeight(),
                        Image.SCALE_DEFAULT);
                Icon icono = new ImageIcon(imagen);
                vista.getLblfoto().setIcon(icono);
                vista.getLblfoto().updateUI();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(vistaP, "El archivo de imagen esta corrupto","Ha ocurrido un error",2);
//                Logger.getLogger(ControllerRegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException n) {
                JOptionPane.showMessageDialog(vistaP, "El archivo de imagen esta corrupto","Ha ocurrido un error",2);
                
            }
        }
    }

    public void cargarComboRol() {
//        vista.getComborol().removeAllItems();
        List<rol> listaRol = modeloE.getroles();
        listaRol.stream().forEach(r -> {
            vista.getComborol().addItem(r.getNombre());
        });
    }

    public void desactivarCampos() {
        vista.getTxtcedula().setEditable(false);
    }

    public void abrirRegistroEmpleado() {
        desactivarDatosRol();
        vista.setVisible(true);
        this.inicialControl();
    }

    private void crearEditarPersona() {
        boolean ban = false;
        modelPersona modeloP = new modelPersona();
        int colorAux = vista.getLblfoto().getBackground().hashCode(),
                colorAux2 = 0;

        if (validar()) {

            //DatosPersona
            String cedula = vista.getTxtcedula().getText(),
                    nombre = vista.getTxtnombre().getText(),
                    apellido = vista.getTxtapellido().getText(),
                    correo = vista.getTxtcorreo().getText(),
                    telefono = vista.getTxttelefono().getText();
            Date fechaRegistro = java.sql.Date.valueOf(LocalDate.now());
            modelPersona persona = new modelPersona();
            persona.setCedula(cedula);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setCorreo(correo);
            persona.setTelefono(telefono);
            persona.setFechaRegistro(fechaRegistro);
            persona.setEstadoPer(true);
            //Empleado
            String usuario = vista.getTxtusuario().getText(),
                    contrasena = vista.getTxtcontra().getText(),
                    cedulaemp = vista.getTxtcedula().getText(),
                    genero = null;
            int rol = vista.getComborol().getSelectedIndex();
            Date date = vista.getCalendarFechanacimiento().getDate(); //vista es la interfaz, jDate el JDatechooser
            long d = date.getTime(); //guardamos en un long el tiempo
            java.sql.Date fechanacimiento = new java.sql.Date(d);// parseamos al formato del sql  
            if (vista.getBtmasculino().isSelected()) {
                genero = "Masculino";
            } else {
                if (vista.getBtfemenino().isSelected()) {
                    genero = "Femenino";
                } else {
                    JOptionPane.showMessageDialog(vista, "Elija un sexo");
                }
            }

            modelEmpleado empleado = new modelEmpleado();
            empleado.setFechanacimiento(fechanacimiento);
            empleado.setGenero(genero);
            empleado.setUsuario(usuario);
            empleado.setContraseña(contrasena);
            empleado.setCedula(cedulaemp);
            empleado.setRol(rol);
            empleado.setEstadoEmp(true);
            try {
                FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                int largo = (int) jfc.getSelectedFile().length();
                empleado.setImageFile(img);
                empleado.setTamano(largo);
                colorAux2 = vista.getLblfoto().getBackground().hashCode() + 2;

            } catch (IOException ex) {
                Logger.getLogger(ControllerRegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                colorAux2 = vista.getLblfoto().getBackground().hashCode();
            }

            if (vista.getName().equals("Registro")) {
                if (modeloP.comprobarDuplicado(vista.getTxtcedula().getText())) {
                    //INSERT
                    int response = JOptionPane.showConfirmDialog(vista, "¿Agregar persona?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {

                        if (colorAux != colorAux2) {
                            System.out.println("registro1");
                            if (persona.setPersona() && empleado.setFotoEmpleado()) {
                                System.out.println("CON FOTO");
                                ban = true;
                            }
                        } else {
                            if (persona.setPersona() && empleado.setEmpleado()) {
                                System.out.println("SIN FOTO");
                                ban = true;
                            }
                        }

                        if (ban && registrarRoles(cedulaemp)) {
                            JOptionPane.showMessageDialog(vista, "Empleado agregado/a correctamente");
                            limpiarCampos();
                            vista.dispose();
                        } else {
                            JOptionPane.showMessageDialog(vista, "No se pudo agregar al empleado");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "La persona ya se encuentra registrada");
                }
            } else {
                //UPDATE
                int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea actualizar a la persona?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {

                    if (colorAux != colorAux2) {
                        System.out.println("registro1");
                        if (empleado.updateFotoEmpleado() && persona.updatePersona()) {
                            ban = true;
                        }
                    } else {
                        System.out.println("registro2");
                        if (empleado.updateEmpleado() && persona.updatePersona()) {
                            ban = true;
                        }
                    }

                    if (ban) {
                        ban = false;
                        int opc = vista.getComborol().getSelectedIndex();
                        switch (opc) {
                            case 1:
                                //Gerente
                                String titulo = vista.getTxtTitulo().getText();
                                modelGerente gerente = new modelGerente();
                                gerente.setIdEmpleado(empleado.obtenerIdEmp(cedulaemp));
                                gerente.setTitulo(titulo);
                                if (gerente.updateGerente(cedulaemp)) {
                                    ban = true;
                                }
                                break;
                            case 2:
                                int experiencia = (int) vista.getjSexperiencia().getValue();
                                modelSecretaria secretaria = new modelSecretaria();
                                secretaria.setIdEmpleado(empleado.obtenerIdEmp(cedulaemp));
                                secretaria.setExperiencia(experiencia);
                                if (secretaria.updateSecretaria(cedulaemp)) {
                                    ban = true;
                                }
                                break;
                            case 3:
                                //Zoologo
                                String rama = vista.getComborama().getSelectedItem().toString();
                                modelZoologo zoologo = new modelZoologo();
                                zoologo.setIdEmpleadoZoo(empleado.obtenerIdEmp(cedulaemp));
                                zoologo.setRama(rama);
                                if (zoologo.updateZoologo(cedulaemp)) {
                                    ban = true;
                                }
                                break;
                            case 4:
                                String tipoSangre = vista.getCombosangre().getSelectedItem().toString();
                                modelCuidador cuidador = new modelCuidador();
                                cuidador.setIdEmpleado(empleado.obtenerIdEmp(cedulaemp));
                                cuidador.setTipoSangre(tipoSangre);
                                if (cuidador.updateCuidador(cedulaemp)) {
                                    ban = true;
                                }
                                break;
                        }
                        if (ban) {
                            eliminarRoles(cedulaemp);
                            registrarRoles(cedulaemp);
                        }
                    }
                    if (ban) {
                        JOptionPane.showMessageDialog(vista, "Empleado actualizado/a correctamente");
                        limpiarCampos();
                        vista.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vista, "No se pudo actualizar al empleado");
                    }
                }
            }
            if (banvista) {
                ControllerVistaEmpleado controlEmp = new ControllerVistaEmpleado(modeloE, vistaE);
                controlEmp.cargarDatos(1);
                System.out.println("hola");
            }

        }
    }

    public boolean registrarRoles(String cedulaemp) {
        modelEmpleado empleado = new modelEmpleado();

        boolean ban = false;
        int opc = vista.getComborol().getSelectedIndex();
        switch (opc) {
            case 1:
                //Gerente
                String titulo = vista.getTxtTitulo().getText();
                modelGerente gerente = new modelGerente();
                gerente.setIdEmpleado(empleado.obtenerIdEmp(cedulaemp));
                gerente.setTitulo(titulo);
                gerente.setEstadoGer(true);
                if (gerente.setGerente()) {
                    ban = true;
//                                    JOptionPane.showMessageDialog(vista, "Empleado agregado/a correctamente");
                }

                break;
            case 2:
                //SECRETARIA
                int experiencia = (int) vista.getjSexperiencia().getValue();
                modelSecretaria secretaria = new modelSecretaria();
                secretaria.setIdEmpleado(empleado.obtenerIdEmp(cedulaemp));
                secretaria.setExperiencia(experiencia);
                secretaria.setEstadoSec(true);
                if (secretaria.setSecretaria()) {
                    ban = true;
//                                    JOptionPane.showMessageDialog(vista, "Empleado agregado/a correctamente");
                }
                break;
            case 3:
                //Zoologo
                String rama = vista.getComborama().getSelectedItem().toString();
                modelZoologo zoologo = new modelZoologo();
                zoologo.setIdEmpleadoZoo(empleado.obtenerIdEmp(cedulaemp));
                zoologo.setRama(rama);
                zoologo.setEstadoZol(true);
                if (zoologo.setZoologo()) {
                    ban = true;
//                                    JOptionPane.showMessageDialog(vista, "Empleado agregado/a correctamente");
                }
                break;
            case 4:
                String tipoSangre = vista.getCombosangre().getSelectedItem().toString();
                modelCuidador cuidador = new modelCuidador();
                cuidador.setIdEmpleado(empleado.obtenerIdEmp(cedulaemp));
                cuidador.setTipoSangre(tipoSangre);
                cuidador.setEstadoCui(true);
                if (cuidador.setCuidador()) {
                    ban = true;
//                                    JOptionPane.showMessageDialog(vista, "Empleado agregado/a correctamente");
                }
                break;
        }
        return ban;
    }

    public boolean llenarDatos() {
        int fila = vistaE.getjTblEmpleado().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione la persona a modificar");
            return false;
        } else {

            int id = Integer.parseInt(vistaE.getjTblEmpleado().getValueAt(fila, 0).toString());
            List<Empleado> listap = modeloE.getempleado();
            listap.stream().forEach(emp -> {
                if (id == emp.getIdEmp()) {
                    vista.getTxtcedula().setText(emp.getCedula());
                    vista.getTxtnombre().setText(emp.getNombre());
                    vista.getTxtapellido().setText(emp.getApellido());
                    vista.getTxttelefono().setText(emp.getTelefono());
                    vista.getTxtcorreo().setText(emp.getCorreo());
                    if (emp.getGenero().equalsIgnoreCase("Masculino")) {
                        vista.getBtmasculino().setSelected(true);
                    }
                    if (emp.getGenero().equalsIgnoreCase("Femenino")) {
                        vista.getBtfemenino().setSelected(true);
                    }
                    vista.getCalendarFechanacimiento().setDate(emp.getFechanacimiento());
                    vista.getTxtusuario().setText(emp.getUsuario());
                    vista.getTxtcontra().setText(emp.getContraseña());
                    vista.getTxtconfirmacontra().setText(emp.getContraseña());
                    Image foto = emp.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(94, 101, Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        dtcr.setIcon(icono);
                        vista.getLblfoto().setIcon(icono);
                    } else {
                        vista.getLblfoto().setIcon(null);
                    }

                    String opc = vistaE.getjTblEmpleado().getValueAt(fila, 8).toString();
//                    System.out.println(opc + "lllllll");
                    switch (opc) {
                        case "Gerente":
                            //Gerente
                            modelGerente me = new modelGerente();
                            vista.getComborol().setSelectedIndex(1);
                            vista.getTxtTitulo().setText(me.obtenerDatosRol(id));
                            break;
                        case "Secretaria":
                            //Secretaria
                            vista.getComborol().setSelectedIndex(2);
                            modelSecretaria ms = new modelSecretaria();
                            vista.getjSexperiencia().setValue(ms.obtenerDatosRol(id));
                            break;
                        case "Zoologo":
                            //Zoologo
                            vista.getComborol().setSelectedIndex(3);

                            modelZoologo mz = new modelZoologo();
                            for (int j = 0; j < vista.getComborama().getItemCount(); j++) {
                                if (vista.getComborama().getItemAt(j).equalsIgnoreCase(mz.obtenerDatosRol(id))) {
                                    vista.getComborama().setSelectedIndex(j);
                                }
                            }
                            break;
                        case "Cuidador":
                            //Cuidador
                            vista.getComborol().setSelectedIndex(4);
                            modelCuidador mc = new modelCuidador();
                            for (int j = 0; j < vista.getCombosangre().getItemCount(); j++) {
                                if (vista.getCombosangre().getItemAt(j).equalsIgnoreCase(mc.obtenerDatosRol(id))) {
                                    vista.getCombosangre().setSelectedIndex(j);
//                                    vista.getCombosangre().setSelectedItem(mc.obtenerDatosRol(id));
                                }
                            }
                            break;
                    }
                }

            });
//            vistaE.dispose();

            return true;
        }

    }

    public void desactivarDatosRol() {
        vista.getjProles().setVisible(false);
        vista.getjPcuidador().setVisible(false);
        vista.getjPgerente().setVisible(false);
        vista.getjPzoologo().setVisible(false);
        vista.getjPzsecretaria().setVisible(false);
    }

    public void activarDatosRol() {
        desactivarDatosRol();
        vista.getjProles().setVisible(true);
        int opc = vista.getComborol().getSelectedIndex();
        switch (opc) {
            case 0 ->
                vista.getjProles().setVisible(false);
            case 1 ->
                vista.getjPgerente().setVisible(true);
            case 2 ->
                vista.getjPzsecretaria().setVisible(true);
            case 3 ->
                vista.getjPzoologo().setVisible(true);
            case 4 ->
                vista.getjPcuidador().setVisible(true);
        }
    }
//
//    public void prueba() {
//        LocalDate fechaHoy = LocalDate.now();//fecha actual
//
//        Date date = vista.getCalendarFechanacimiento().getDate();//fecha naciemiento
//
//        Calendar calendar = Calendar.getInstance();//creamos una intancia calendar
//        calendar.setTime(date);//asignamos nuestra fecha
//        int anio = calendar.get(Calendar.YEAR),
//                mes = calendar.get(Calendar.MONTH) + 1,
//                dia = calendar.get(Calendar.DAY_OF_MONTH);
//        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia); // transformamos a un LocalDate
//
//        Period periodo = Period.between(fechaNacimiento, fechaHoy);// Calculamos la edad
//
//        if (periodo.getYears() < 18) {
//            System.out.println("es menor de edad");
//        } else {
//            System.out.println("LEGAL");
//        }
//    }

    public boolean validar() {
        boolean ban = true;

        validaciones mivalidacion = new validaciones();
        //DNI
        if (!vista.getTxtcedula().getText().isEmpty()) {
            if (!mivalidacion.validarCedula(vista.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(vista, "Cedula invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese la cedula");
            ban = false;
        }
        //NOMBRE
        if (!vista.getTxtnombre().getText().isEmpty()) {
            if (!mivalidacion.validarNombApeEspacios(vista.getTxtnombre().getText())) {
                JOptionPane.showMessageDialog(vista, "Nombre invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese el nombre");
            ban = false;
        }
        //APELLIDO
        if (!vista.getTxtapellido().getText().isEmpty()) {
            if (!mivalidacion.validarNombApeEspacios(vista.getTxtapellido().getText())) {
                JOptionPane.showMessageDialog(vista, "Apellido invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese el Apellido");
            ban = false;
        }
        //TELEFONO
        if (!vista.getTxttelefono().getText().isEmpty()) {
            if (!mivalidacion.validarTelefono(vista.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(vista, "Telefono invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese el numero de telefono");
            ban = false;
        }
        //CORREO
        if (!vista.getTxtcorreo().getText().isEmpty()) {
            if (!mivalidacion.validarCorreo(vista.getTxtcorreo().getText())) {
                JOptionPane.showMessageDialog(vista, "Correo invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese un correo electronico");
            ban = false;
        }
        //GENERO
        if (!vista.getBtmasculino().isSelected() && !vista.getBtfemenino().isSelected()) {
            ban = false;
            JOptionPane.showMessageDialog(vista, "Seleccione un genero");
        }
        //FECHANACIMIENTO
        if (vista.getCalendarFechanacimiento().getDate() != null) {
            if (!mivalidacion.validarMayorEdad(vista.getCalendarFechanacimiento().getDate())) {
                JOptionPane.showMessageDialog(vista, "No se puede registrar un menor de edad");
                ban = false;
            }
        } else {
            ban = false;
            JOptionPane.showMessageDialog(vista, "Ingrese la fecha de nacimiento");
        }
        //ROL
        if (vista.getComborol().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vista, "Seleccione el rol");
            ban = false;
        }
        //USUARIO
        if (!vista.getTxtusuario().getText().isEmpty()) {
            if (!mivalidacion.validarUsuario(vista.getTxtusuario().getText())) {
                JOptionPane.showMessageDialog(vista, "Usuario invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese un usuario");
            ban = false;
        }
        //CONTRASEÑA
        if (!vista.getTxtcontra().getText().isEmpty()) {
            if (mivalidacion.validarContrasena(vista.getTxtcontra().getText())) {
                if (!vista.getTxtconfirmacontra().getText().isEmpty()) {
                    if (!vista.getTxtcontra().getText().equals(vista.getTxtconfirmacontra().getText())) {
                        JOptionPane.showMessageDialog(vista, "La contraseña de confirmacion no coincide");
                        ban = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "Confirmar contraseña");
                    ban = false;
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Contraseñá invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese su contraseña");
            ban = false;
        }
        //DATOS ROL
        int opc = vista.getComborol().getSelectedIndex();
        switch (opc) {
            case 1:
                //TITULO
                if (!vista.getTxtTitulo().getText().isEmpty()) {
                    if (!mivalidacion.validarNombApeEspacios(vista.getTxtTitulo().getText())) {
                        JOptionPane.showMessageDialog(vista, "titulo invalida");
                        ban = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "Ingrese el titulo");
                    ban = false;
                }
                break;
            case 2:
                //EXPERIENCIA
                if ((Integer) vista.getjSexperiencia().getValue() == 0) {
                    JOptionPane.showMessageDialog(vista, "Ingrese los años de experiencia");
                    ban = false;
                }
                break;
            case 3:
                //RAMA
                if (vista.getComborama().getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(vista, "Seleccione la rama");
                    ban = false;
                }
                break;
            case 4:
                //TIPOSANGRE
                if (vista.getCombosangre().getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(vista, "Seleccione la rama");
                    ban = false;
                }
                break;
        }
        return ban;
    }

    public boolean eliminarRoles(String cedulaemp) {
        modelEmpleado empleado = new modelEmpleado();

        boolean ban = false;
//        int opc = vista.getComborol().getSelectedIndex();
        for (int j = 0; j <= 4; j++) {
            switch (j) {
                case 1:
                    //Gerente
                    modelGerente gerente = new modelGerente();
                    gerente.deleteGerente(empleado.obtenerIdEmp(cedulaemp));
                    break;
                case 2:
                    //SECRETARIA
                    modelSecretaria secretaria = new modelSecretaria();
                    secretaria.deleteSecretaria(empleado.obtenerIdEmp(cedulaemp));
                    break;
                case 3:
                    //Zoologo
                    modelZoologo zoologo = new modelZoologo();
                    zoologo.deleteZoologo(empleado.obtenerIdEmp(cedulaemp));
                    break;
                case 4:
                    modelCuidador cuidador = new modelCuidador();
                    cuidador.deleteCuidador(empleado.obtenerIdEmp(cedulaemp));
                    break;
            }
        }

        return ban;
    }

    public void limpiarCampos() {
        vista.getTxtcedula().setText("");
        vista.getTxtnombre().setText("");
        vista.getTxtapellido().setText("");
        vista.getTxttelefono().setText("");
        vista.getTxtcorreo().setText("");
        vista.getBtmasculino().setSelected(false);
        vista.getBtfemenino().setSelected(false);
        vista.getCalendarFechanacimiento().setDate(null);

        vista.getTxtusuario().setText("");
        vista.getTxtcontra().setText("");
        vista.getTxtconfirmacontra().setText("");
        vista.getTxtTitulo().setText("");

        vista.getLblfoto().setIcon(null);
        vista.getComborol().setSelectedIndex(0);
        vista.getComborama().setSelectedIndex(0);
        vista.getCombosangre().setSelectedIndex(0);
        vista.getjSexperiencia().setValue(0);

    }
}
