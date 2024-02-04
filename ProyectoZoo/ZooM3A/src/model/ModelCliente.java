/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
public class ModelCliente extends Cliente {

    modelPGconexion mpgc = new modelPGconexion();

    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM public.cliente c, public.persona p "
                + "where c.cli_cedula = p.per_cedula and c.cli_estado=true ";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCli_id(rs.getInt(1));
                c.setCli_direccion(rs.getString(2));
                c.setCli_cedula(rs.getString(3));
                c.setCli_estado(rs.getBoolean(4));
                c.setCedula(rs.getString(5));
                c.setNombre(rs.getString(6));
                c.setApellido(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setCorreo(rs.getString(9));
                c.setTelefono(rs.getString(10));

                listaClientes.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    public List<Cliente> getClientesFac(String cedula) {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "select * from public.cliente c "
                + "join public.persona p on(p.per_cedula=c.cli_cedula) "
                + "where c.cli_estado=true "
                + "and "
                + "c.cli_cedula ='" + cedula + "' ";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCli_id(rs.getInt(1));
                c.setCli_direccion(rs.getString(2));
                c.setCli_cedula(rs.getString(3));
                c.setCli_estado(rs.getBoolean(4));
                c.setCedula(rs.getString(5));
                c.setNombre(rs.getString(6));
                c.setApellido(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setCorreo(rs.getString(9));
                c.setTelefono(rs.getString(10));

                listaClientes.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    public boolean setCliente() {
        String sql = "INSERT INTO public.cliente(cli_direccion,  cli_cedula,cli_estado)"
                + "VALUES ('" + getCli_direccion() + "', '" + getCli_cedula() + "', " + isCli_estado() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean updateCliente() {
        String sql;
        System.out.println(getCli_cedula());
        sql = "UPDATE public.cliente "
                + "	SET cli_direccion='" + getCli_direccion() + "', cli_cedula='" + getCli_cedula() + "', cli_estado=" + isCli_estado()
                + "	WHERE cli_cedula = '" + getCli_cedula() + "'";
        return mpgc.accion(sql);
    }

    public boolean deleteCliente(String cedula) {
        String sql;
        sql = "UPDATE public.cliente SET cli_estado=false "
                + "WHERE cli_cedula='" + cedula + "'";
        System.out.println(sql);
        return mpgc.accion(sql);
    }

    public List<Cliente> busquedaincremental(String busqueda) {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "select * from public.cliente c "
                + "join public.persona p on(p.per_cedula=c.cli_cedula) "
                + "where c.cli_estado=true "
                + "and "
                + "(p.per_cedula like '%" + busqueda + "%' "
                + "or lower(p.per_nombre) like '%" + busqueda + "%' "
                + "or lower(p.per_apellido) like '%" + busqueda + "%' "
                + "or p.per_telefono like '%" + busqueda + "%' "
                + "or lower(c.cli_direccion) like '%" + busqueda + "%' "
                + "OR to_char(p.per_fecha_registro,'DD-MM-YYYY') LIKE  '%" + busqueda + "%'  ) ";
        
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCli_id(rs.getInt(1));
                c.setCli_direccion(rs.getString(2));
                c.setCli_cedula(rs.getString(3));
                c.setCli_estado(rs.getBoolean(4));
                c.setCedula(rs.getString(5));
                c.setNombre(rs.getString(6));
                c.setApellido(rs.getString(7));
                c.setFechaRegistro(rs.getDate(8));
                c.setCorreo(rs.getString(9));
                c.setTelefono(rs.getString(10));

                listaClientes.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
}
