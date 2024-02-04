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
 * @author ASUS ROG
 */
public class ModelDieta extends Dieta {

    modelPGconexion mpgc = new modelPGconexion();

    public List<Dieta> getDieta() {
        List<Dieta> listaDieta = new ArrayList<>();
        String sql = "select d.die_id,d.die_horario,d.die_porcion,d.die_idalimento,d.die_idanimal,d.die_estado,  "
                + "		al.ali_nombre, al.ali_descripcion,  "
                + "		a.ani_nombre,a.ani_especie  "
                + "from public.dieta d join public.alimento al on (d.die_idalimento=al.ali_id)  "
                + "join public.animal a on (a.ani_id=d.die_idanimal)  "
                + "where d.die_estado=true";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Dieta dieta = new Dieta();

                dieta.setDie_id(rs.getInt(1));
                dieta.setDie_horario(rs.getString(2));
                dieta.setDie_porcion(rs.getString(3));
                dieta.setDie_idAlimento(rs.getInt(4));
                dieta.setDie_idAnimal(rs.getInt(5));
                dieta.setDie_estado(rs.getBoolean(6));

                dieta.setNombreAli(rs.getString(7));
                dieta.setDescripcionAli(rs.getString(8));

                dieta.setNombreAnimal(rs.getString(9));
                dieta.setEspecieAnimal(rs.getString(10));

                listaDieta.add(dieta);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDieta;
    }

    public boolean setDieta() {
        String sql = "INSERT INTO public.dieta(die_horario, die_porcion, die_idalimento,die_idanimal,die_estado)"
                + "VALUES ('" + getDie_horario() + "', " + getDie_porcion() + ", " + getDie_idAlimento() + ", " + getDie_idAnimal() + "," + isDie_estado() + ")";
        return mpgc.accion(sql);//EJECUTAMOS EN INSERT
    }

    public boolean updateDieta() {
        String sql;
        sql = "UPDATE public.dieta "
                + "	SET die_horario='" + getDie_horario() + "', die_porcion='" + getDie_porcion() + "',die_idalimento=" + getDie_idAlimento() + ",die_idanimal=" + getDie_idAnimal()
                + "	WHERE die_id = " + getDie_id();
        return mpgc.accion(sql);
    }

    public boolean deleteDieta(int id) {
        String sql;
        sql = "UPDATE public.dieta SET die_estado=false "
                + "WHERE die_id=" + id;
        System.out.println(sql);
        return mpgc.accion(sql);
    }

    public List<Dieta> busquedaIncrementalDieta(String busqueda) {
        List<Dieta> listaDieta = new ArrayList<>();
        String sql = "select d.die_id,d.die_horario,d.die_porcion,d.die_idalimento,d.die_idanimal,d.die_estado,  "
                + "		al.ali_nombre, al.ali_descripcion,  "
                + "		a.ani_nombre,a.ani_especie  "
                + "from public.dieta d join public.alimento al on (d.die_idalimento=al.ali_id)  "
                + "join public.animal a on (a.ani_id=d.die_idanimal)  "
                + "where d.die_estado=true  "
                + "and (lower(d.die_horario) like '%" + busqueda + "%' "
                + "or lower(a.ani_nombre) like '%" + busqueda + "%' "
                + "or lower(a.ani_especie) like '%" + busqueda + "%' "
                + "or lower(al.ali_nombre) like '%" + busqueda + "%' "
                + "or lower(al.ali_descripcion) like '%" + busqueda + "%') ";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Dieta dieta = new Dieta();

                dieta.setDie_id(rs.getInt(1));
                dieta.setDie_horario(rs.getString(2));
                dieta.setDie_porcion(rs.getString(3));
                dieta.setDie_idAlimento(rs.getInt(4));
                dieta.setDie_idAnimal(rs.getInt(5));
                dieta.setDie_estado(rs.getBoolean(6));

                dieta.setNombreAli(rs.getString(7));
                dieta.setDescripcionAli(rs.getString(8));

                dieta.setNombreAnimal(rs.getString(9));
                dieta.setEspecieAnimal(rs.getString(10));

                listaDieta.add(dieta);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelProveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDieta;
    }
}
