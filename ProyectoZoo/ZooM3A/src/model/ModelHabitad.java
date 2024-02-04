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
public class ModelHabitad extends Habitat {

    modelPGconexion mpgc = new modelPGconexion();

    public List<Habitat> getHabitad() {
        List<Habitat> listaHabitad = new ArrayList<>();
        String sql = "SELECT h.hab_id,h.hab_tipo,h.hab_ubicacion,hab_capacidad,(p.per_nombre||' '||p.per_apellido) as nombre,z.zol_rama,z.zol_id "
                + "FROM public.habitad h  "
                + "join public.zoologo z on(h.hab_idzoologo=z.zol_id) "
                + "join public.empleado e on(e.emp_id=z.zol_idempleado) "
                + "join public.persona p on(p.per_cedula=e.emp_cedula) "
                + "  where h.hab_estado=true";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Habitat habitad = new Habitat();

                habitad.setId_habitat(rs.getInt(1));
                habitad.setTipohab(rs.getString(2));
                habitad.setUbicacionhab(rs.getString(3));
                habitad.setCapacidadhap(rs.getInt(4));
                habitad.setNombre(rs.getString(5));
                habitad.setRama(rs.getString(6));
                habitad.setIdZoologohab(rs.getInt(7));

                listaHabitad.add(habitad);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaHabitad;
    }

    public boolean setHabitad() {
        String sql = "INSERT INTO public.habitad(hab_tipo, hab_capacidad, hab_idzoologo, hab_ubicacion, hab_estado)"
                + "VALUES ('" + getTipohab() + "', " + getCapacidadhap() + ", " + getIdZoologohab() + ", '" + getUbicacionhab() + "'," + isEstadohab() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean updateHabitad() {
        String sql;
        sql = "UPDATE public.habitad "
                + "	SET hab_tipo='" + getTipohab() + "', hab_capacidad=" + getCapacidadhap() + ",hab_idzoologo=" + getIdZoologohab() + ", hab_ubicacion='" + getUbicacionhab() + "', hab_estado=" + isEstadohab()
                + "	WHERE hab_id = " + getId_habitat();
        return mpgc.accion(sql);
    }

    public boolean deleteHabitad(int id) {
        String sql;
        sql = "UPDATE public.habitad SET hab_estado=false "
                + "WHERE hab_id=" + id;
//        System.out.println(sql);
        return mpgc.accion(sql);
    }

    public List<Habitat> busquedaincremental(String busqueda) {
        List<Habitat> listaHabitad = new ArrayList<>();
        String sql = "SELECT h.hab_id,h.hab_tipo,h.hab_ubicacion,hab_capacidad,(p.per_nombre||' '||p.per_apellido) as nombre,z.zol_rama,z.zol_id  "
                + "FROM public.habitad h  "
                + "join public.zoologo z on(h.hab_idzoologo=z.zol_id) "
                + "join public.empleado e on(e.emp_id=z.zol_idempleado) "
                + "join public.persona p on(p.per_cedula=e.emp_cedula) "
                + "  where h.hab_estado=true"
                + "  and lower(h.hab_tipo) like '%" + busqueda + "%' "
                + "  or (lower(h.hab_ubicacion) like '%" + busqueda + "%' "
                + "  or lower(p.per_nombre) like '%" + busqueda + "%' "
                + "  or lower(p.per_apellido) like '%" + busqueda + "%' "
                + "  or lower(z.zol_rama) like '%" + busqueda + "%' )";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Habitat habitad = new Habitat();

                habitad.setId_habitat(rs.getInt(1));
                habitad.setTipohab(rs.getString(2));
                habitad.setUbicacionhab(rs.getString(3));
                habitad.setCapacidadhap(rs.getInt(4));
                habitad.setNombre(rs.getString(5));
                habitad.setRama(rs.getString(6));
                habitad.setIdZoologohab(rs.getInt(7));

                listaHabitad.add(habitad);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaHabitad;
    }

    public List<Habitat> busquedaincrementalDlg(String busqueda) {
        List<Habitat> listaHabitad = new ArrayList<>();
        String sql = "SELECT h.hab_id,h.hab_tipo,h.hab_ubicacion  "
                + "FROM public.habitad h  "
                + "  where h.hab_estado=true"
                + "  and lower(h.hab_tipo) like '%" + busqueda + "%' "
                + "  or lower(h.hab_ubicacion) like '%" + busqueda + "%' ";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Habitat habitad = new Habitat();

                habitad.setId_habitat(rs.getInt(1));
                habitad.setTipohab(rs.getString(2));
                habitad.setUbicacionhab(rs.getString(3));

                listaHabitad.add(habitad);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaHabitad;
    }
}
