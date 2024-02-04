/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ALEJO
 */
public class Zoologo extends Empleado {

    private int idZoo;
    private String rama;
    private int idEmpleadoZoo;
    private boolean estadoZol;

    public Zoologo() {
    }

    public Zoologo(int idZoo, String rama, int idEmpleadoZoo, boolean estadoZol) {
        this.idZoo = idZoo;
        this.rama = rama;
        this.idEmpleadoZoo = idEmpleadoZoo;
        this.estadoZol = estadoZol;
    }

    
    public boolean isEstadoZol() {
        return estadoZol;
    }

    public void setEstadoZol(boolean estadoZol) {
        this.estadoZol = estadoZol;
    }

    public int getIdZoo() {
        return idZoo;
    }

    public void setIdZoo(int idZoo) {
        this.idZoo = idZoo;
    }

    public String getRama() {
        return rama;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    public int getIdEmpleadoZoo() {
        return idEmpleadoZoo;
    }

    public void setIdEmpleadoZoo(int idEmpleadoZoo) {
        this.idEmpleadoZoo = idEmpleadoZoo;
    }


   
}
