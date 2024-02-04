/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;

/**
 *
 * @author ALEJO
 */
public class Proveedor {
    private int id_proveedor;
    private String ciudad_pro;
    private String nombre_pro;
    private String telefono;
    private boolean estadoProv;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String ciudad_pro, String nombre_pro, String telefono, boolean estadoPer) {
        this.id_proveedor = id_proveedor;
        this.ciudad_pro = ciudad_pro;
        this.nombre_pro = nombre_pro;
        this.telefono = telefono;
        this.estadoProv = estadoPer;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }



    public String getCiudad_pro() {
        return ciudad_pro;
    }

    public void setCiudad_pro(String ciudad_pro) {
        this.ciudad_pro = ciudad_pro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstadoProv() {
        return estadoProv;
    }

    public void setEstadoProv(boolean estadoProv) {
        this.estadoProv = estadoProv;
    }


   
}
