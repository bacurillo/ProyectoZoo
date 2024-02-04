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
 * @author Bryan
 */
public class modelCuidador extends Cuidador {

    modelPGconexion mpgc = new modelPGconexion();
    modelEmpleado me = new modelEmpleado();

    public modelCuidador() {
    }


    public boolean setCuidador() {
        String sql = "INSERT INTO public.cuidador (cui_tiposangre, cui_idempleado,cui_estado)"
                + "values('" + getTipoSangre() + "'," + getIdEmpleado() + "," + isEstadoCui() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean deleteCuidador(int codigo) {
        String sql = "UPDATE public.cuidador SET cui_estado=false where cui_idempleado=" + codigo;
        return mpgc.accion(sql);
    }

    public boolean updateCuidador(String cedula) {
        String sql;
        sql = "UPDATE public.cuidador SET cui_tiposangre='" + getTipoSangre() + "'"
                + "WHERE cui_idempleado=" + me.obtenerIdEmp(cedula);
        return mpgc.accion(sql);
    }

    public String obtenerDatosRol(int codigo) {
        String DatoRol = "";
        String sql = "select cui_tiposangre from public.cuidador where cui_idempleado=" + codigo;
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                DatoRol = rs.getString(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DatoRol;
    }

    public List<Cuidador> busquedaincremental(String busqueda) {
        List<Cuidador> listaCuidador = new ArrayList<>();
        String sql = "select c.cui_id,(p.per_nombre||' '||p.per_apellido) as nombre ,c.cui_tiposangre,c.cui_estado"
                + " from public.cuidador c join public.empleado e on(e.emp_id=c.cui_idempleado)"
                + " join public.persona p on (e.emp_cedula=p.per_cedula) "
                + "  where c.cui_estado=true and e.emp_estado=true and p.per_estado=true"
                + "  and (lower(p.per_nombre) like '%" + busqueda + "%' "
                + "  or lower(p.per_apellido) like '%" + busqueda + "%' "
                + "  or lower(c.cui_tiposangre) like '%" + busqueda + "%' ) ";

        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Cuidador cuidador = new Cuidador();
                cuidador.setIdCuidador(rs.getInt(1));
                cuidador.setNombre(rs.getString(2));
                cuidador.setTipoSangre(rs.getString(3));
                cuidador.setEstadoCui(rs.getBoolean(4));

                listaCuidador.add(cuidador);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCuidador;
    }
}
