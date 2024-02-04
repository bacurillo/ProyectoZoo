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
public class ModelAlimento extends Alimento {

    modelPGconexion mpgc = new modelPGconexion();

    public List<Alimento> getAlimento() {
        List<Alimento> listaAlimentos = new ArrayList<>();
        String sql = "select * from public.alimento a join public.proveedor p on (p.pro_id=a.ali_idproveedor)"
                + "  where ali_estado=true";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Alimento alimento = new Alimento();

                alimento.setIdalimento(rs.getInt(1));
                alimento.setPrecioAli(rs.getDouble(2));
                alimento.setNombreAli(rs.getString(3));
                alimento.setDescripcionAli(rs.getString(4));
                alimento.setEstadoAli(rs.getBoolean(5));
                alimento.setIdproveedor(rs.getInt(6));

                alimento.setId_proveedor(7);
                alimento.setCiudad_pro(rs.getString(8));
                alimento.setNombre_pro(rs.getString(9));
                alimento.setTelefono(rs.getString(10));
                alimento.setEstadoProv(rs.getBoolean(11));

                listaAlimentos.add(alimento);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAlimentos;
    }

    public boolean setAlimento() {
        String sql = "INSERT INTO public.alimento(ali_nombre,  ali_precio,ali_descripcion, ali_idproveedor, ali_estado)"
                + "VALUES ('" + getNombreAli() + "', " + getPrecioAli() + ", '" + getDescripcionAli() + "', " + getIdproveedor() + "," + isEstadoAli() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean updateAlimento() {
        String sql;
        sql = "UPDATE public.alimento "
                + "	SET ali_nombre='" + getNombreAli() + "', ali_precio=" + getPrecioAli() + ",ali_descripcion='" + getDescripcionAli() + "', ali_idproveedor=" + getIdalimento() + ", ali_estado=" + isEstadoAli()
                + "	WHERE ali_id = " + getIdalimento();
        return mpgc.accion(sql);
    }

    public boolean deleteAlimento(int id) {
        String sql;
        sql = "UPDATE public.alimento SET ali_estado=false "
                + "WHERE ali_id=" + id;
        System.out.println(sql);
        return mpgc.accion(sql);
    }

    public List<Alimento> busquedaincremental(String busqueda) {
        List<Alimento> listaAlimento = new ArrayList<>();
        String sql = "select * from public.alimento a join public.proveedor p on (p.pro_id=a.ali_idproveedor)"
                + "  where ali_estado=true "
                + "  and (p.pro_telefono like '%" + busqueda + "%' "
                //                + "  or p.pro_id=" + busqueda
                + "  or lower(p.pro_nombre) like '%" + busqueda + "%' "
                + "  or lower(p.pro_ciudad) like '%" + busqueda + "%' "
                + "  or lower(a.ali_descripcion) like '%" + busqueda + "%' "
                //                + "  or a.ali_precio=" + busqueda
                + "  or lower(a.ali_nombre) like '%" + busqueda + "%' )";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdalimento(rs.getInt(1));
                alimento.setPrecioAli(rs.getDouble(2));
                alimento.setNombreAli(rs.getString(3));
                alimento.setDescripcionAli(rs.getString(4));
                alimento.setEstadoAli(rs.getBoolean(5));
                alimento.setIdproveedor(rs.getInt(6));

                alimento.setId_proveedor(7);
                alimento.setCiudad_pro(rs.getString(8));
                alimento.setNombre_pro(rs.getString(9));
                alimento.setTelefono(rs.getString(10));
                alimento.setEstadoProv(rs.getBoolean(11));

                listaAlimento.add(alimento);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAlimento;
    }

    public List<Alimento> busquedaincrementalDlg(String busqueda) {
        List<Alimento> listaAlimento = new ArrayList<>();
        String sql = "select a.ali_id,a.ali_nombre,a.ali_precio,p.pro_nombre,a.ali_descripcion "
                + "  from public.alimento a join public.proveedor p on (p.pro_id=a.ali_idproveedor)"
                + "  where ali_estado=true "
                + "  or lower(p.pro_nombre) like '%" + busqueda + "%' "
                + "  or lower(a.ali_descripcion) like '%" + busqueda + "%' "
                + "  or lower(a.ali_nombre) like '%" + busqueda + "%' ";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdalimento(rs.getInt(1));
                alimento.setNombreAli(rs.getString(2));
                alimento.setPrecioAli(rs.getDouble(3));
                alimento.setNombre_pro(rs.getString(4));
                alimento.setDescripcionAli(rs.getString(5));

                listaAlimento.add(alimento);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAlimento;
    }
}
