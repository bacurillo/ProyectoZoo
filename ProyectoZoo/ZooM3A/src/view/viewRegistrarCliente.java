/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author ALEJO
 */
public class viewRegistrarCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarPersona
     */
    public viewRegistrarCliente() {
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

        bggenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btregistrar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        txtcedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 0));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlignmentX(0.0F);
        setMinimumSize(new java.awt.Dimension(48, 0));
        setName(""); // NOI18N
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(970, 630));
        setRequestFocusEnabled(false);
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(210, 215, 159));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel9.setText("NOMBRE:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 40));

        txtnombre.setBackground(new java.awt.Color(255, 253, 227));
        txtnombre.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        txtnombre.setToolTipText("INGRESE EL NOMBRE");
        txtnombre.setBorder(null);
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 240, 30));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel10.setText("APELLIDO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, 40));

        txtapellido.setBackground(new java.awt.Color(255, 253, 227));
        txtapellido.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        txtapellido.setToolTipText("INGRESE EL APELLIDO");
        txtapellido.setBorder(null);
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 240, 30));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel11.setText("CORREO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, 40));

        txtcorreo.setBackground(new java.awt.Color(255, 253, 227));
        txtcorreo.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        txtcorreo.setToolTipText("INGRESE EL CORREO");
        txtcorreo.setBorder(null);
        jPanel1.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 240, 30));

        jLabel3.setFont(new java.awt.Font("MS Gothic", 1, 44)); // NOI18N
        jLabel3.setText("REGISTRO DE CLIENTE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 50, 460, -1));

        txttelefono.setBackground(new java.awt.Color(255, 253, 227));
        txttelefono.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        txttelefono.setToolTipText("INGRESE EL TELEFONO");
        txttelefono.setBorder(null);
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 240, 30));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel7.setText("DIRECCION:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, 40));

        txtdireccion.setBackground(new java.awt.Color(255, 253, 227));
        txtdireccion.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        txtdireccion.setToolTipText("INGRESE LA DIRECCION");
        txtdireccion.setBorder(null);
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 240, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel8.setText("TELEFONO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 40));

        btregistrar.setBackground(new java.awt.Color(210, 215, 159));
        btregistrar.setFont(new java.awt.Font("MS Gothic", 1, 28)); // NOI18N
        btregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comprobado (1).png"))); // NOI18N
        btregistrar.setText("REGISTRAR");
        btregistrar.setBorder(null);
        jPanel1.add(btregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 260, 40));

        btcancelar.setBackground(new java.awt.Color(210, 215, 159));
        btcancelar.setFont(new java.awt.Font("MS Gothic", 1, 28)); // NOI18N
        btcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-x.png"))); // NOI18N
        btcancelar.setText("CANCELAR");
        btcancelar.setBorder(null);
        jPanel1.add(btcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 260, 40));

        txtcedula.setBackground(new java.awt.Color(255, 253, 227));
        txtcedula.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        txtcedula.setToolTipText("INGRESE LA CEDULA");
        txtcedula.setBorder(null);
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 240, 30));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel5.setText("CEDULA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/personas (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("MS Gothic", 1, 44)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(61, 131, 97));
        jLabel4.setText("CLIENTES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 200, -1));

        jLabel6.setFont(new java.awt.Font("MS Gothic", 1, 44)); // NOI18N
        jLabel6.setText("CLIENTES");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 453, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public ButtonGroup getBggenero() {
        return bggenero;
    }

    public void setBggenero(ButtonGroup bggenero) {
        this.bggenero = bggenero;
    }

    public JButton getBtcancelar() {
        return btcancelar;
    }

    public void setBtcancelar(JButton btcancelar) {
        this.btcancelar = btcancelar;
    }

    public JButton getBtregistrar() {
        return btregistrar;
    }

    public void setBtregistrar(JButton btregistrar) {
        this.btregistrar = btregistrar;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JTextField getTxtapellido() {
        return txtapellido;
    }

    public void setTxtapellido(JTextField txtapellido) {
        this.txtapellido = txtapellido;
    }

    public JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    public JTextField getTxtcorreo() {
        return txtcorreo;
    }

    public void setTxtcorreo(JTextField txtcorreo) {
        this.txtcorreo = txtcorreo;
    }

    public JTextField getTxtdireccion() {
        return txtdireccion;
    }

    public void setTxtdireccion(JTextField txtdireccion) {
        this.txtdireccion = txtdireccion;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxttelefono() {
        return txttelefono;
    }

    /**
     * @param args the command line arguments
     */
    public void setTxttelefono(JTextField txttelefono) {
        this.txttelefono = txttelefono;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bggenero;
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton btregistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

}