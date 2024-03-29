/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author ALEJO
 */
public class viewPantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form pantallaprincipal
     */
    public viewPantallaPrincipal() {
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

        jPanel3 = new javax.swing.JPanel();
        jDPprincipal = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlblrolPP = new javax.swing.JLabel();
        jlblCedulaPP = new javax.swing.JLabel();
        jlblNombrePP = new javax.swing.JLabel();
        jlblFotoPP = new javax.swing.JLabel();
        jlblCedulaPP1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        CrudPersonal = new javax.swing.JButton();
        CrudAnimal = new javax.swing.JButton();
        CrudClientes = new javax.swing.JButton();
        CrudAlimento = new javax.swing.JButton();
        CrudTicket = new javax.swing.JButton();
        CrudDieta = new javax.swing.JButton();
        CrudProveedor = new javax.swing.JButton();
        barramenus = new javax.swing.JMenuBar();
        MenuPersonal = new javax.swing.JMenu();
        jMIagregarPersona = new javax.swing.JMenuItem();
        jMIvistaEmpleado = new javax.swing.JMenuItem();
        MenuClientes = new javax.swing.JMenu();
        jMIagregarCliente = new javax.swing.JMenuItem();
        JMIvistaCliente = new javax.swing.JMenuItem();
        MenuProveedor = new javax.swing.JMenu();
        jMIagregarProveedor = new javax.swing.JMenuItem();
        JMIvistaProveedor = new javax.swing.JMenuItem();
        menuanimales = new javax.swing.JMenu();
        jMIagregarAnimal = new javax.swing.JMenuItem();
        jMIvisualizarAnimal = new javax.swing.JMenuItem();
        menualimento = new javax.swing.JMenu();
        jMIagregarAlimento = new javax.swing.JMenuItem();
        jMIcrudAlimento = new javax.swing.JMenuItem();
        MenuDieta = new javax.swing.JMenu();
        jMIAgregarDieta = new javax.swing.JMenuItem();
        jMIVisualizarDietas = new javax.swing.JMenuItem();
        MenuHabitad = new javax.swing.JMenu();
        jMIAgregarHabitat = new javax.swing.JMenuItem();
        jMIVisualizarHabitat = new javax.swing.JMenuItem();
        MenuTicket = new javax.swing.JMenu();
        MIventaTickets = new javax.swing.JMenuItem();
        MIActualizarPrecio = new javax.swing.JMenuItem();
        jMIvisualizarPrecios = new javax.swing.JMenuItem();
        MenuFactura = new javax.swing.JMenu();
        MIconsultaFacturas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1150, 0));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDPprincipal.setBackground(new java.awt.Color(210, 215, 159));
        jDPprincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDPprincipal.setForeground(new java.awt.Color(210, 215, 159));
        jDPprincipal.setEnabled(false);

        javax.swing.GroupLayout jDPprincipalLayout = new javax.swing.GroupLayout(jDPprincipal);
        jDPprincipal.setLayout(jDPprincipalLayout);
        jDPprincipalLayout.setHorizontalGroup(
            jDPprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 966, Short.MAX_VALUE)
        );
        jDPprincipalLayout.setVerticalGroup(
            jDPprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        jPanel3.add(jDPprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 970, 630));

        jPanel2.setBackground(new java.awt.Color(72, 56, 56));
        jPanel2.setForeground(new java.awt.Color(210, 215, 159));

        jLabel3.setFont(new java.awt.Font("MS Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(210, 215, 159));
        jLabel3.setText("¡ZOOMANIA!");

        jlblrolPP.setFont(new java.awt.Font("MS Gothic", 1, 21)); // NOI18N
        jlblrolPP.setForeground(new java.awt.Color(210, 215, 159));
        jlblrolPP.setText("SECRETARIA");

        jlblCedulaPP.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        jlblCedulaPP.setForeground(new java.awt.Color(210, 215, 159));
        jlblCedulaPP.setText("Cedula");

        jlblNombrePP.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        jlblNombrePP.setForeground(new java.awt.Color(210, 215, 159));
        jlblNombrePP.setText("Nombre usuario");

        jlblFotoPP.setBackground(new java.awt.Color(72, 56, 56));
        jlblFotoPP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jlblFotoPP.setOpaque(true);

        jlblCedulaPP1.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        jlblCedulaPP1.setForeground(new java.awt.Color(210, 215, 159));
        jlblCedulaPP1.setText("C.I.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jlblFotoPP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblrolPP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlblNombrePP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jlblCedulaPP1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlblCedulaPP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblrolPP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlblNombrePP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblCedulaPP, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblCedulaPP1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlblFotoPP, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 180));

        jPanel1.setBackground(new java.awt.Color(144, 183, 125));

        btnCerrarSesion.setBackground(new java.awt.Color(117, 156, 98));
        btnCerrarSesion.setFont(new java.awt.Font("MS Gothic", 0, 24)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(204, 255, 204));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion (1).png"))); // NOI18N
        btnCerrarSesion.setText("CERRAR SESION");
        btnCerrarSesion.setToolTipText("Vaciar pantalla");
        btnCerrarSesion.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(144, 183, 125));

        CrudPersonal.setBackground(new java.awt.Color(144, 183, 125));
        CrudPersonal.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        CrudPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datos-del-usuario (1).png"))); // NOI18N
        CrudPersonal.setText("Personal");
        CrudPersonal.setBorder(null);

        CrudAnimal.setBackground(new java.awt.Color(144, 183, 125));
        CrudAnimal.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        CrudAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leon (3).png"))); // NOI18N
        CrudAnimal.setText("Animales");
        CrudAnimal.setBorder(null);

        CrudClientes.setBackground(new java.awt.Color(144, 183, 125));
        CrudClientes.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        CrudClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente (1).png"))); // NOI18N
        CrudClientes.setText("Clientes");
        CrudClientes.setBorder(null);

        CrudAlimento.setBackground(new java.awt.Color(144, 183, 125));
        CrudAlimento.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        CrudAlimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alimentos-para-mascotas (3).png"))); // NOI18N
        CrudAlimento.setText("Alimento");
        CrudAlimento.setBorder(null);

        CrudTicket.setBackground(new java.awt.Color(144, 183, 125));
        CrudTicket.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        CrudTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket (3).png"))); // NOI18N
        CrudTicket.setText("Tickets");
        CrudTicket.setBorder(null);

        CrudDieta.setBackground(new java.awt.Color(144, 183, 125));
        CrudDieta.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        CrudDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dieta (1).png"))); // NOI18N
        CrudDieta.setText("Dieta");
        CrudDieta.setBorder(null);

        CrudProveedor.setBackground(new java.awt.Color(144, 183, 125));
        CrudProveedor.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        CrudProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/repartidor (1).png"))); // NOI18N
        CrudProveedor.setText("Proveedor");
        CrudProveedor.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CrudPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CrudAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CrudClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CrudAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CrudTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CrudDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CrudProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(CrudPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrudTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrudAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrudAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrudDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrudClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrudProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, 450));

        MenuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datos-del-usuario.png"))); // NOI18N
        MenuPersonal.setText("Personal");

        jMIagregarPersona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIagregarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario (2).png"))); // NOI18N
        jMIagregarPersona.setText("Agregar personal");
        MenuPersonal.add(jMIagregarPersona);

        jMIvistaEmpleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIvistaEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        jMIvistaEmpleado.setText("Visualizar registro");
        MenuPersonal.add(jMIvistaEmpleado);

        barramenus.add(MenuPersonal);

        MenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        MenuClientes.setText("Cliente");

        jMIagregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario (2).png"))); // NOI18N
        jMIagregarCliente.setText("Agregar cliente");
        MenuClientes.add(jMIagregarCliente);

        JMIvistaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        JMIvistaCliente.setText("Visualizar registro");
        MenuClientes.add(JMIvistaCliente);

        barramenus.add(MenuClientes);

        MenuProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/repartidor.png"))); // NOI18N
        MenuProveedor.setText("Proveedor");

        jMIagregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario (2).png"))); // NOI18N
        jMIagregarProveedor.setText("Agregar proveedor");
        MenuProveedor.add(jMIagregarProveedor);

        JMIvistaProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        JMIvistaProveedor.setText("´Visualizar registro");
        MenuProveedor.add(JMIvistaProveedor);

        barramenus.add(MenuProveedor);

        menuanimales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/leon (2).png"))); // NOI18N
        menuanimales.setText("Animales");

        jMIagregarAnimal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIagregarAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuidado-de-mascotas.png"))); // NOI18N
        jMIagregarAnimal.setText("Agregar animal");
        menuanimales.add(jMIagregarAnimal);

        jMIvisualizarAnimal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIvisualizarAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        jMIvisualizarAnimal.setText("Visualizar registro");
        menuanimales.add(jMIvisualizarAnimal);

        barramenus.add(menuanimales);

        menualimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plato.png"))); // NOI18N
        menualimento.setText("Alimento");

        jMIagregarAlimento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIagregarAlimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadiendo.png"))); // NOI18N
        jMIagregarAlimento.setText("Agregar alimento");
        menualimento.add(jMIagregarAlimento);

        jMIcrudAlimento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIcrudAlimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        jMIcrudAlimento.setText("Visualizar registro");
        menualimento.add(jMIcrudAlimento);

        barramenus.add(menualimento);

        MenuDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dieta.png"))); // NOI18N
        MenuDieta.setText("Dieta");

        jMIAgregarDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dieta.png"))); // NOI18N
        jMIAgregarDieta.setText("Agregar dieta");
        MenuDieta.add(jMIAgregarDieta);

        jMIVisualizarDietas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        jMIVisualizarDietas.setText("Visualizar registro");
        MenuDieta.add(jMIVisualizarDietas);

        barramenus.add(MenuDieta);

        MenuHabitad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tierra.png"))); // NOI18N
        MenuHabitad.setText("Habitat");

        jMIAgregarHabitat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nacio.png"))); // NOI18N
        jMIAgregarHabitat.setText("Agregar habitat");
        MenuHabitad.add(jMIAgregarHabitat);

        jMIVisualizarHabitat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        jMIVisualizarHabitat.setText("Visualizar registro");
        MenuHabitad.add(jMIVisualizarHabitat);

        barramenus.add(MenuHabitad);

        MenuTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket (2).png"))); // NOI18N
        MenuTicket.setText("Tickets");

        MIventaTickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket (2).png"))); // NOI18N
        MIventaTickets.setText("Venta de Tickets");
        MenuTicket.add(MIventaTickets);

        MIActualizarPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket.png"))); // NOI18N
        MIActualizarPrecio.setText("Actualizar Precio");
        MenuTicket.add(MIActualizarPrecio);

        jMIvisualizarPrecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver.png"))); // NOI18N
        jMIvisualizarPrecios.setText("Visualizar Precios");
        MenuTicket.add(jMIvisualizarPrecios);

        barramenus.add(MenuTicket);

        MenuFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket (2).png"))); // NOI18N
        MenuFactura.setText("Factura");

        MIconsultaFacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket.png"))); // NOI18N
        MIconsultaFacturas.setText("Consultar Facturas");
        MenuFactura.add(MIconsultaFacturas);

        barramenus.add(MenuFactura);

        setJMenuBar(barramenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrudAlimento;
    private javax.swing.JButton CrudAnimal;
    private javax.swing.JButton CrudClientes;
    private javax.swing.JButton CrudDieta;
    private javax.swing.JButton CrudPersonal;
    private javax.swing.JButton CrudProveedor;
    private javax.swing.JButton CrudTicket;
    private javax.swing.JMenuItem JMIvistaCliente;
    private javax.swing.JMenuItem JMIvistaProveedor;
    private javax.swing.JMenuItem MIActualizarPrecio;
    private javax.swing.JMenuItem MIconsultaFacturas;
    private javax.swing.JMenuItem MIventaTickets;
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenu MenuDieta;
    private javax.swing.JMenu MenuFactura;
    private javax.swing.JMenu MenuHabitad;
    private javax.swing.JMenu MenuPersonal;
    private javax.swing.JMenu MenuProveedor;
    private javax.swing.JMenu MenuTicket;
    private javax.swing.JMenuBar barramenus;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JDesktopPane jDPprincipal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMIAgregarDieta;
    private javax.swing.JMenuItem jMIAgregarHabitat;
    private javax.swing.JMenuItem jMIVisualizarDietas;
    private javax.swing.JMenuItem jMIVisualizarHabitat;
    private javax.swing.JMenuItem jMIagregarAlimento;
    private javax.swing.JMenuItem jMIagregarAnimal;
    private javax.swing.JMenuItem jMIagregarCliente;
    private javax.swing.JMenuItem jMIagregarPersona;
    private javax.swing.JMenuItem jMIagregarProveedor;
    private javax.swing.JMenuItem jMIcrudAlimento;
    private javax.swing.JMenuItem jMIvistaEmpleado;
    private javax.swing.JMenuItem jMIvisualizarAnimal;
    private javax.swing.JMenuItem jMIvisualizarPrecios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlblCedulaPP;
    private javax.swing.JLabel jlblCedulaPP1;
    private javax.swing.JLabel jlblFotoPP;
    private javax.swing.JLabel jlblNombrePP;
    private javax.swing.JLabel jlblrolPP;
    private javax.swing.JMenu menualimento;
    private javax.swing.JMenu menuanimales;
    // End of variables declaration//GEN-END:variables

    public JButton getCrudAlimento() {
        return CrudAlimento;
    }

    public void setCrudAlimento(JButton CrudAlimento) {
        this.CrudAlimento = CrudAlimento;
    }

    public JButton getCrudAnimal() {
        return CrudAnimal;
    }

    public void setCrudAnimal(JButton CrudAnimal) {
        this.CrudAnimal = CrudAnimal;
    }

    public JButton getCrudClientes() {
        return CrudClientes;
    }

    public void setCrudClientes(JButton CrudClientes) {
        this.CrudClientes = CrudClientes;
    }

    public JButton getCrudDieta() {
        return CrudDieta;
    }

    public void setCrudDieta(JButton CrudDieta) {
        this.CrudDieta = CrudDieta;
    }

    public JButton getCrudPersonal() {
        return CrudPersonal;
    }

    public void setCrudPersonal(JButton CrudPersonal) {
        this.CrudPersonal = CrudPersonal;
    }

    public JButton getCrudProveedor() {
        return CrudProveedor;
    }

    public void setCrudProveedor(JButton CrudProveedor) {
        this.CrudProveedor = CrudProveedor;
    }

    public JButton getCrudTicket() {
        return CrudTicket;
    }

    public void setCrudTicket(JButton CrudTicket) {
        this.CrudTicket = CrudTicket;
    }

    public JMenuItem getJMIvistaCliente() {
        return JMIvistaCliente;
    }

    public void setJMIvistaCliente(JMenuItem JMIvistaCliente) {
        this.JMIvistaCliente = JMIvistaCliente;
    }

    public JMenuItem getJMIvistaProveedor() {
        return JMIvistaProveedor;
    }

    public void setJMIvistaProveedor(JMenuItem JMIvistaProveedor) {
        this.JMIvistaProveedor = JMIvistaProveedor;
    }

    public JMenuItem getMIActualizarPrecio() {
        return MIActualizarPrecio;
    }

    public void setMIActualizarPrecio(JMenuItem MIActualizarPrecio) {
        this.MIActualizarPrecio = MIActualizarPrecio;
    }

    public JMenuItem getMIconsultaFacturas() {
        return MIconsultaFacturas;
    }

    public void setMIconsultaFacturas(JMenuItem MIconsultaFacturas) {
        this.MIconsultaFacturas = MIconsultaFacturas;
    }

    public JMenuItem getMIventaTickets() {
        return MIventaTickets;
    }

    public void setMIventaTickets(JMenuItem MIventaTickets) {
        this.MIventaTickets = MIventaTickets;
    }

    public JMenu getMenuClientes() {
        return MenuClientes;
    }

    public void setMenuClientes(JMenu MenuClientes) {
        this.MenuClientes = MenuClientes;
    }

    public JMenu getMenuDieta() {
        return MenuDieta;
    }

    public void setMenuDieta(JMenu MenuDieta) {
        this.MenuDieta = MenuDieta;
    }

    public JMenu getMenuFactura() {
        return MenuFactura;
    }

    public void setMenuFactura(JMenu MenuFactura) {
        this.MenuFactura = MenuFactura;
    }

    public JMenu getMenuHabitad() {
        return MenuHabitad;
    }

    public void setMenuHabitad(JMenu MenuHabitad) {
        this.MenuHabitad = MenuHabitad;
    }

    public JMenu getMenuPersonal() {
        return MenuPersonal;
    }

    public void setMenuPersonal(JMenu MenuPersonal) {
        this.MenuPersonal = MenuPersonal;
    }

    public JMenu getMenuProveedor() {
        return MenuProveedor;
    }

    public void setMenuProveedor(JMenu MenuProveedor) {
        this.MenuProveedor = MenuProveedor;
    }

    public JMenu getMenuTicket() {
        return MenuTicket;
    }

    public void setMenuTicket(JMenu MenuTicket) {
        this.MenuTicket = MenuTicket;
    }

    public JMenuBar getBarramenus() {
        return barramenus;
    }

    public void setBarramenus(JMenuBar barramenus) {
        this.barramenus = barramenus;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void setBtnCerrarSesion(JButton btnCerrarSesion) {
        this.btnCerrarSesion = btnCerrarSesion;
    }

    public JDesktopPane getjDPprincipal() {
        return jDPprincipal;
    }

    public void setjDPprincipal(JDesktopPane jDPprincipal) {
        this.jDPprincipal = jDPprincipal;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JMenuItem getjMIAgregarDieta() {
        return jMIAgregarDieta;
    }

    public void setjMIAgregarDieta(JMenuItem jMIAgregarDieta) {
        this.jMIAgregarDieta = jMIAgregarDieta;
    }

    public JMenuItem getjMIAgregarHabitat() {
        return jMIAgregarHabitat;
    }

    public void setjMIAgregarHabitat(JMenuItem jMIAgregarHabitat) {
        this.jMIAgregarHabitat = jMIAgregarHabitat;
    }

    public JMenuItem getjMIVisualizarDietas() {
        return jMIVisualizarDietas;
    }

    public void setjMIVisualizarDietas(JMenuItem jMIVisualizarDietas) {
        this.jMIVisualizarDietas = jMIVisualizarDietas;
    }

    public JMenuItem getjMIVisualizarHabitat() {
        return jMIVisualizarHabitat;
    }

    public void setjMIVisualizarHabitat(JMenuItem jMIVisualizarHabitat) {
        this.jMIVisualizarHabitat = jMIVisualizarHabitat;
    }

    public JMenuItem getjMIagregarAlimento() {
        return jMIagregarAlimento;
    }

    public void setjMIagregarAlimento(JMenuItem jMIagregarAlimento) {
        this.jMIagregarAlimento = jMIagregarAlimento;
    }

    public JMenuItem getjMIagregarAnimal() {
        return jMIagregarAnimal;
    }

    public void setjMIagregarAnimal(JMenuItem jMIagregarAnimal) {
        this.jMIagregarAnimal = jMIagregarAnimal;
    }

    public JMenuItem getjMIagregarCliente() {
        return jMIagregarCliente;
    }

    public void setjMIagregarCliente(JMenuItem jMIagregarCliente) {
        this.jMIagregarCliente = jMIagregarCliente;
    }

    public JMenuItem getjMIagregarPersona() {
        return jMIagregarPersona;
    }

    public void setjMIagregarPersona(JMenuItem jMIagregarPersona) {
        this.jMIagregarPersona = jMIagregarPersona;
    }

    public JMenuItem getjMIagregarProveedor() {
        return jMIagregarProveedor;
    }

    public void setjMIagregarProveedor(JMenuItem jMIagregarProveedor) {
        this.jMIagregarProveedor = jMIagregarProveedor;
    }

    public JMenuItem getjMIcrudAlimento() {
        return jMIcrudAlimento;
    }

    public void setjMIcrudAlimento(JMenuItem jMIcrudAlimento) {
        this.jMIcrudAlimento = jMIcrudAlimento;
    }

    public JMenuItem getjMIvistaEmpleado() {
        return jMIvistaEmpleado;
    }

    public void setjMIvistaEmpleado(JMenuItem jMIvistaEmpleado) {
        this.jMIvistaEmpleado = jMIvistaEmpleado;
    }

    public JMenuItem getjMIvisualizarAnimal() {
        return jMIvisualizarAnimal;
    }

    public void setjMIvisualizarAnimal(JMenuItem jMIvisualizarAnimal) {
        this.jMIvisualizarAnimal = jMIvisualizarAnimal;
    }

    public JMenuItem getjMIvisualizarPrecios() {
        return jMIvisualizarPrecios;
    }

    public void setjMIvisualizarPrecios(JMenuItem jMIvisualizarPrecios) {
        this.jMIvisualizarPrecios = jMIvisualizarPrecios;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JLabel getJlblCedulaPP() {
        return jlblCedulaPP;
    }

    public void setJlblCedulaPP(JLabel jlblCedulaPP) {
        this.jlblCedulaPP = jlblCedulaPP;
    }

    public JLabel getJlblCedulaPP1() {
        return jlblCedulaPP1;
    }

    public void setJlblCedulaPP1(JLabel jlblCedulaPP1) {
        this.jlblCedulaPP1 = jlblCedulaPP1;
    }

    public JLabel getJlblFotoPP() {
        return jlblFotoPP;
    }

    public void setJlblFotoPP(JLabel jlblFotoPP) {
        this.jlblFotoPP = jlblFotoPP;
    }

    public JLabel getJlblNombrePP() {
        return jlblNombrePP;
    }

    public void setJlblNombrePP(JLabel jlblNombrePP) {
        this.jlblNombrePP = jlblNombrePP;
    }

    public JLabel getJlblrolPP() {
        return jlblrolPP;
    }

    public void setJlblrolPP(JLabel jlblrolPP) {
        this.jlblrolPP = jlblrolPP;
    }

    public JMenu getMenualimento() {
        return menualimento;
    }

    public void setMenualimento(JMenu menualimento) {
        this.menualimento = menualimento;
    }

    public JMenu getMenuanimales() {
        return menuanimales;
    }

    public void setMenuanimales(JMenu menuanimales) {
        this.menuanimales = menuanimales;
    }

    
    
}
