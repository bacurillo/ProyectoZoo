/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class modelPersona extends Persona {

    modelPGconexion mpgc = new modelPGconexion();

    public modelPersona() {
    }

    public modelPersona(String cedula, String nombre, String apellido, String correo, String telefono, Date fechaRegistro, boolean estadoPer) {
        super(cedula, nombre, apellido, correo, telefono, fechaRegistro, estadoPer);
    }

    public boolean setPersona() {
        String sql = "INSERT INTO public.persona (per_cedula, per_nombre, per_apellido, per_fecha_registro, per_correo,per_telefono,per_estado)"
                + "values('" + getCedula() + "','" + getNombre() + "','" + getApellido() + "','" + getFechaRegistro() + "','"+ getCorreo() + "','"+  getTelefono() + "'," + isEstadoPer() + ")";
        System.out.println("persona");
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean updatePersona() {
        String sql;
        sql = "UPDATE public.persona SET per_nombre='" + getNombre() + "', per_apellido='" + getApellido() + "',per_correo='" + getCorreo() + "',per_telefono='" + getTelefono() + "'"
                + "WHERE per_cedula='" + getCedula() + "'";
        return mpgc.accion(sql);
    }

    public boolean comprobarDuplicado(String cedula) {
        int cant = 0;
        boolean ban = true;

        String sql = "select count(*) from public.persona where per_cedula= '" + cedula + "'";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                cant = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            if (cant!=0) {
                ban=false;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }
}
