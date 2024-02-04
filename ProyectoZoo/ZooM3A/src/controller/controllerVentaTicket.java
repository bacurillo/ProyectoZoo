/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ModelTickets;
import model.ModelCliente;
import model.ModelFactura;
import model.Tickets;
import model.factura;
import model.modelPGconexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.viewPantallaPrincipal;
import view.viewRegistrarCliente;
import view.viewVentaTicket;

/**
 *
 * @author Bryan
 */
public class controllerVentaTicket {

    private viewPantallaPrincipal vistaP;
    private viewVentaTicket vistaVenta;
    private ModelTickets modelTicket;
    private ModelCliente modelCliente;
    private double precioIniNino;
    private double precioIniAdulto;
    private double precioIniAdultoMayor;

    private double totalIniNino;
    private double totalIniAdulto;
    private double totalIniAdultoMayor;
    private double subTOTAL;
    private double DESCUENTO;
    private double TOTAL;
    private double TOTALDESC;
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-yyyy");

    public controllerVentaTicket() {
    }

    public controllerVentaTicket(viewVentaTicket vistaVenta, ModelCliente modelCliente, String cedula) {
        this.vistaVenta = vistaVenta;
        this.modelCliente = modelCliente;
        llenarDatos(cedula);
    }

    public controllerVentaTicket(viewPantallaPrincipal vistaP, viewVentaTicket vistaVenta, ModelTickets modelTicket, ModelCliente modelCliente) {
        this.vistaP = vistaP;
        this.vistaVenta = vistaVenta;
        this.modelTicket = modelTicket;
        this.modelCliente = modelCliente;
        vistaVenta.toFront();
        datosInicial();
        cargarPrecios();
        vistaVenta.setVisible(true);
    }

