/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Animales;
import model.Cuidador;
import model.Habitat;
import model.modelCuidador;
import model.ModelHabitad;
import model.ModelAnimal;
import view.viewPantallaPrincipal;
import view.viewRegistroAnimal;
import view.viewVistaAnimal;

/**
 *
 * @author GRUPITO
 */
public class ControllerRegistrarAnimal {

    private viewPantallaPrincipal vistaP;
    private controllerPantallaprincipal controllerpp;
    private ModelAnimal modeloAni;
    private ModelHabitad modeloHab;
    private modelCuidador modeloCui;
    private viewRegistroAnimal vistaRegAni;
    private viewVistaAnimal vistaVani;
    private JFileChooser jfc;
    int i = 0;
    boolean banvista = false;
    DefaultTableModel estructuraTabla;
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    public ControllerRegistrarAnimal(ModelAnimal modeloAni, ModelHabitad modeloHab, modelCuidador modeloCui, viewRegistroAnimal vistaRegAni, viewVistaAnimal vistaVani) {
        this.modeloAni = modeloAni;
        this.modeloHab = modeloHab;
        this.modeloCui = modeloCui;
        this.vistaRegAni = vistaRegAni;
        this.vistaVani = vistaVani;
        vistaRegAni.toFront();
        vistaRegAni.getTxtOtraEspecie().setEditable(false);
        vistaRegAni.setVisible(true);
        banvista = true;
    }

    public ControllerRegistrarAnimal(ModelAnimal modeloAni, ModelHabitad modeloHab, modelCuidador modeloCui, viewRegistroAnimal vistaRegAni) {
        this.modeloAni = modeloAni;
        this.modeloHab = modeloHab;
        this.modeloCui = modeloCui;
        this.vistaRegAni = vistaRegAni;
        vistaRegAni.toFront();
        vistaRegAni.getTxtOtraEspecie().setEditable(false);
        vistaRegAni.setVisible(true);
        banvista = false;
    }

    public void inicialControl() {
        vistaRegAni.getComboEspecie().addActionListener(l -> activarTxtOtraEspecie());
        vistaRegAni.getBtnExaminarFoto().addActionListener(l -> examinarFoto());
        vistaRegAni.getBtnAgregar().addActionListener(l -> registrarActualizar());
        vistaRegAni.getBtnCancelar().addActionListener(l -> vistaRegAni.dispose());
        vistaRegAni.getBtnSeleccionarCuidador().addActionListener(l -> abrirDlgCuidador());
        vistaRegAni.getBtnSeleccionarHabitat().addActionListener(l -> abrirDlgHabitat());
        vistaRegAni.getBtnseleccionardlgCui().addActionListener(l -> llenarDatosCuidador());
        vistaRegAni.getBtnseleccionardlgHab().addActionListener(l -> llenarDatosHabitat());
    }

    KeyListener busquedaIncrenHab = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            cargarDatosDlg(2);
        }
    };

    KeyListener busquedaIncrenCui = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            cargarDatosDlg(2);
        }
    };

    public void activarTxtOtraEspecie() {
        if (vistaRegAni.getComboEspecie().getSelectedIndex() != vistaRegAni.getComboEspecie().getItemCount() - 1) {
            vistaRegAni.getTxtOtraEspecie().setText("");
            vistaRegAni.getTxtOtraEspecie().setEditable(false);
        } else {
            vistaRegAni.getTxtOtraEspecie().setEditable(true);
        }
    }

    public void abrirRegistro(int op) {
        vistaRegAni.toFront();
        vistaRegAni.getLblFotoAnimal().setIcon(null);
        String titulo;
//        cargarComboRol();
        if (op == 1) {
            limpiarCampos();
            titulo = "Crear";
            vistaRegAni.setName("Registro");
            vistaRegAni.getBtnAgregar().setText("REGISTRAR");
            vistaRegAni.setVisible(true);
            this.inicialControl();
//            abrirRegistroEmpleado();
        } else {
            titulo = "Editar";
            if (llenarDatos()) {
                vistaRegAni.setName("Editar");
                vistaRegAni.getBtnAgregar().setText("ACTUALIZAR");
                vistaRegAni.setVisible(true);
                this.inicialControl();
//                abrirRegistroEmpleado();
            }
        }
    }

    public void examinarFoto() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG,PNG y JPG", "jpeg","png","jpg");
        jfc = new JFileChooser();
        jfc.setFileFilter(filtro);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vistaRegAni);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vistaRegAni.getLblFotoAnimal().getWidth(),
                        vistaRegAni.getLblFotoAnimal().getHeight(),
                        Image.SCALE_DEFAULT);
                Icon icono = new ImageIcon(imagen);
                vistaRegAni.getLblFotoAnimal().setIcon(icono);
                vistaRegAni.getLblFotoAnimal().updateUI();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(vistaP, "El archivo de imagen esta corrupto","Ha ocurrido un error",2);
