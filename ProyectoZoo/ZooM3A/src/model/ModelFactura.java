/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALEJO
 */
public class ModelFactura extends factura {

    modelPGconexion mpgc = new modelPGconexion();

    public boolean setEncabezado() {
        String sql = "INSERT INTO public.fac_encabezado(enca_fecha, enca_idcliente)  "
                + "  VALUES ('" + getEnca_fecha() + "', " + getEnca_idCliente() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean setDetalle() {
        String sql = "INSERT INTO public.fac_detalle(det_cantidad, det_total, det_idenca, det_idticket)  "
                + "  VALUES (" + getDet_cantidad() + ", " + getDet_total() + ", " + getDet_idenca() + ", " + getDet_idticket() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean setPie() {
        String sql = "INSERT INTO public.fac_pie(pie_subtotal, pie_descuento, pie_total, pie_idenca)"
                + "VALUES (" + getPie_subTotal() + ", " + getPie_descuento() + ", " + getPie_TOTAL() + ", " + getPie_idEnca() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public int obtenerIdEncabezado() {
        int idEnca = 0;
        String sql = "select max(enca_id) from public.fac_encabezado";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                idEnca = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idEnca;
    }

    public List<factura> getFacturas() {
        List<factura> listaFacturas = new ArrayList<>();

        String sql = "Select enca.enca_id, enca.enca_fecha, enca.enca_idcliente,  "
                + "		cli.cli_id, cli.cli_cedula, (per.per_nombre||' '||per.per_apellido) as nombre, per.per_telefono, per.per_correo, cli.cli_direccion,  "
                + "		count(*) as Items, sum(det.det_cantidad) as cantidadTotal  ,sum(det.det_total) as sumaBoletos,  "
                + "		pie.pie_id,pie.pie_subtotal, pie.pie_descuento, pie.pie_total  "
                + "	from public.fac_encabezado enca join public.cliente cli on (enca.enca_idcliente = cli.cli_id)  "
                + "	join public.persona per on (cli.cli_cedula=per.per_cedula)  "
                + "	join public.fac_detalle det on (enca.enca_id = det.det_idenca)  "
                + "	join public.fac_pie pie on (enca.enca_id = pie.pie_idenca)  "
                + "	group by det.det_idenca,  "
                + "				enca.enca_id,enca.enca_fecha,enca.enca_idcliente,  "
                + "				pie.pie_id,pie.pie_subtotal, pie.pie_descuento, pie.pie_total,  "
                + "				cli.cli_id, cli.cli_cedula, per.per_nombre, per.per_apellido, per.per_telefono, per.per_correo, cli.cli_direccion";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                factura fac = new factura();
                //ENCABEZADO
                fac.setEnca_id(rs.getInt(1));
                fac.setEnca_fecha(rs.getDate(2));
                fac.setEnca_idCliente(rs.getInt(3));
                //CLIENTE
                fac.setCli_id(rs.getInt(4));
                fac.setCli_cedula(rs.getString(5));
                fac.setNombre(rs.getString(6));
                fac.setTelefono(rs.getString(7));
                fac.setCorreo(rs.getString(8));
                fac.setCli_direccion(rs.getString(9));
                //DETALLE
                fac.setItems(rs.getInt(10));
                fac.setCantTotal(rs.getInt(11));
                //PIE
                fac.setPie_id(rs.getInt(13));
                fac.setPie_subTotal(rs.getDouble(14));
                fac.setPie_descuento(rs.getDouble(15));
                fac.setPie_TOTAL(rs.getDouble(16));
                listaFacturas.add(fac);

            }
        } catch (SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFacturas;
    }

    public List<factura> getFacturasBuscar(String busqueda) {
        List<factura> listaFacturas = new ArrayList<>();

        String sql = "Select enca.enca_id,enca.enca_fecha,enca.enca_idcliente,  "
                + "		cli.cli_id, cli.cli_cedula, (per.per_nombre||' '||per.per_apellido) as nombre, per.per_telefono, per.per_correo, cli.cli_direccion,  "
                + "		count(*) as Items, sum(det.det_cantidad) as cantidadTotal  ,sum(det.det_total) as sumaBoletos,  "
                + "		pie.pie_id,pie.pie_subtotal, pie.pie_descuento, pie.pie_total  "
                + "	from public.fac_encabezado enca join public.cliente cli on (enca.enca_idcliente = cli.cli_id)  "
                + "	join public.persona per on (cli.cli_cedula=per.per_cedula)  "
                + "	join public.fac_detalle det on (enca.enca_id = det.det_idenca)  "
                + "	join public.fac_pie pie on (enca.enca_id = pie.pie_idenca)  "
                + "			where  cli.cli_cedula like '%" + busqueda + "%'  "
                + "     or lower(per.per_nombre) like  '%" + busqueda + "%'  "
                + "							or lower(per.per_apellido) like '%" + busqueda + "%'  "
                + "                			or per.per_telefono like '%" + busqueda + "%'  "
                + "                			or lower(cli.cli_direccion) like '%" + busqueda + "%'  "
                + "                			OR to_char(per.per_fecha_registro,'DD-MM-YYYY') LIKE  '%" + busqueda + "%'  "
                + "	group by det.det_idenca,  "
                + "				enca.enca_id,enca.enca_fecha,enca.enca_idcliente,  "
                + "				pie.pie_id,pie.pie_subtotal, pie.pie_descuento, pie.pie_total,  "
                + "				cli.cli_id, cli.cli_cedula, per.per_nombre, per.per_apellido, per.per_telefono, per.per_correo, cli.cli_direccion;";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                factura fac = new factura();
                //ENCABEZADO
                fac.setEnca_id(rs.getInt(1));
                fac.setEnca_fecha(rs.getDate(2));
                fac.setEnca_idCliente(rs.getInt(3));
                //CLIENTE
                fac.setCli_id(rs.getInt(4));
                fac.setCli_cedula(rs.getString(5));
                fac.setNombre(rs.getString(6));
                fac.setTelefono(rs.getString(7));
                fac.setCorreo(rs.getString(8));
                fac.setCli_direccion(rs.getString(9));
                //DETALLE
                fac.setItems(rs.getInt(10));
                fac.setCantTotal(rs.getInt(11));
                //PIE
                fac.setPie_id(rs.getInt(13));
                fac.setPie_subTotal(rs.getDouble(14));
                fac.setPie_descuento(rs.getDouble(15));
                fac.setPie_TOTAL(rs.getDouble(16));

                listaFacturas.add(fac);

            }
        } catch (SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFacturas;
    }

}