    public void iniciarControl() {
        //MAS
        vistaVenta.getBtnMasNiño().addActionListener(l -> masNiño());
        vistaVenta.getBtnMasAdulto().addActionListener(l -> masAdulto());
        vistaVenta.getBtnMasAdultoMayor().addActionListener(l -> masAdultoMayor());

        //MENOS
        vistaVenta.getBtnMenosNiño().addActionListener(l -> menosNiño());
        vistaVenta.getBtnMenosAdulto().addActionListener(l -> menosAdulto());
        vistaVenta.getBtnMenosAdultoMayor().addActionListener(l -> menosAdultoMayor());
        //CLIENTE
        vistaVenta.getTxtCedulaCliente().addKeyListener(buscarcliente);
        vistaVenta.getBtnAgregarCliente().addActionListener(l -> registroCliente());

        //AGREGAR CANCELAR
        vistaVenta.getBtnCancelarCompra().addActionListener(l -> vistaVenta.dispose());

        //FACTURA
        vistaVenta.getBtnConfirmarCompra().addActionListener(l -> registrarCompra());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void registrarCompra() {

//        if (validar()) {
        if (Double.parseDouble(vistaVenta.getTxtSUBTOTAL().getText()) != 0) {
            int response = JOptionPane.showConfirmDialog(vistaVenta, "¿Confirmar Compra?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int idCliente;
                //ENCABEZADO
                if (!vistaVenta.getTxtidclienteNB().getText().isEmpty()) {
                    idCliente = Integer.parseInt(vistaVenta.getTxtidclienteNB().getText());
                } else {
                    idCliente = 1;
                }
                Date fechaRegistro = java.sql.Date.valueOf(LocalDate.now());
                ModelFactura encabezadoFac = new ModelFactura();
                encabezadoFac.setEnca_idCliente(idCliente);
                encabezadoFac.setEnca_fecha(fechaRegistro);

                encabezadoFac.setEncabezado();

                //DETALLE
                int cantNino = Integer.parseInt(vistaVenta.getTxtCantidadNiño().getText()),
                        cantAdulto = Integer.parseInt(vistaVenta.getTxtCantidadAdulto().getText()),
                        cantAdultoMayor = Integer.parseInt(vistaVenta.getTxtCantidadAdultoMayor().getText());
//                System.out.println(cantNino);
//                System.out.println(cantAdulto);
//                System.out.println(cantAdultoMayor);
                int idNino = 2,
                        idAdulto = 1,
                        idAdultoMayor = 3;

                double totalNino = Double.parseDouble(vistaVenta.getTxtTotalNiño().getText()),
                        totalAdulto = Double.parseDouble(vistaVenta.getTxtTotalAdulto().getText()),
                        totalAdultoMayor = Double.parseDouble(vistaVenta.getTxtTotalAdultoMayor().getText());

                int idEncabezado = encabezadoFac.obtenerIdEncabezado();

                //Det_niño
                if (Double.parseDouble(vistaVenta.getTxtCantidadNiño().getText()) != 0) {
//                    List<factura> listaDetalleNino = new ArrayList<>();
//                    for (int i = 0; i < cantNino; i++) {
                    ModelFactura detalleFacNino = new ModelFactura();
                    detalleFacNino.setDet_cantidad(cantNino);
                    detalleFacNino.setDet_total(totalNino);
                    detalleFacNino.setDet_idenca(idEncabezado);
                    detalleFacNino.setDet_idticket(idNino);
//                        listaDetalleNino.add(detalleFacNino);

                    detalleFacNino.setDetalle();
//                    }
                }

                //Det_adulto
//                List<factura> listaDetalleAdulto = new ArrayList<>();
                if (Double.parseDouble(vistaVenta.getTxtCantidadAdulto().getText()) != 0) {
//                for (int i = 0; i < cantAdulto; i++) {
                    ModelFactura detalleFacAdulto = new ModelFactura();
                    detalleFacAdulto.setDet_cantidad(cantAdulto);
                    detalleFacAdulto.setDet_total(totalAdulto);
                    detalleFacAdulto.setDet_idenca(idEncabezado);
                    detalleFacAdulto.setDet_idticket(idAdulto);
//                    listaDetalleAdulto.add(detalleFacAdulto);

                    detalleFacAdulto.setDetalle();
                }

                //Det_adultoMayor
//                List<factura> listaDetalleAdultoMayor = new ArrayList<>();
                if (Double.parseDouble(vistaVenta.getTxtCantidadAdulto().getText()) != 0) {
//                for (int i = 0; i < cantAdultoMayor; i++) {
                    ModelFactura detalleFacAdulMayor = new ModelFactura();
                    detalleFacAdulMayor.setDet_cantidad(cantAdultoMayor);
                    detalleFacAdulMayor.setDet_total(totalAdultoMayor);
                    detalleFacAdulMayor.setDet_idenca(idEncabezado);
                    detalleFacAdulMayor.setDet_idticket(idAdultoMayor);
//                    listaDetalleAdultoMayor.add(detalleFacAdulMayor);

                    detalleFacAdulMayor.setDetalle();
                }

                //PIE
                ModelFactura pieFac = new ModelFactura();
                double pieSubTotal = Double.parseDouble(vistaVenta.getTxtSUBTOTAL().getText()),
                        pieDescuento = Double.parseDouble(vistaVenta.getTxtDESCUENTO().getText()),
                        pieTotal = Double.parseDouble(vistaVenta.getTxtTOTAL().getText());
                pieFac.setPie_subTotal(pieSubTotal);
                pieFac.setPie_descuento(pieDescuento);
                pieFac.setPie_TOTAL(pieTotal);
                pieFac.setPie_idEnca(idEncabezado);

                pieFac.setPie();

                JOptionPane.showMessageDialog(vistaVenta, "Compra Registrada con exito");
                imprimeFactura(idEncabezado);
                datosInicial();

            } 
        }else {
                JOptionPane.showMessageDialog(vistaVenta, "No se a realizado ninguna compra");
            }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    KeyListener buscarcliente = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            llenarDatos(vistaVenta.getTxtCedulaCliente().getText().trim());
        }
    };

    public void datosInicial() {
        Date fecha = java.sql.Date.valueOf(LocalDate.now());
        vistaVenta.getTxtidclienteNB().setText("");
        vistaVenta.getTxtCedulaCliente().setText("");
        vistaVenta.getTxtNombreCliente().setText("");
        vistaVenta.getTxtApellidoCliente().setText("");
        vistaVenta.getTxtCorreoCliente().setText("");
        vistaVenta.getTxtTelefonoCliente().setText("");
        vistaVenta.getTxtDireccionCliente().setText("");

        vistaVenta.getTxtfecha().setText(formatofecha.format(fecha));
        vistaVenta.getTxtCantidadNiño().setText("0");
        vistaVenta.getTxtCantidadAdulto().setText("0");
        vistaVenta.getTxtCantidadAdultoMayor().setText("0");
        vistaVenta.getTxtTotalAdulto().setText("0.00");
        vistaVenta.getTxtTotalNiño().setText("0.00");
        vistaVenta.getTxtTotalAdultoMayor().setText("0.00");
        vistaVenta.getTxtTOTAL().setText("0.00");
        vistaVenta.getTxtDESCUENTO().setText("0");
        vistaVenta.getTxtSUBTOTAL().setText("0.00");

        vistaVenta.getTxtidclienteNB().setEditable(false);
//        vistaVenta.getTxtCedulaCliente().setEditable(false);
        vistaVenta.getTxtNombreCliente().setEditable(false);
        vistaVenta.getTxtApellidoCliente().setEditable(false);
        vistaVenta.getTxtCorreoCliente().setEditable(false);
        vistaVenta.getTxtTelefonoCliente().setEditable(false);
        vistaVenta.getTxtDireccionCliente().setEditable(false);
    }

