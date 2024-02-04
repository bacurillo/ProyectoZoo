/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Bryan
 */
public class modelEmpleado extends Empleado {

    modelPGconexion mpgc = new modelPGconexion();

    public modelEmpleado() {
    }

    public modelEmpleado(int idEmp, Date fechanacimiento, int rol, String usuario, String contraseña, String cedulaEmp, String genero, boolean estadoEmp, Image foto, FileInputStream imageFile, int tamano) {
        super(idEmp, fechanacimiento, rol, usuario, contraseña, cedulaEmp, genero, estadoEmp, foto, imageFile, tamano);
    }

    public boolean setEmpleado() {
        String sql = "INSERT INTO public.empleado(emp_fechanacimiento, emp_rol, emp_genero, emp_usuario, emp_contraseña, emp_cedula,emp_estado)"
                + "VALUES ('" + getFechanacimiento() + "', '" + getRol() + "', '" + getGenero() + "', '" + getUsuario() + "', '" + getContraseña() + "', '" + getCedula() + "', " + isEstadoEmp() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean setFotoEmpleado() {
        String sql;
        sql = "INSERT INTO public.empleado(emp_foto, emp_fechanacimiento, emp_rol, emp_genero, emp_usuario, emp_contraseña, emp_cedula,emp_estado)";
        sql += "VALUES(?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setBinaryStream(1, getImageFile(), getTamano());
            ps.setDate(2, (java.sql.Date) getFechanacimiento());
            ps.setInt(3, getRol());
            ps.setString(4, getGenero());
            ps.setString(5, getUsuario());
            ps.setString(6, getContraseña());
            ps.setString(7, getCedula());
            ps.setBoolean(8, isEstadoEmp());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateEmpleado() {
        String sql;
        sql = "UPDATE public.empleado SET emp_fechanacimiento='" + getFechanacimiento() + "', "
                + "emp_rol=" + getRol() + ", emp_genero='" + getGenero() + "', emp_usuario='" + getUsuario() + "', emp_contraseña='" + getContraseña() + "' "
                + "WHERE emp_cedula='" + getCedula() + "'";
        return mpgc.accion(sql);
    }

    public boolean updateFotoEmpleado() {
        String sql;
        sql = "UPDATE public.empleado SET emp_foto=?, emp_fechanacimiento=?, "
                + "emp_rol=?, emp_genero=?, emp_usuario=?, emp_contraseña=? "
                + "WHERE emp_cedula='" + getCedula() + "'";
//        sql += "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setBinaryStream(1, getImageFile());
            ps.setDate(2, (java.sql.Date) getFechanacimiento());
            ps.setInt(3, getRol());
            ps.setString(4, getGenero());
            ps.setString(5, getUsuario());
            ps.setString(6, getContraseña());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteZoologo(int codigo, String cedula) {

        String sql = "SELECT eliminarzoologo(" + codigo + " , '" + cedula + "')";
        return mpgc.accion(sql);//EJECUTAMOS EN DELETE
    }

    public boolean deleteGerente(int codigo, String cedula) {
        String sql = "SELECT eliminargerente(" + codigo + " , '" + cedula + "')";
        return mpgc.accion(sql);//EJECUTAMOS EN DELETE
    }

    public boolean deletesecretaria(int codigo, String cedula) {
        String sql = "SELECT eliminarsecretaria(" + codigo + " , '" + cedula + "')";
        return mpgc.accion(sql);//EJECUTAMOS EN DELETE
    }

    public boolean deletecuidador(int codigo, String cedula) {
        String sql = "SELECT eliminarcuidador(" + codigo + " , '" + cedula + "')";
        return mpgc.accion(sql);//EJECUTAMOS EN DELETE
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
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRoles;
    }

    public int obtenerIdEmp(String cedula) {
        int codigo = 0;
        String sql = "select emp_id from public.empleado where emp_cedula = '" + cedula + "'";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    public String obtenerRol(int codigo) {
        String rol = "";
        String sql = "select rol_nombre from public.rol where rol_id=" + codigo;
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                rol = rs.getString(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rol;
    }

    private Image getImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader imageReader = (ImageReader) it.next();
        Object source = bais;
        ImageInputStream fis = ImageIO.createImageInputStream(source);
        imageReader.setInput(fis, true);
        ImageReadParam param = imageReader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return imageReader.read(0, param);
    }

    public List<Empleado> getempleadoLogin(String usuario, String contrasena) {
        List<Empleado> listaEmpleado = new ArrayList<>();

        String sql = "select (p.per_nombre||' '|| p.per_apellido) as nombre,p.per_cedula, r.rol_nombre, e.emp_foto  "
                + "  from public.empleado e join public.persona p on(e.emp_cedula=p.per_cedula) "
                + "  join public.rol r on (r.rol_id=emp_rol) "
                + "  where e.emp_usuario = '" + usuario + "' and e.emp_contraseña = '" + contrasena + "'";
        ResultSet rs = mpgc.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setNombre(rs.getString(1));
                empleado.setCedula(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                bytea = rs.getBytes(4);
                if (bytea != null) {
                    empleado.setFoto(getImagen(bytea));
                }

                listaEmpleado.add(empleado);

            }
        } catch (IOException | SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEmpleado;
    }

    public List<Empleado> getempleado() {
        List<Empleado> listaEmpleado = new ArrayList<>();

        String sql = "select * from public.persona p join public.empleado e on(p.per_cedula= e.emp_cedula) "
                + "  where e.emp_estado=true  and p.per_estado=true ";
        ResultSet rs = mpgc.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCedula(rs.getString(1));
                empleado.setNombre(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                empleado.setFechaRegistro(rs.getDate(4));
                empleado.setCorreo(rs.getString(5));
                empleado.setTelefono(rs.getString(6));
                empleado.setEstadoEmp(rs.getBoolean(7));
                empleado.setIdEmp(rs.getInt(8));
                bytea = rs.getBytes(9);
                if (bytea != null) {
                    empleado.setFoto(getImagen(bytea));
                }
                empleado.setFechanacimiento(rs.getDate(10));
                empleado.setRol(rs.getInt(11));
                empleado.setGenero(rs.getString(12));
                empleado.setUsuario(rs.getString(13));
                empleado.setContraseña(rs.getString(14));
                empleado.setCedulaEmp(rs.getString(15));

                listaEmpleado.add(empleado);

            }
        } catch (IOException | SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEmpleado;
    }

    public List<Empleado> busquedaIncrementalPersona(String busqueda) {
        List<Empleado> listaEmpleado = new ArrayList<>();

        String sql = "select * from public.persona p "
                + "join public.empleado e on(p.per_cedula=e.emp_cedula) "
                + "join public.rol r on(e.emp_rol=r.rol_id) "
                + "where e.emp_estado=true and p.per_estado=true "
                + "and (p.per_cedula like '%" + busqueda + "%' "
                + "or lower(p.per_nombre) like '%" + busqueda + "%' "
                + "or lower(p.per_apellido) like '%" + busqueda + "%' "
                + "or p.per_telefono like '%" + busqueda + "%' "
                + "or lower(e.emp_usuario) like '%" + busqueda + "%' "
                + "or lower(e.emp_genero) like '%" + busqueda + "%' "
                + "or lower(r.rol_nombre) like '%" + busqueda + "%' "
                + "OR to_char(e.emp_fechanacimiento,'DD-MM-YYYY')  LIKE  '%" + busqueda + "%' "
                + "OR to_char(p.per_fecha_registro,'DD-MM-YYYY') LIKE  '%" + busqueda + "%'  ) ";

        ResultSet rs = mpgc.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCedula(rs.getString(1));
                empleado.setNombre(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                empleado.setFechaRegistro(rs.getDate(4));
                empleado.setCorreo(rs.getString(5));
                empleado.setTelefono(rs.getString(6));
                empleado.setEstadoEmp(rs.getBoolean(7));
                empleado.setIdEmp(rs.getInt(8));
                bytea = rs.getBytes(9);
                if (bytea != null) {
                    empleado.setFoto(getImagen(bytea));
                }
                empleado.setFechanacimiento(rs.getDate(10));
                empleado.setRol(rs.getInt(11));
                empleado.setGenero(rs.getString(12));
                empleado.setUsuario(rs.getString(13));
                empleado.setContraseña(rs.getString(14));
                empleado.setCedulaEmp(rs.getString(15));

                listaEmpleado.add(empleado);
            }
        } catch (IOException | SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEmpleado;
    }
}
