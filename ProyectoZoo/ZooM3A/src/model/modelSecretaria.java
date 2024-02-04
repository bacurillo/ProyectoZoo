/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class modelSecretaria extends Secretaria {

    modelPGconexion mpgc = new modelPGconexion();
    modelEmpleado me = new modelEmpleado();

    public modelSecretaria() {
    }

    public modelSecretaria(int idSecretaria, int experiencia, int idEmpleado, boolean estadoSec) {
        super(idSecretaria, experiencia, idEmpleado, estadoSec);
    }

    public boolean setSecretaria() {
        String sql = "INSERT INTO public.secretaria (sec_experiencia, sec_idempleado,sec_estado)"
                + "values(" + getExperiencia() + "," + getIdEmpleado() + "," + isEstadoSec() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean deleteSecretaria(int codigo) {
        String sql = "UPDATE public.secretaria SET sec_estado=false where sec_idempleado=" + codigo;
        return mpgc.accion(sql);
    }

    public boolean updateSecretaria(String cedula) {
        String sql;
        sql = "UPDATE public.secretaria SET sec_experiencia=" + getExperiencia()
                + "WHERE sec_idempleado=" + me.obtenerIdEmp(cedula);
        return mpgc.accion(sql);
    }

    public int obtenerDatosRol(int codigo) {
        int DatoRol = 0;
        String sql = "select sec_experiencia from public.secretaria where sec_idempleado=" + codigo;
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                DatoRol = rs.getInt(1);
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

}
