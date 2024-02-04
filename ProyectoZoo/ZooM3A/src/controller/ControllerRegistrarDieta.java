/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Dieta;
import model.ModelDieta;
import model.ModelAlimento;
import model.Alimento;
import model.Animales;
import model.ModelAnimal;
import view.viewRegistroDieta;
import view.viewVistaDieta;

/**
 *
 * @author ALEJO
 */
public class ControllerRegistrarDieta {

    private viewRegistroDieta vistaRegDieta;
    private viewVistaDieta vistaViewDieta;
    private ModelDieta modelDieta;
    private ModelAlimento modelAlimento;
    private ModelAnimal modelAnimal;

    int i = 0;
    boolean banvista = false;
    DefaultTableModel estructuraTabla;

    public ControllerRegistrarDieta() {
    }

    public ControllerRegistrarDieta(viewRegistroDieta vistaRegDieta, viewVistaDieta vistaViewDieta, ModelDieta modelDieta, ModelAlimento modelAlimento, ModelAnimal modelAnimal) {
        this.vistaRegDieta = vistaRegDieta;
        this.vistaViewDieta = vistaViewDieta;
        this.modelDieta = modelDieta;
        this.modelAlimento = modelAlimento;
        this.modelAnimal = modelAnimal;
        vistaRegDieta.toFront();
        vistaRegDieta.setVisible(true);
        banvista = true;
    }

    public ControllerRegistrarDieta(viewRegistroDieta vistaRegDieta, ModelDieta modelDieta, ModelAlimento modelAlimento, ModelAnimal modelAnimal) {
        this.vistaRegDieta = vistaRegDieta;
        this.modelDieta = modelDieta;
        this.modelAlimento = modelAlimento;
        this.modelAnimal = modelAnimal;
        vistaRegDieta.toFront();
        vistaRegDieta.setVisible(true);
        banvista = false;
    }

