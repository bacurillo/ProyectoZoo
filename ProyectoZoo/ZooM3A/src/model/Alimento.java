/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ALEJO
 */
public class Alimento extends Proveedor{

    private int idalimento;
    private double precioAli;
    private String nombreAli;
    private String descripcionAli;
    private int idproveedor;
    private boolean estadoAli;

    public Alimento() {
    }

    public Alimento(int idalimento, double precioAli, String nombreAli, String descripcionAli, int idproveedor, boolean estadoAli) {
        this.idalimento = idalimento;
        this.precioAli = precioAli;
        this.nombreAli = nombreAli;
        this.descripcionAli = descripcionAli;
        this.idproveedor = idproveedor;
        this.estadoAli = estadoAli;
    }

    public int getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(int idalimento) {
        this.idalimento = idalimento;
    }

    public double getPrecioAli() {
        return precioAli;
    }

    public void setPrecioAli(double precioAli) {
        this.precioAli = precioAli;
    }

    public String getNombreAli() {
        return nombreAli;
    }

    public void setNombreAli(String nombreAli) {
        this.nombreAli = nombreAli;
    }

    public String getDescripcionAli() {
        return descripcionAli;
    }

    public void setDescripcionAli(String descripcionAli) {
        this.descripcionAli = descripcionAli;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public boolean isEstadoAli() {
        return estadoAli;
    }

    public void setEstadoAli(boolean estadoAli) {
        this.estadoAli = estadoAli;
    }

   
}