    //MAS
    public void masNiño() {
        int cant = Integer.parseInt(vistaVenta.getTxtCantidadNiño().getText());
        cant = cant + 1;
        vistaVenta.getTxtCantidadNiño().setText(String.valueOf(cant));
        totalNino();
        calcularSubTOTAL();
//        decuentos();
    }

    public void masAdulto() {
        int cant = Integer.parseInt(vistaVenta.getTxtCantidadAdulto().getText());
        cant = cant + 1;
        vistaVenta.getTxtCantidadAdulto().setText(String.valueOf(cant));
        totalAdulto();
        calcularSubTOTAL();
//        decuentos();
    }

    public void masAdultoMayor() {
        int cant = Integer.parseInt(vistaVenta.getTxtCantidadAdultoMayor().getText());
        cant = cant + 1;
        vistaVenta.getTxtCantidadAdultoMayor().setText(String.valueOf(cant));
        totalAdultoMayor();
        calcularSubTOTAL();
//        decuentos();
    }

    //MENOS
    public void menosNiño() {
        int cant = Integer.parseInt(vistaVenta.getTxtCantidadNiño().getText());
        cant = cant - 1;
        if (cant < 0) {
            cant = 0;
        }
        vistaVenta.getTxtCantidadNiño().setText(String.valueOf(cant));
        totalNino();
        calcularSubTOTAL();
//        decuentos();
    }

    public void menosAdulto() {
        int cant = Integer.parseInt(vistaVenta.getTxtCantidadAdulto().getText());
        cant = cant - 1;
        if (cant < 0) {
            cant = 0;
        }
        vistaVenta.getTxtCantidadAdulto().setText(String.valueOf(cant));
        totalAdulto();
        calcularSubTOTAL();
//        decuentos();
    }

    public void menosAdultoMayor() {
        int cant = Integer.parseInt(vistaVenta.getTxtCantidadAdultoMayor().getText());
        cant = cant - 1;
        if (cant < 0) {
            cant = 0;
        }
        vistaVenta.getTxtCantidadAdultoMayor().setText(String.valueOf(cant));
        totalAdultoMayor();
        calcularSubTOTAL();
//        decuentos();
    }

    //////PRECIOS
    public void cargarPrecios() {
        ModelTickets tic = new ModelTickets();

        List<Tickets> listaT = tic.getTickets();
        listaT.stream().forEach(ticket -> {
            switch (ticket.getTic_id()) {
                case 1:
                    vistaVenta.getTxtPrecioAdulto().setText(String.valueOf(ticket.getTic_precio()));
                    precioIniAdulto = ticket.getTic_precio();
                    break;
                case 2:
                    vistaVenta.getTxtPrecioNiño().setText(String.valueOf(ticket.getTic_precio()));
                    precioIniNino = ticket.getTic_precio();
                    break;
                case 3:
                    vistaVenta.getTxtPrecioAdultoMayor().setText(String.valueOf(ticket.getTic_precio()));
                    precioIniAdultoMayor = ticket.getTic_precio();
                    break;
            }
        });
    }

    ////TOTAL
    public void totalNino() {
        int cantidad = Integer.parseInt(vistaVenta.getTxtCantidadNiño().getText());
        totalIniNino = precioIniNino * cantidad;
        vistaVenta.getTxtTotalNiño().setText(String.valueOf(totalIniNino));
    }

    public void totalAdulto() {
        int cantidad = Integer.parseInt(vistaVenta.getTxtCantidadAdulto().getText());
        totalIniAdulto = precioIniAdulto * cantidad;
        vistaVenta.getTxtTotalAdulto().setText(String.valueOf(totalIniAdulto));
    }

    public void totalAdultoMayor() {
        int cantidad = Integer.parseInt(vistaVenta.getTxtCantidadAdultoMayor().getText());
        totalIniAdultoMayor = precioIniAdultoMayor * cantidad;
        vistaVenta.getTxtTotalAdultoMayor().setText(String.valueOf(totalIniAdultoMayor));
    }

