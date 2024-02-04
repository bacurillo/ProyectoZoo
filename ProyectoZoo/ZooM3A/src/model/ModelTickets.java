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
public class ModelTickets extends Tickets {

    modelPGconexion mpgc = new modelPGconexion();

    public List<Tickets> getTickets() {
        List<Tickets> listaTickets = new ArrayList<>();
        String sql = "select tic_id, tic_categoria, tic_precio from public.ticket "
                + "  order by tic_id";
        System.out.println("");
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Tickets t = new Tickets();
                t.setTic_id(rs.getInt(1));
                t.setTic_categoria(rs.getString(2));
                t.setTic_precio(rs.getDouble(3));
                listaTickets.add(t);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTickets;
    }
    
        public List<Tickets> getTicketsPrecio() {
        List<Tickets> listaTickets = new ArrayList<>();
        String sql = "select tic_id, tic_categoria, tic_precio "
                + "from public.ticket where tic_id="+getTic_id();
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Tickets t = new Tickets();
                t.setTic_id(rs.getInt(1));
                t.setTic_categoria(rs.getString(2));
                t.setTic_precio(rs.getDouble(3));
                System.out.println(t.getTic_categoria()+"= "+t.getTic_precio());
                listaTickets.add(t);
            }
        } catch (SQLException e) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTickets;
    }

    public boolean updateTicket() {
        String sql;
//        System.out.println("nuevo="+getTic_precio());
        sql = "update public.ticket set tic_precio = " + getTic_precio() + " where tic_id = " + getTic_id();
        return mpgc.accion(sql);
    }
}
