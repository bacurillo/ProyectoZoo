/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bryan
 */
public class Cuidador extends Empleado{
    private int idCuidador;
    private int idSecretaria;
    private String tipoSangre;
    private int idEmpleado;
    private boolean estadoCui;

    public Cuidador() {
    }

    public Cuidador(int idCuidadro, int idSecretaria, String tipoSangre, int idEmpleado, boolean estadoCui) {
        this.idCuidador = idCuidadro;
        this.idSecretaria = idSecretaria;
        this.tipoSangre = tipoSangre;
        this.idEmpleado = idEmpleado;
        this.estadoCui = estadoCui;
    }

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidadro) {
        this.idCuidador = idCuidadro;
    }

    public int getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(int idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public boolean isEstadoCui() {
        return estadoCui;
    }

    public void setEstadoCui(boolean estadoCui) {
        this.estadoCui = estadoCui;
    }

   

}
