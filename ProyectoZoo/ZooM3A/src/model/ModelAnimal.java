/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author ALEJO
 */
public class ModelAnimal extends Animales {

    public ModelAnimal() {
    }

    modelPGconexion mpgc = new modelPGconexion();

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

    public boolean setAnimal() {
        String sql;
        sql = "INSERT INTO public.animal(ani_nombre, ani_genero, ani_especie, ani_fechaingreso, ani_fechanacimiento, ani_estado, ani_idhabitad, ani_idcuidador)";
        sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setString(1, getNombreAnimal());
            ps.setString(2, getGeneroAnimal());
            ps.setString(3, getEspecieAnimal());
            ps.setDate(4, (java.sql.Date) getFecha_ingresoAnimal());
            ps.setDate(5, (java.sql.Date) getFecha_nacimientoAnimal());
            ps.setBoolean(6, isEstadoAnimal());
            ps.setInt(7, getIdhabitadAnimal());
            ps.setInt(8, getIdcuidadorAnimal());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean setFotoAnimal() {
        String sql;
        sql = "INSERT INTO public.animal(ani_nombre, ani_genero, ani_especie, ani_foto, ani_fechaingreso, ani_fechanacimiento, ani_estado, ani_idhabitad, ani_idcuidador)";
        sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setString(1, getNombreAnimal());
            ps.setString(2, getGeneroAnimal());
            ps.setString(3, getEspecieAnimal());
            ps.setBinaryStream(4, getImageFile(), getTamano());
            ps.setDate(5, (java.sql.Date) getFecha_ingresoAnimal());
            ps.setDate(6, (java.sql.Date) getFecha_nacimientoAnimal());
            ps.setBoolean(7, isEstadoAnimal());
            ps.setInt(8, getIdhabitadAnimal());
            ps.setInt(9, getIdcuidadorAnimal());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateAnimal() {
        String sql;
        sql = "UPDATE public.animal SET ani_nombre='" + getNombreAnimal() + "', ani_genero='" + getGeneroAnimal() + "', ani_especie='" + getEspecieAnimal() + "', "
                + "ani_fechaingreso='" + getFecha_ingresoAnimal() + "', ani_fechanacimiento='" + getFecha_nacimientoAnimal() + "', "
                + "ani_idhabitad=" + getIdhabitadAnimal() + ", ani_idcuidador=" + getIdcuidadorAnimal()
                + "where ani_id=" + getIdAnimal();
        return mpgc.accion(sql);
    }

    public boolean updateFotoAnimal() {
        String sql;
        sql = "UPDATE public.animal SET ani_nombre=?, ani_genero=?, ani_especie=?, "
                + "ani_foto=?, ani_fechaingreso=?, ani_fechanacimiento=?, "
                + "ani_idhabitad=?, ani_idcuidador=?"
                + "where ani_id=" + getIdAnimal();

        try {
            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setString(1, getNombreAnimal());
            ps.setString(2, getGeneroAnimal());
            ps.setString(3, getEspecieAnimal());
            ps.setBinaryStream(4, getImageFile());
            ps.setDate(5, (java.sql.Date) getFecha_ingresoAnimal());
            ps.setDate(6, (java.sql.Date) getFecha_nacimientoAnimal());
            ps.setInt(7, getIdhabitadAnimal());
            ps.setInt(8, getIdcuidadorAnimal());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteAnimal(int id) {
        String sql;
        sql = "UPDATE public.animal SET ani_estado=false "
                + "WHERE ani_id=" + id;
        return mpgc.accion(sql);
    }

    public List<Animales> getAnimal() {
        List<Animales> listaAnimales = new ArrayList<>();

        String sql = "select a.ani_id, a.ani_nombre, a.ani_genero, a.ani_especie,a.ani_foto, "//1-6
                + "     a.ani_fechaingreso, a.ani_fechanacimiento, a.ani_estado, a.ani_idhabitad, a.ani_idcuidador,  "//7-11
                + "	c.cui_tiposangre,(p.per_nombre||' '||p.per_apellido)as nombre,h.hab_ubicacion,h.hab_tipo  "//12-15
                + "from public.animal a join public.habitad h on (a.ani_idhabitad=h.hab_id)  "
                + "join public.cuidador c on (c.cui_id=a.ani_idcuidador)  "
                + "join public.empleado e on(e.emp_id=c.cui_idempleado)  "
                + "join public.persona p on (p.per_cedula=e.emp_cedula)  "
                + "where a.ani_estado=true  ";
        ResultSet rs = mpgc.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Animales animal = new Animales();
                animal.setIdAnimal(rs.getInt(1));
                animal.setNombreAnimal(rs.getString(2));
                animal.setGeneroAnimal(rs.getString(3));
                animal.setEspecieAnimal(rs.getString(4));

                bytea = rs.getBytes(5);
                if (bytea != null) {
                    animal.setFoto(getImagen(bytea));
                }

                animal.setFecha_ingresoAnimal(rs.getDate(6));
                animal.setFecha_nacimientoAnimal(rs.getDate(7));
                animal.setEstadoAnimal(rs.getBoolean(8));
                animal.setIdhabitadAnimal(rs.getInt(9));
                animal.setIdcuidadorAnimal(rs.getInt(10));
                animal.setTiposangreCuidador(rs.getString(11));
                animal.setNombreCuidador(rs.getString(12));
                animal.setUbicacionHabitat(rs.getString(13));
                animal.setTipoHabitat(rs.getString(14));
                listaAnimales.add(animal);
            }
        } catch (IOException | SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAnimales;
    }

    public List<Animales> busquedaIncremental(String busqueda) {
        List<Animales> listaAnimales = new ArrayList<>();

        String sql = "select a.ani_id, a.ani_nombre, a.ani_genero, a.ani_especie, a.ani_foto, "//1-6
                + "     a.ani_fechaingreso, a.ani_fechanacimiento, a.ani_estado, a.ani_idhabitad, a.ani_idcuidador,  "//7-11
                + "	c.cui_tiposangre,(p.per_nombre||' '||p.per_apellido)as nombre,h.hab_ubicacion,h.hab_tipo  "//12-15
                + "from public.animal a join public.habitad h on (a.ani_idhabitad=h.hab_id)  "
                + "join public.cuidador c on (c.cui_id=a.ani_idcuidador)  "
                + "join public.empleado e on(e.emp_id=c.cui_idempleado)  "
                + "join public.persona p on (p.per_cedula=e.emp_cedula)  "
                + "where a.ani_estado=true  "
                + "  and (lower(a.ani_nombre) like '%" + busqueda + "%' "
                + "  or lower(a.ani_genero) like '%" + busqueda + "%' "
                + "  or lower(a.ani_especie) like '%" + busqueda + "%' "
                + "  or lower(p.per_nombre) like '%" + busqueda + "%' "
                + "  or lower(p.per_apellido) like '%" + busqueda + "%' "
                + "  or lower(h.hab_tipo) like '%" + busqueda + "%' "
                + "  or lower(h.hab_ubicacion) like '%" + busqueda + "%' "
                + "  OR to_char(a.ani_fechanacimiento,'DD-MM-YYYY') LIKE  '%" + busqueda + "%'  )";
        ResultSet rs = mpgc.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Animales animal = new Animales();
                animal.setIdAnimal(rs.getInt(1));
                animal.setNombreAnimal(rs.getString(2));
                animal.setGeneroAnimal(rs.getString(3));
                animal.setEspecieAnimal(rs.getString(4));

                bytea = rs.getBytes(5);
                if (bytea != null) {
                    animal.setFoto(getImagen(bytea));
                }

                animal.setFecha_ingresoAnimal(rs.getDate(6));
                animal.setFecha_nacimientoAnimal(rs.getDate(7));
                animal.setEstadoAnimal(rs.getBoolean(8));
                animal.setIdhabitadAnimal(rs.getInt(9));
                animal.setIdcuidadorAnimal(rs.getInt(10));
                animal.setTiposangreCuidador(rs.getString(11));
                animal.setNombreCuidador(rs.getString(12));
                animal.setUbicacionHabitat(rs.getString(13));
                animal.setTipoHabitat(rs.getString(14));

                listaAnimales.add(animal);
            }
        } catch (IOException | SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAnimales;
    }

    public List<Animales> busquedaIncrementalDlg(String busqueda) {
        List<Animales> listaAnimales = new ArrayList<>();

        String sql = "select ani_id, ani_nombre,ani_especie  "
                + " from public.animal where ani_estado=true"
                + "  and lower(ani_nombre) like '%" + busqueda + "%' "
                + "  or lower(ani_especie) like '%" + busqueda + "%' ";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Animales animal = new Animales();
                animal.setIdAnimal(rs.getInt(1));
                animal.setNombreAnimal(rs.getString(2));
                animal.setEspecieAnimal(rs.getString(3));

                listaAnimales.add(animal);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelPGconexion.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAnimales;
    }

}