    public void iniciarControles() {
        vistaRegDieta.getBtncancelardieta().addActionListener(l -> vistaRegDieta.dispose());
        vistaRegDieta.getBtnagregardieta().addActionListener(l -> registrarDieta());

        vistaRegDieta.getBtnSeleccionarAliemento().addActionListener(l -> abrirDlgAlimento());
        vistaRegDieta.getBtnseleccionardlgAlimento().addActionListener(l -> llenarDatosAlimento());
        vistaRegDieta.getTxtbuscardlgAlimento().addKeyListener(busquedaIncrenmentalAli);

        vistaRegDieta.getBtnSeleccionarAnimal().addActionListener(l -> abrirDlgAnimal());
        vistaRegDieta.getBtnseleccionardlgAnimal().addActionListener(l -> llenarDatosAnimal());
        vistaRegDieta.getTxtbuscardlgAnimal().addKeyListener(busquedaIncrenmentalAni);
    }
    KeyListener busquedaIncrenmentalAli = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            cargarDatosDlgAlimento(2);
        }
    };

    KeyListener busquedaIncrenmentalAni = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            cargarDatosDlgAnimal(2);
        }
    };

    public void abrirRegistro(int op) {
        vistaRegDieta.toFront();
        if (op == 1) {
            limpiarCampos();
            vistaRegDieta.setName("Registro");
            vistaRegDieta.getBtnagregardieta().setText("REGISTRAR");
            vistaRegDieta.setVisible(true);
            this.iniciarControles();
        } else {
            if (llenarDatos()) {
                vistaRegDieta.setName("Editar");
                vistaRegDieta.getBtnagregardieta().setText("REGISTRAR");
                vistaRegDieta.setVisible(true);
                this.iniciarControles();
            }
        }
    }

    public void registrarDieta() {
        if (validar()) {
            vistaRegDieta.getTxtidAlimentoNB().setVisible(false);
            vistaRegDieta.getTxtidAnimalNB().setVisible(false);
            vistaRegDieta.getTxtidDietaNB().setVisible(false);
            String horario = vistaRegDieta.getCombohoradieta().getSelectedItem().toString(),
                    porcion = vistaRegDieta.getTxtporcion().getText();

            int idali = Integer.parseInt(vistaRegDieta.getTxtidAlimentoNB().getText()),
                    idAni = Integer.parseInt(vistaRegDieta.getTxtidAnimalNB().getText());
            ModelDieta dieta = new ModelDieta();
            dieta.setDie_horario(horario);
            dieta.setDie_porcion(porcion);
            dieta.setDie_idAlimento(idali);
            dieta.setDie_idAnimal(idAni);
            dieta.setDie_estado(true);

            if (vistaRegDieta.getName().equals("Registro")) {
                int response = JOptionPane.showConfirmDialog(vistaRegDieta, "¿Agregar Dieta?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (dieta.setDieta()) {
                        JOptionPane.showMessageDialog(vistaRegDieta, "Dieta agregada correctamente");
                        vistaRegDieta.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegDieta, "No se pudo agregar la dieta");
                    }
                }
            } else {
                //UPDATE
                int id = Integer.parseInt(vistaRegDieta.getTxtidDietaNB().getText());
                dieta.setDie_id(id);

                int response = JOptionPane.showConfirmDialog(vistaRegDieta, "¿Seguro que desea actualizar la dieta?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    if (dieta.updateDieta()) {//Grabamos
                        JOptionPane.showMessageDialog(vistaRegDieta, "Dieta actualizada correctamente");
                        vistaRegDieta.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vistaRegDieta, "No se pudo actualizar la dieta");
                    }
                }
            }
            if (banvista) {
                ControllerVistaDieta controlVprov = new ControllerVistaDieta(vistaViewDieta, modelDieta);
                controlVprov.cargarDatos(1);
            }
        }
    }

    public boolean llenarDatos() {
        int fila = vistaViewDieta.getjTblDieta().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaViewDieta, "Seleccione una dieta a modificar");
            return false;
        } else {
            int id = Integer.parseInt(vistaViewDieta.getjTblDieta().getValueAt(fila, 0).toString());
            List<Dieta> listaDieta = modelDieta.getDieta();
            listaDieta.stream().forEach(die -> {
                if (id == die.getDie_id()) {
                    vistaRegDieta.getTxtidDietaNB().setText(String.valueOf(die.getDie_id()));
                    for (int j = 0; j < vistaRegDieta.getCombohoradieta().getItemCount(); j++) {
                        if (vistaRegDieta.getCombohoradieta().getItemAt(j).equalsIgnoreCase(die.getDie_horario())) {
                            vistaRegDieta.getCombohoradieta().setSelectedIndex(j);
                        }
                    }
                    vistaRegDieta.getTxtporcion().setText(die.getDie_porcion());

                    vistaRegDieta.getTxtidAlimentoNB().setText(String.valueOf(die.getDie_idAlimento()));
                    vistaRegDieta.getTxtnombrealiemento().setText(die.getNombreAli());
                    vistaRegDieta.getTxtAdescripcionAlimento().setText(die.getDescripcionAli());

                    vistaRegDieta.getTxtidAnimalNB().setText(String.valueOf(die.getDie_idAnimal()));
                    vistaRegDieta.getTxtnombreanimal().setText(String.valueOf(die.getNombreAnimal()));
                    vistaRegDieta.getTxtespecie().setText(die.getEspecieAnimal());

                }
            });
            return true;
        }
    }

    public void llenarDatosAlimento() {
        if (vistaRegDieta.getTabladlgAlimento().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(vistaRegDieta.getTabladlgAlimento(), "No ha seleccionado ningun alimento");
        } else {
            vistaRegDieta.getTxtidAlimentoNB().setVisible(false);
            vistaRegDieta.getTxtidAnimalNB().setVisible(false);
            vistaRegDieta.getTxtidDietaNB().setVisible(false);

            int fila = vistaRegDieta.getTabladlgAlimento().getSelectedRow();
            vistaRegDieta.getTxtidAlimentoNB().setText(vistaRegDieta.getTabladlgAlimento().getValueAt(fila, 0).toString());
            vistaRegDieta.getTxtnombrealiemento().setText(vistaRegDieta.getTabladlgAlimento().getValueAt(fila, 1).toString());
            vistaRegDieta.getTxtAdescripcionAlimento().setText(vistaRegDieta.getTabladlgAlimento().getValueAt(fila, 2).toString());

            vistaRegDieta.getDlgAlimento().dispose();
            vistaRegDieta.getTxtbuscardlgAlimento().setText("");
        }
    }

    public void llenarDatosAnimal() {
        if (vistaRegDieta.getTabladlgAnimal().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(vistaRegDieta.getTabladlgAnimal(), "No ha seleccionado ningun animal");
        } else {
            vistaRegDieta.getTxtidAlimentoNB().setVisible(false);
            vistaRegDieta.getTxtidAnimalNB().setVisible(false);
            vistaRegDieta.getTxtidDietaNB().setVisible(false);

            int fila = vistaRegDieta.getTabladlgAnimal().getSelectedRow();
            vistaRegDieta.getTxtidAnimalNB().setText(vistaRegDieta.getTabladlgAnimal().getValueAt(fila, 0).toString());
            vistaRegDieta.getTxtnombreanimal().setText(vistaRegDieta.getTabladlgAnimal().getValueAt(fila, 1).toString());
            vistaRegDieta.getTxtespecie().setText(vistaRegDieta.getTabladlgAnimal().getValueAt(fila, 2).toString());

            vistaRegDieta.getDlgAnimal().dispose();
            vistaRegDieta.getTxtbuscardlgAnimal().setText("");
        }
    }

    public void abrirDlgAlimento() {
        vistaRegDieta.getDlgAlimento().setLocationRelativeTo(vistaRegDieta);
        vistaRegDieta.getDlgAlimento().setVisible(true);
        cargarDatosDlgAlimento(1);
    }

    public void abrirDlgAnimal() {
        vistaRegDieta.getDlgAnimal().setLocationRelativeTo(vistaRegDieta);
        vistaRegDieta.getDlgAnimal().setVisible(true);
        cargarDatosDlgAnimal(1);
    }

    public void cargarDatosDlgAlimento(int opc) {

        vistaRegDieta.getTabladlgAlimento().setRowHeight(25);
        estructuraTabla = (DefaultTableModel) vistaRegDieta.getTabladlgAlimento().getModel();
        estructuraTabla.setRowCount(0);

        List<Alimento> listaAlimento;

        String busqueda = vistaRegDieta.getTxtbuscardlgAlimento().getText().toLowerCase().trim();
        listaAlimento = modelAlimento.busquedaincrementalDlg(busqueda);

        i = 0;
        listaAlimento.stream().sorted((x, y)
                -> x.getNombreAli().compareToIgnoreCase(y.getNombreAli())).forEach(ali -> {
            estructuraTabla.addRow(new Object[listaAlimento.size()]);
            vistaRegDieta.getTabladlgAlimento().setValueAt(ali.getIdalimento(), i, 0);
            vistaRegDieta.getTabladlgAlimento().setValueAt(ali.getNombreAli(), i, 1);
            vistaRegDieta.getTabladlgAlimento().setValueAt(ali.getDescripcionAli(), i, 2);

            i++;
        });

    }

    public void cargarDatosDlgAnimal(int opc) {

        vistaRegDieta.getTabladlgAnimal().setRowHeight(25);
        estructuraTabla = (DefaultTableModel) vistaRegDieta.getTabladlgAnimal().getModel();
        estructuraTabla.setRowCount(0);

        List<Animales> listaAnimal;

        String busqueda = vistaRegDieta.getTxtbuscardlgAnimal().getText().toLowerCase().trim();
        listaAnimal = modelAnimal.busquedaIncrementalDlg(busqueda);

        i = 0;
        listaAnimal.stream().sorted((x, y)
                -> x.getEspecieAnimal().compareToIgnoreCase(y.getEspecieAnimal())).forEach(ani -> {
            estructuraTabla.addRow(new Object[listaAnimal.size()]);
            vistaRegDieta.getTabladlgAnimal().setValueAt(ani.getIdAnimal(), i, 0);
            vistaRegDieta.getTabladlgAnimal().setValueAt(ani.getNombreAnimal(), i, 1);
            vistaRegDieta.getTabladlgAnimal().setValueAt(ani.getEspecieAnimal(), i, 2);

            i++;
        });

    }

    public void limpiarCampos() {
        vistaRegDieta.getTxtnombreanimal().setText("");
        vistaRegDieta.getTxtnombrealiemento().setText("");
        vistaRegDieta.getTxtporcion().setText("");
        vistaRegDieta.getTxtespecie().setText("");
        vistaRegDieta.getTxtAdescripcionAlimento().setText("");

        vistaRegDieta.getCombohoradieta().setSelectedIndex(0);

    }

    public boolean validar() {
        boolean ban = true;
        validaciones mivalidacion = new validaciones();

        if (vistaRegDieta.getCombohoradieta().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vistaRegDieta, "SELECCIONE UN HORARIO");
            ban = false;
        }

        if (!vistaRegDieta.getTxtporcion().getText().isEmpty()) {
            if (mivalidacion.validarDouble(vistaRegDieta.getTxtporcion().getText()) == 0) {
                JOptionPane.showMessageDialog(vistaRegDieta, "Porcion invalida");
                ban = false;
            }
        } else {
            JOptionPane.showMessageDialog(vistaRegDieta, "Ingrese una porcion");
            ban = false;
        }

        if (vistaRegDieta.getTxtnombrealiemento().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegDieta, "ELIJA UN ALIMENTO");
            ban = false;
        }

        if (vistaRegDieta.getTxtnombreanimal().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegDieta, "ELIJA UN ANIMAL");
            ban = false;
        }
        return ban;
    }
}
