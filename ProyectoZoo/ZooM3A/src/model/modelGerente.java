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
public class modelGerente extends Gerente {

    modelPGconexion mpgc = new modelPGconexion();
    modelEmpleado me = new modelEmpleado();

    public modelGerente() {
    }

    public modelGerente(int idGerente, String titulo, int idEmpleado, boolean estadoGer) {
        super(idGerente, titulo, idEmpleado, estadoGer);
    }

    public boolean setGerente() {
        String sql = "INSERT INTO public.gerente (ger_titulo, ger_idempleado,ger_estado)"
                + "values('" + getTitulo() + "'," + getIdEmpleado() + "," + isEstadoGer() + ");";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean updateGerente(String cedula) {
        String sql;
        sql = "UPDATE public.gerente SET ger_titulo='" + getTitulo() + "'"
                + "WHERE ger_idempleado=" + me.obtenerIdEmp(cedula);
        return mpgc.accion(sql);
    }

    public boolean deleteGerente(int codigo) {
        String sql = "UPDATE public.gerente SET ger_estado=false where ger_idempleado=" + codigo;
        return mpgc.accion(sql);
    }

    public String obtenerDatosRol(int codigo) {
        String DatoRol = "";
        String sql = "select ger_titulo from public.gerente where ger_idempleado=" + codigo;
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

}
