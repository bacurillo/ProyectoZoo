/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Bryan
 */
public class modelZoologo extends Zoologo {

    modelPGconexion mpgc = new modelPGconexion();
    modelEmpleado me = new modelEmpleado();

    public modelZoologo() {
    }

    public modelZoologo(int idZoo, String rama, int idEmpleadoZoo, boolean estadoZol) {
        super(idZoo, rama, idEmpleadoZoo, estadoZol);
    }

    public boolean setZoologo() {
//        System.out.println("ID ZOOLOGO="+is);
        String sql = "INSERT INTO public.zoologo (zol_rama, zol_idempleado,zol_estado)"
                + "values('" + getRama() + "'," + getIdEmpleadoZoo() + "," + isEstadoZol()+ ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean deleteZoologo(int codigo) {
        String sql = "UPDATE public.zoologo SET zol_estado=false where zol_idempleado=" + codigo;
        return mpgc.accion(sql);
    }

    public boolean updateZoologo(String cedula) {
        String sql;
        sql = "UPDATE public.zoologo SET zol_rama='" + getRama() + "'"
                + "WHERE zol_idempleado=" + me.obtenerIdEmp(cedula);
        return mpgc.accion(sql);
    }

    public String obtenerDatosRol(int codigo) {
        String DatoRol = "";
        String sql = "select zol_rama from public.zoologo where zol_idempleado=" + codigo;
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

    public List<Zoologo> busquedaincremental(String busqueda) {
        List<Zoologo> listaZoologo = new ArrayList<>();
        String sql = "select z.zol_id,(p.per_nombre||' '||p.per_apellido) as nombre ,z.zol_rama"
                + " from public.zoologo z join public.empleado e on(e.emp_id=z.zol_idempleado)"
                + " join public.persona p on (e.emp_cedula=p.per_cedula)"
                + " where z.zol_estado=true and e.emp_estado=true and p.per_estado=true "
                + "  and (lower(p.per_nombre) like '%" + busqueda + "%' "
                + "  or lower(p.per_apellido) like '%" + busqueda + "%' "
                + "  or lower(z.zol_rama) like '%" + busqueda + "%') ";
                //                + "  or a.ali_precio=" + busqueda

        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Zoologo zoologo = new Zoologo();
                zoologo.setIdZoo(rs.getInt(1));
                zoologo.setNombre(rs.getString(2));
                zoologo.setRama(rs.getString(3));

                listaZoologo.add(zoologo);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaZoologo;
    }
}
