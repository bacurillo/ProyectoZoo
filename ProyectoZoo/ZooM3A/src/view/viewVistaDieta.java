/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author Bryan
 */
public class viewVistaDieta extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewVistaCliente
     */
    public viewVistaDieta() {
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

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BtnModificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jBtnImprimir = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        txtbuscar = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jBtnBuscar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblDieta = new javax.swing.JTable();

        setBackground(new java.awt.Color(210, 215, 159));
        setBorder(null);
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(166, 108, 255));
        jLabel4.setFont(new java.awt.Font("MS Gothic", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(166, 108, 255));
        jLabel4.setText("VISTA DE DIETAS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 27, -1, -1));

        jLabel3.setFont(new java.awt.Font("MS Gothic", 1, 48)); // NOI18N
        jLabel3.setText("VISTA DE DIETAS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jToolBar1.setBackground(new java.awt.Color(210, 215, 159));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.add(jSeparator7);

        btnAgregar.setBackground(new java.awt.Color(210, 215, 159));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/masa.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(null);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setOpaque(true);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAgregar);
        jToolBar1.add(jSeparator1);

        BtnModificar.setBackground(new java.awt.Color(210, 215, 159));
        BtnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar (8).png"))); // NOI18N
        BtnModificar.setText("MODIFICAR");
        BtnModificar.setBorder(null);
        BtnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnModificar.setOpaque(true);
        BtnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BtnModificar);
        jToolBar1.add(jSeparator2);

        btnEliminar.setBackground(new java.awt.Color(210, 215, 159));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comida.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setOpaque(true);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator3);

        jBtnImprimir.setBackground(new java.awt.Color(210, 215, 159));
        jBtnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/documentos (3).png"))); // NOI18N
        jBtnImprimir.setText("IMPRIMIR REPORTE");
        jBtnImprimir.setBorder(null);
        jBtnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnImprimir.setOpaque(true);
        jBtnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jBtnImprimir);
        jToolBar1.add(jSeparator4);

        txtbuscar.setBackground(new java.awt.Color(210, 218, 255));
        txtbuscar.setToolTipText("PUEDE BUSCAR MEDIANTE CEDULA, NOMBRE, APELLIDO O USUARIO");
        jToolBar1.add(txtbuscar);
        jToolBar1.add(jSeparator6);

        jBtnBuscar.setBackground(new java.awt.Color(210, 215, 159));
        jBtnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa (1).png"))); // NOI18N
        jBtnBuscar.setText("BUSCAR");
        jBtnBuscar.setBorder(null);
        jBtnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnBuscar.setOpaque(true);
        jToolBar1.add(jBtnBuscar);
        jToolBar1.add(jSeparator5);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 96, 940, 50));

        jPanel1.setBackground(new java.awt.Color(210, 215, 159));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTblDieta.setBackground(new java.awt.Color(255, 253, 227));
        jTblDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Horario", "Porcion", "Alimento", "Descripcion Alimento", "Nombre", "Especie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTblDieta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 171, 940, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTable jTblDieta;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnModificar() {
        return BtnModificar;
    }

    public void setBtnModificar(JButton BtnModificar) {
        this.BtnModificar = BtnModificar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getjBtnBuscar() {
        return jBtnBuscar;
    }

    public void setjBtnBuscar(JButton jBtnBuscar) {
        this.jBtnBuscar = jBtnBuscar;
    }

    public JButton getjBtnImprimir() {
        return jBtnImprimir;
    }

    public void setjBtnImprimir(JButton jBtnImprimir) {
        this.jBtnImprimir = jBtnImprimir;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JToolBar.Separator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JToolBar.Separator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JToolBar.Separator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JToolBar.Separator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JToolBar.Separator getjSeparator3() {
        return jSeparator3;
    }

    public void setjSeparator3(JToolBar.Separator jSeparator3) {
        this.jSeparator3 = jSeparator3;
    }

    public JToolBar.Separator getjSeparator4() {
        return jSeparator4;
    }

    public void setjSeparator4(JToolBar.Separator jSeparator4) {
        this.jSeparator4 = jSeparator4;
    }

    public JTable getjTblDieta() {
        return jTblDieta;
    }

    public void setjTblDieta(JTable jTblDieta) {
        this.jTblDieta = jTblDieta;
    }

    public JToolBar getjToolBar1() {
        return jToolBar1;
    }

    public void setjToolBar1(JToolBar jToolBar1) {
        this.jToolBar1 = jToolBar1;
    }

    public JTextField getTxtbuscar() {
        return txtbuscar;
    }

    public void setTxtbuscar(JTextField txtbuscar) {
        this.txtbuscar = txtbuscar;
    }


}
