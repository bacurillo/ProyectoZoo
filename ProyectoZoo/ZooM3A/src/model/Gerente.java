/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ALEJO
 */
public class Gerente extends Empleado {
    
    private int idGerente;
    private String titulo;
    private int idEmpleado;
    private boolean estadoGer;

    public Gerente() {
    }

    public Gerente(int idGerente, String titulo, int idEmpleado, boolean estadoGer) {
        this.idGerente = idGerente;
        this.titulo = titulo;
        this.idEmpleado = idEmpleado;
        this.estadoGer = estadoGer;
    }

    public boolean isEstadoGer() {
        return estadoGer;
    }

    public void setEstadoGer(boolean estadoGer) {
        this.estadoGer = estadoGer;
    }



    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
