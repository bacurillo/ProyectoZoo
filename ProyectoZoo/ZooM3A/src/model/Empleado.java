/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.Date;

/**
 *
 * @author ALEJO
 */
public class Empleado extends Persona {

    private int idEmp;
    private Date fechanacimiento;
    private int rol;
    private String usuario;
    private String contraseña;
    private String cedulaEmp;
    private String genero;
    private boolean estadoEmp;
    //foto
    private Image foto;
    //guardar foto
    private FileInputStream imageFile;
    private int tamano;

    public Empleado() {
    }

    public Empleado(int idEmp, Date fechanacimiento, int rol, String usuario, String contraseña, String cedulaEmp, String genero, boolean estadoEmp, Image foto, FileInputStream imageFile, int tamano) {
        this.idEmp = idEmp;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cedulaEmp = cedulaEmp;
        this.genero = genero;
        this.estadoEmp = estadoEmp;
        this.foto = foto;
        this.imageFile = imageFile;
        this.tamano = tamano;
    }

    public boolean isEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(boolean estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCedulaEmp() {
        return cedulaEmp;
    }

    public void setCedulaEmp(String cedulaEmp) {
        this.cedulaEmp = cedulaEmp;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public FileInputStream getImageFile() {
        return imageFile;
    }

    public void setImageFile(FileInputStream imageFile) {
        this.imageFile = imageFile;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

}
