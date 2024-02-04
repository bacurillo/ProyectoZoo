/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ALEJO
 */
public class viewVistaEmpleados extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaUsuarios
     */
    public viewVistaEmpleados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblEmpleado = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jbtnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jBtnModificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jBtnElimina = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jBtnImprimir = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jBtnBuscar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        txtBuscar = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(144, 183, 125));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(970, 654));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datos-del-usuario (2) (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 70, 70));

        jLabel3.setBackground(new java.awt.Color(250, 112, 112));
        jLabel3.setFont(new java.awt.Font("MS Gothic", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(37, 49, 109));
        jLabel3.setText("VISTA DE EMPLEADOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 38, -1, -1));

        jLabel4.setFont(new java.awt.Font("MS Gothic", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(95, 111, 148));
        jLabel4.setText("VISTA DE EMPLEADOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jTblEmpleado.setBackground(new java.awt.Color(255, 253, 227));
        jTblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cedula", "Nombre", "Apellido", "Telefono", "Fecha de Nacimiento", "Correo", "Genero", "Rol", "Usuario", "Contraseñá", "Fecha de Registro", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblEmpleado.setGridColor(new java.awt.Color(51, 51, 51));
        jTblEmpleado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTblEmpleado.setShowGrid(false);
        jScrollPane1.setViewportView(jTblEmpleado);
        if (jTblEmpleado.getColumnModel().getColumnCount() > 0) {
            jTblEmpleado.getColumnModel().getColumn(5).setResizable(false);
            jTblEmpleado.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 178, 940, 410));

        jToolBar1.setBackground(new java.awt.Color(210, 215, 159));
        jToolBar1.setBorder(null);

        jbtnAgregar.setBackground(new java.awt.Color(210, 215, 159));
        jbtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario (5).png"))); // NOI18N
        jbtnAgregar.setText("AGREGAR");
        jbtnAgregar.setBorder(null);
        jbtnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jbtnAgregar);
        jToolBar1.add(jSeparator1);

        jBtnModificar.setBackground(new java.awt.Color(210, 215, 159));
        jBtnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario (6).png"))); // NOI18N
        jBtnModificar.setText("MODIFICAR");
        jBtnModificar.setBorder(null);
        jBtnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jBtnModificar);
        jToolBar1.add(jSeparator2);

        jBtnElimina.setBackground(new java.awt.Color(210, 215, 159));
        jBtnElimina.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnElimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar-usuario.png"))); // NOI18N
        jBtnElimina.setText("ELIMINAR");
        jBtnElimina.setBorder(null);
        jBtnElimina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnElimina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jBtnElimina);
        jToolBar1.add(jSeparator3);

        jBtnImprimir.setBackground(new java.awt.Color(210, 215, 159));
        jBtnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/documentos (1).png"))); // NOI18N
        jBtnImprimir.setText("IMPRIMIR REPORTE");
        jBtnImprimir.setBorder(null);
        jBtnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jBtnImprimir);
        jToolBar1.add(jSeparator4);

        jBtnBuscar.setBackground(new java.awt.Color(210, 215, 159));
        jBtnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (3).png"))); // NOI18N
        jBtnBuscar.setText("BUSCAR");
        jBtnBuscar.setBorder(null);
        jBtnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jToolBar1.add(jBtnBuscar);
        jToolBar1.add(jSeparator6);

        txtBuscar.setBackground(new java.awt.Color(183, 211, 223));
        txtBuscar.setToolTipText("PUEDE BUSCAR MEDIANTE CEDULA, NOMBRE, APELLIDO O USUARIO");
        jToolBar1.add(txtBuscar);
        jToolBar1.add(jSeparator5);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 115, 930, 50));

        jLabel1.setBackground(new java.awt.Color(210, 215, 159));
        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(970, 630));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnElimina;
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JTable jTblEmpleado;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public JButton getjBtnBuscar() {
        return jBtnBuscar;
    }

    public void setjBtnBuscar(JButton jBtnBuscar) {
        this.jBtnBuscar = jBtnBuscar;
    }

    public JButton getjBtnElimina() {
        return jBtnElimina;
    }

    public void setjBtnElimina(JButton jBtnElimina) {
        this.jBtnElimina = jBtnElimina;
    }

    public JButton getjBtnImprimir() {
        return jBtnImprimir;
    }

    public void setjBtnImprimir(JButton jBtnImprimir) {
        this.jBtnImprimir = jBtnImprimir;
    }

    public JButton getjBtnModificar() {
        return jBtnModificar;
    }

    public void setjBtnModificar(JButton jBtnModificar) {
        this.jBtnModificar = jBtnModificar;
    }


    public JTable getjTblEmpleado() {
        return jTblEmpleado;
    }

    public void setjTblEmpleado(JTable jTblEmpleado) {
        this.jTblEmpleado = jTblEmpleado;
    }

    public JButton getJbtnAgregar() {
        return jbtnAgregar;
    }

    public void setJbtnAgregar(JButton jbtnAgregar) {
        this.jbtnAgregar = jbtnAgregar;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    
}