//                Logger.getLogger(ControllerRegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException n) {
                JOptionPane.showMessageDialog(vistaP, "El archivo de imagen esta corrupto","Ha ocurrido un error",2);
            }
        }
    }

    public void registrarActualizar() {
        boolean ban = false;

        validaciones mivalidacion = new validaciones();

        if (validar()) {
            //ALIMENTO
            String nombre = vistaRegAni.getTxtnombreanimal().getText(),
                    genero = "",
                    especie = vistaRegAni.getComboEspecie().getSelectedItem().toString();
            if (vistaRegAni.getBtnmacho().isSelected()) {
                genero = "Macho";
            } else {
                if (vistaRegAni.getBtnhembra().isSelected()) {
                    genero = "Hembra";
                } else {
                    JOptionPane.showMessageDialog(vistaRegAni, "Seleccione el genero del animal");
                }
            }

            if (vistaRegAni.getComboEspecie().getSelectedIndex() == vistaRegAni.getComboEspecie().getItemCount() - 1) {
                especie = vistaRegAni.getTxtOtraEspecie().getText();
            } else {
                especie = vistaRegAni.getComboEspecie().getSelectedItem().toString();
            }
            Date fechaRegistro = java.sql.Date.valueOf(LocalDate.now());

            Date fechaNacimiento = vistaRegAni.getCalendarNacimiento().getDate(); //vista es la interfaz, jDate el JDatechooser
            long d = fechaNacimiento.getTime(); //guardamos en un long el tiempo
            java.sql.Date fechanacimientoSQL = new java.sql.Date(d);// parseamos al formato del sql  

            int idCuidador = Integer.parseInt(vistaRegAni.getTxtidCuidadorNoborrar().getText()),
                    idHabitat = Integer.parseInt(vistaRegAni.getTxtidHabitatNoborrar().getText());
            int colorAux = vistaRegAni.getLblFotoAnimal().getBackground().hashCode(),
                    colorAux2 = 0;

            ModelAnimal animal = new ModelAnimal();
            animal.setNombreAnimal(nombre);
            animal.setGeneroAnimal(genero);
            animal.setEspecieAnimal(especie);
            animal.setFecha_ingresoAnimal(fechaRegistro);
            animal.setFecha_nacimientoAnimal(fechanacimientoSQL);
            animal.setEstadoAnimal(true);
            animal.setIdcuidadorAnimal(idCuidador);
            animal.setIdhabitadAnimal(idHabitat);
            try {
                FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                int largo = (int) jfc.getSelectedFile().length();
                animal.setImageFile(img);
                animal.setTamano(largo);
                colorAux2 = vistaRegAni.getLblFotoAnimal().getBackground().hashCode() + 2;

            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(ControllerRegistroEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                colorAux2 = vistaRegAni.getLblFotoAnimal().getBackground().hashCode();
            }

            if (vistaRegAni.getName().equals("Registro")) {
                int response = JOptionPane.showConfirmDialog(vistaRegAni, "¿Agregar Animal?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {

                    if (colorAux != colorAux2) {
                        System.out.println("registro1");
                        if (animal.setFotoAnimal()) {
                            System.out.println("CON FOTO");
                            ban = true;
                        }
                    } else {
                        if (animal.setAnimal()) {
                            System.out.println("SIN FOTO");
                            ban = true;
                        }
                    }

//                    if (alimento.comprobarDuplicado(cedula)) {
                    if (ban) {
                        JOptionPane.showMessageDialog(vistaRegAni, "Animal agregado/a correctamente");
                        vistaRegAni.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegAni, "No se pudo agregar el Animal");
                    }
                }
            } else {
                //UPDATE
                int id = Integer.parseInt(vistaRegAni.getTxtidAnimalNoborrar().getText());
                System.out.println("animal id= " + vistaRegAni.getTxtidAnimalNoborrar().getText());
                animal.setIdAnimal(id);
                int response = JOptionPane.showConfirmDialog(vistaRegAni, "¿Seguro que desea actualizar los datos del animal?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (colorAux != colorAux2) {
                        System.out.println("registro1");
                        if (animal.updateFotoAnimal()) {
                            System.out.println("CON FOTO");
                            ban = true;
                        }
                    } else {
                        if (animal.updateAnimal()) {
                            System.out.println("SIN FOTO");
                            ban = true;
                        }
                    }
                    if (ban) {//Grabamos
                        JOptionPane.showMessageDialog(vistaRegAni, "Animal actualizado correctamente");
                        vistaRegAni.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegAni, "No se pudo actualizar a los datos del animal");
                    }
                }

                if (banvista) {
                    ControllerVistaAnimal controlAni = new ControllerVistaAnimal(vistaVani, modeloAni);
                    controlAni.cargarDatos(1);
                }
//            
            }
        }
    }

    public boolean llenarDatos() {
        int fila = vistaVani.getjTblAnimal().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaVani, "Seleccione un animal a modificar");
            return false;
        } else {
            int id = Integer.parseInt(vistaVani.getjTblAnimal().getValueAt(fila, 0).toString());
            System.out.println("llenar= " + id);
            List<Animales> listap = modeloAni.getAnimal();
            listap.stream().forEach(ani -> {
                if (id == ani.getIdAnimal()) {
                    vistaRegAni.getTxtidAnimalNoborrar().setText(String.valueOf(ani.getIdAnimal()));
                    vistaRegAni.getTxtnombreanimal().setText(ani.getNombreAnimal());
                    if (ani.getGeneroAnimal().equalsIgnoreCase("Macho")) {
                        vistaRegAni.getBtnmacho().setSelected(true);
                    }
                    if (ani.getGeneroAnimal().equalsIgnoreCase("Hembra")) {
                        vistaRegAni.getBtnhembra().setSelected(true);
                    }
                    //CARGAR COMBO ESPECIE
                    for (int j = 0; j < vistaRegAni.getComboEspecie().getItemCount(); j++) {
                        if (vistaRegAni.getComboEspecie().getItemAt(j).equalsIgnoreCase(ani.getEspecieAnimal())) {
                            vistaRegAni.getComboEspecie().setSelectedIndex(j);
                        }
                    }
                    if (vistaRegAni.getComboEspecie().getSelectedIndex() == 0) {
                        vistaRegAni.getComboEspecie().setSelectedIndex(vistaRegAni.getComboEspecie().getItemCount() - 1);
                        vistaRegAni.getTxtOtraEspecie().setText(ani.getEspecieAnimal());
                    }
                    /////
                    vistaRegAni.getCalendarNacimiento().setDate(ani.getFecha_nacimientoAnimal());
                    //CUIDADOR
                    vistaRegAni.getTxtidCuidadorNoborrar().setText(String.valueOf(ani.getIdcuidadorAnimal()));
                    vistaRegAni.getTxtNombreCuidador().setText(ani.getNombreCuidador());
                    vistaRegAni.getTxtTipoSangre().setText(ani.getTiposangreCuidador());
                    //ANIMAL
                    vistaRegAni.getTxtidHabitatNoborrar().setText(String.valueOf(ani.getIdhabitadAnimal()));
                    vistaRegAni.getTxtTipoHabitat().setText(ani.getTipoHabitat());
                    vistaRegAni.getTxtUbicacion().setText(ani.getUbicacionHabitat());

                    Image foto = ani.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(94, 101, Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        dtcr.setIcon(icono);
                        vistaRegAni.getLblFotoAnimal().setIcon(icono);
                    } else {
                        vistaRegAni.getLblFotoAnimal().setIcon(null);
                    }

                }
            });
            return true;
        }
    }

    public boolean validar() {
        boolean ban = true;

        validaciones mivalidacion = new validaciones();

        //NOMBRE
        if (!vistaRegAni.getTxtnombreanimal().getText().isEmpty()) {
            if (!mivalidacion.validarNombApeEspacios(vistaRegAni.getTxtnombreanimal().getText())) {
                JOptionPane.showMessageDialog(vistaRegAni, "Nombre invalido");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vistaRegAni, "Ingrese el nombre");
            ban = false;
        }
        //GENERO
        if (!vistaRegAni.getBtnhembra().isSelected() && !vistaRegAni.getBtnmacho().isSelected()) {
            ban = false;
            JOptionPane.showMessageDialog(vistaRegAni, "Seleccione un genero");
        }
        //FECHANACIMIENTO
        if (vistaRegAni.getCalendarNacimiento().getDate() == null) {
            JOptionPane.showMessageDialog(vistaRegAni, "Ingrese la fecha de naciemiento");
            ban = false;
        }
        //ESPECIE
        if (vistaRegAni.getComboEspecie().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vistaRegAni, "Seleccione la especie del animal");
            ban = false;
        }
        //Cuidador
        if (vistaRegAni.getTxtNombreCuidador().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegAni, "Seleccione el cuidador");
            ban = false;
        }
        //Habitat
        if (vistaRegAni.getTxtTipoHabitat().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegAni, "Seleccione el habitad");
            ban = false;
        }
        return ban;
    }

    public void limpiarCampos() {
        vistaRegAni.getTxtnombreanimal().setText("");
        vistaRegAni.getButtonGroupGenero().clearSelection();
        vistaRegAni.getComboEspecie().setSelectedIndex(0);
        vistaRegAni.getCalendarNacimiento().setDate(null);

        vistaRegAni.getTxtidAnimalNoborrar().setText("");
        vistaRegAni.getTxtidCuidadorNoborrar().setText("");
        vistaRegAni.getTxtidHabitatNoborrar().setText("");

        vistaRegAni.getTxtNombreCuidador().setText("");
        vistaRegAni.getTxtTipoSangre().setText("");
        vistaRegAni.getTxtTipoHabitat().setText("");
        vistaRegAni.getTxtUbicacion().setText("");

        vistaRegAni.getLblFotoAnimal().setIcon(null);
    }

    public void abrirDlgCuidador() {
        vistaRegAni.getjDlgCuidador().setLocationRelativeTo(vistaRegAni);
        vistaRegAni.getjDlgCuidador().setVisible(true);
        cargarDatosDlgCuidador(1);
    }

    public void cargarDatosDlgCuidador(int opc) {

        vistaRegAni.getTabladlgCuidador().setRowHeight(25);
        estructuraTabla = (DefaultTableModel) vistaRegAni.getTabladlgCuidador().getModel();
        estructuraTabla.setRowCount(0);

        List<Cuidador> listaCui;
//        if (opc == 1) {
//            listaProv = modeloProv.getProveedor();
//        } else {
        String busqueda = vistaRegAni.getTxtbuscardlgCui().getText().toLowerCase().trim();
        listaCui = modeloCui.busquedaincremental(busqueda);
//        }
        System.out.println("listacuidador="+listaCui.size());
        i = 0;
        listaCui.stream().sorted((x, y)
                -> x.getNombre().compareToIgnoreCase(y.getNombre())).forEach(emp -> {
            estructuraTabla.addRow(new Object[listaCui.size()]);
            vistaRegAni.getTabladlgCuidador().setValueAt(emp.getIdCuidador(), i, 0);
            vistaRegAni.getTabladlgCuidador().setValueAt(emp.getNombre(), i, 1);
            vistaRegAni.getTabladlgCuidador().setValueAt(emp.getTipoSangre(), i, 2);
            i++;
        });
    }

    public void llenarDatosCuidador() {
        if (vistaRegAni.getTabladlgCuidador().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(vistaRegAni.getTabladlgCuidador(), "No ha seleccionado ningun cuidador");
        } else {
            vistaRegAni.getTxtidCuidadorNoborrar().setVisible(false);
            vistaRegAni.getTxtidHabitatNoborrar().setVisible(false);

            int fila = vistaRegAni.getTabladlgCuidador().getSelectedRow();
//        int idProv = Integer.parseInt(vistaRegAlimento.getTabladlg().getValueAt(fila, 0).toString());
            String nombre = vistaRegAni.getTabladlgCuidador().getValueAt(fila, 1).toString(),
                    tiposangre = vistaRegAni.getTabladlgCuidador().getValueAt(fila, 2).toString(),
                    id = vistaRegAni.getTabladlgCuidador().getValueAt(fila, 0).toString();

            vistaRegAni.getTxtidCuidadorNoborrar().setText(id);
            vistaRegAni.getTxtNombreCuidador().setText(nombre);
            vistaRegAni.getTxtTipoSangre().setText(tiposangre);
            vistaRegAni.getjDlgCuidador().dispose();
            vistaRegAni.getTxtbuscardlgCui().setText("");
        }
    }

    public void abrirDlgHabitat() {
        vistaRegAni.getjDlgHabitat().setLocationRelativeTo(vistaRegAni);
        vistaRegAni.getjDlgHabitat().setVisible(true);
        cargarDatosDlgHabitat(1);
    }

    public void cargarDatosDlgHabitat(int opc) {

        vistaRegAni.getTabladlgHabitat().setRowHeight(25);
        estructuraTabla = (DefaultTableModel) vistaRegAni.getTabladlgHabitat().getModel();
        estructuraTabla.setRowCount(0);

        List<Habitat> listaProv;
//        if (opc == 1) {
//            listaProv = modeloProv.getProveedor();
//        } else {
        String busqueda = vistaRegAni.getTxtbuscardlgHab().getText().toLowerCase().trim();
        listaProv = modeloHab.busquedaincrementalDlg(busqueda);
//        }

        i = 0;
        listaProv.stream().sorted((x, y)
                -> x.getTipohab().compareToIgnoreCase(y.getTipohab())).forEach(emp -> {
            estructuraTabla.addRow(new Object[listaProv.size()]);
            vistaRegAni.getTabladlgHabitat().setValueAt(emp.getId_habitat(), i, 0);
            vistaRegAni.getTabladlgHabitat().setValueAt(emp.getTipohab(), i, 1);
            vistaRegAni.getTabladlgHabitat().setValueAt(emp.getUbicacionhab(), i, 2);
            i++;
        });
    }

    public void llenarDatosHabitat() {
        if (vistaRegAni.getTabladlgHabitat().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(vistaRegAni.getTabladlgHabitat(), "No ha seleccionado ningun habitat");
        } else {
            vistaRegAni.getTxtidCuidadorNoborrar().setVisible(false);
            vistaRegAni.getTxtidHabitatNoborrar().setVisible(false);

            int fila = vistaRegAni.getTabladlgHabitat().getSelectedRow();
//        int idProv = Integer.parseInt(vistaRegAlimento.getTabladlg().getValueAt(fila, 0).toString());
            String tipo = vistaRegAni.getTabladlgHabitat().getValueAt(fila, 1).toString(),
                    ubicacion = vistaRegAni.getTabladlgHabitat().getValueAt(fila, 2).toString(),
                    id = vistaRegAni.getTabladlgHabitat().getValueAt(fila, 0).toString();

            vistaRegAni.getTxtidHabitatNoborrar().setText(id);
            vistaRegAni.getTxtTipoHabitat().setText(tipo);
            vistaRegAni.getTxtUbicacion().setText(ubicacion);
            vistaRegAni.getjDlgHabitat().dispose();
            vistaRegAni.getTxtbuscardlgHab().setText("");
        }
    }

}
