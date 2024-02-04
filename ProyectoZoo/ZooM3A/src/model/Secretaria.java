/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bryan
 */
public class Secretaria {

    private int idSecretaria;
    private int experiencia;
    private int idEmpleado;
    private boolean estadoSec;

    public Secretaria() {
    }

    public Secretaria(int idSecretaria, int experiencia, int idEmpleado, boolean estadoSec) {
        this.idSecretaria = idSecretaria;
        this.experiencia = experiencia;
        this.idEmpleado = idEmpleado;
        this.estadoSec = estadoSec;
    }

    public boolean isEstadoSec() {
        return estadoSec;
    }

    public void setEstadoSec(boolean estadoSec) {
        this.estadoSec = estadoSec;
    }



    public int getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(int idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
    
}
