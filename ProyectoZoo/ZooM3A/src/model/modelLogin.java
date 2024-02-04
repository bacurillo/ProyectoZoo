/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Bryan
 */
public class modelLogin extends Empleado {

    modelPGconexion mpgc = new modelPGconexion();

    public modelLogin() {
    }

    public modelLogin(int idEmp, Date fechanacimiento, int rol, String usuario, String contraseña, String cedulaEmp, String genero, boolean estadoEmp, Image foto, FileInputStream imageFile, int tamano) {
        super(idEmp, fechanacimiento, rol, usuario, contraseña, cedulaEmp, genero, estadoEmp, foto, imageFile, tamano);
    }

    public List<rol> getroles() {
        List<rol> listaRoles = new ArrayList<>();
        String sql = "select rol_id, rol_nombre from public.rol";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                rol mirol = new rol();
                mirol.setIdRol(rs.getInt(1));
                mirol.setNombre(rs.getString(2));
                listaRoles.add(mirol);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRoles;
    }

    public boolean comprobarLogin(String usuario, String contrasena) {
        boolean ban = false;
        int count = 0;
        String sql = "select count(*) from public.empleado where emp_usuario='" + usuario + "' and emp_contraseña='" + contrasena + "' and emp_estado=true";
        ResultSet rs = mpgc.consulta(sql);

        try {

            while (rs.next()) {
                count = rs.getInt(1);                
            }
            if (count != 0) {
                ban = true;
            }

        } catch (SQLException e) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }

    public boolean comprobarUsuario(String usuario) {
        String sql = "select count(*) from public.empleado where emp_usuario='" + usuario + "'and emp_estado=true";
        ResultSet rs = mpgc.consulta(sql);
        boolean ban = false;
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count != 0) {
                ban = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }

    public boolean comprobarContrasena(String contrasena) {
        String sql = "select count(*) from public.empleado where  emp_contraseña='" + contrasena + "'and emp_estado=true";
        ResultSet rs = mpgc.consulta(sql);
        modelEmpleado empleado = new modelEmpleado();
        boolean ban = false;
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 1) {
                ban = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }
}