    public void calcularSubTOTAL() {
        double subtotalnino = Double.parseDouble(vistaVenta.getTxtTotalNiño().getText()),
                subtotaladulto = Double.parseDouble(vistaVenta.getTxtTotalAdulto().getText()),
                subtotaladultomayor = Double.parseDouble(vistaVenta.getTxtTotalAdultoMayor().getText());

        double subtotal = subtotaladulto + subtotaladultomayor + subtotalnino;
        subTOTAL = subtotal;
        vistaVenta.getTxtSUBTOTAL().setText(String.valueOf(subTOTAL));
        decuentos();
    }

    public void decuentos() {
//        double subtotal = Double.parseDouble(vistaVenta.getTxtSUBTOTAL().getText());
        double descuento = 0;
        DESCUENTO = 0;
        if (subTOTAL >= 20 && subTOTAL < 30) {
            descuento = 0.05;
//            TOTAL = subTOTAL * descuento;
        } else {
            if (subTOTAL >= 30 && subTOTAL < 40) {
                descuento = 0.1;

            } else {
                if (subTOTAL >= 40 && subTOTAL < 50) {
                    descuento = 0.15;
//                    TOTAL = subTOTAL * descuento;
                } else {
                    if (subTOTAL >= 50) {
                        descuento = 0.2;
//                    TOTAL = subTOTAL * descuento;
                    }
                }
            }
        }

        DESCUENTO = subTOTAL * descuento;
        TOTALDESC = subTOTAL - DESCUENTO;
        vistaVenta.getTxtDESCUENTO().setText(String.valueOf(descuento * 100));
        vistaVenta.getTxtTOTAL().setText(String.valueOf(TOTALDESC));
    }

    public boolean llenarDatos(String cedula) {
//        String cedula = 
        List<Cliente> listap = modelCliente.getClientesFac(cedula);
        listap.stream().forEach(cli -> {
//            System.out.println(cedula + "==" + cli.getCli_cedula());
            if (cedula.equalsIgnoreCase(cli.getCli_cedula())) {
                vistaVenta.getTxtidclienteNB().setText(String.valueOf(cli.getCli_id()));
                vistaVenta.getTxtCedulaCliente().setText(cli.getCli_cedula());
                vistaVenta.getTxtNombreCliente().setText(cli.getNombre());
                vistaVenta.getTxtApellidoCliente().setText(cli.getApellido());
                vistaVenta.getTxtCorreoCliente().setText(cli.getCorreo());
                vistaVenta.getTxtTelefonoCliente().setText(cli.getTelefono());
                vistaVenta.getTxtDireccionCliente().setText(cli.getCli_direccion());
            }
        });
        if (listap.isEmpty()) {
            vistaVenta.getTxtidclienteNB().setText("");
//                vistaVenta.getTxtCedulaCliente().setText("");
            vistaVenta.getTxtNombreCliente().setText("");
            vistaVenta.getTxtApellidoCliente().setText("");
            vistaVenta.getTxtCorreoCliente().setText("");
            vistaVenta.getTxtTelefonoCliente().setText("");
            vistaVenta.getTxtDireccionCliente().setText("");

        }
        return true;
    }

    //REGISTRO CLIENTE
    public void registroCliente() {
        //Instancio las clases del modelo y la vista        
        ModelCliente mc = new ModelCliente();
        viewRegistrarCliente vRc = new viewRegistrarCliente();

        //Agragar vista al desktop pane
        vRc.setName("Registro");
        vistaP.getjDPprincipal().add(vRc);
        vRc.getTxtcedula().setText(vistaVenta.getTxtCedulaCliente().getText().trim());
        ControllerRegistrarCliente ccli = new ControllerRegistrarCliente(vRc, mc, vistaVenta);
//        ControllerRegistrarCliente ccli = new ControllerRegistrarCliente(vRc, mc);
        ccli.iniciarControl();
//        llenarDatos(vistaVenta.getTxtCedulaCliente().getText());
    }

    public void limpiarCampos() {
        vistaVenta.getTxtidclienteNB().setText("");
        vistaVenta.getTxtCedulaCliente().setText("");
        vistaVenta.getTxtNombreCliente().setText("");
        vistaVenta.getTxtApellidoCliente().setText("");
        vistaVenta.getTxtCorreoCliente().setText("");
        vistaVenta.getTxtTelefonoCliente().setText("");
        vistaVenta.getTxtDireccionCliente().setText("");
        datosInicial();
    }

    public void imprimeFactura(int idFactura) {
        //Instanciamos la conexion proyecto
        modelPGconexion con = new modelPGconexion();

        JasperReport jr;
        try {
            //jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportes/FACTURA.jasper"));//sacar imagenes
            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/view/reportesH/FACTURA.jasper"));//sacar imagenes
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("IdEncabezado", idFactura);

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());//llena el reporte con datos.
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(ControllerVistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
