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
public class Animales {

    private int idAnimal;
    private String nombreAnimal;
    private String generoAnimal;
    private String especieAnimal;
    //foto
    private Image foto;
    //guardar foto
    private FileInputStream imageFile;
    private int tamano;
    
    private Date fecha_ingresoAnimal;
    private Date fecha_nacimientoAnimal;
    private boolean estadoAnimal;
    private int idhabitadAnimal;
    private int idcuidadorAnimal;
    
    private String tiposangreCuidador;
    private String nombreCuidador;
    private String ubicacionHabitat;
    private String tipoHabitat;

    public Animales() {
    }

    public Animales(int idAnimal, String nombreAnimal, String generoAnimal, String especieAnimal, Image foto, FileInputStream imageFile, int tamano, Date fecha_ingresoAnimal, Date fecha_nacimientoAnimal, boolean estadoAnimal, int idhabitadAnimal, int idcuidadorAnimal, String tiposangreCuidador, String nombreCuidador, String ubicacionHabitat, String tipoHabitat) {
        this.idAnimal = idAnimal;
        this.nombreAnimal = nombreAnimal;
        this.generoAnimal = generoAnimal;
        this.especieAnimal = especieAnimal;
        this.foto = foto;
        this.imageFile = imageFile;
        this.tamano = tamano;
        this.fecha_ingresoAnimal = fecha_ingresoAnimal;
        this.fecha_nacimientoAnimal = fecha_nacimientoAnimal;
        this.estadoAnimal = estadoAnimal;
        this.idhabitadAnimal = idhabitadAnimal;
        this.idcuidadorAnimal = idcuidadorAnimal;
        this.tiposangreCuidador = tiposangreCuidador;
        this.nombreCuidador = nombreCuidador;
        this.ubicacionHabitat = ubicacionHabitat;
        this.tipoHabitat = tipoHabitat;
    }

    public String getUbicacionHabitat() {
        return ubicacionHabitat;
    }

    public void setUbicacionHabitat(String ubicacionHabitat) {
        this.ubicacionHabitat = ubicacionHabitat;
    }

    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public void setTipoHabitat(String tipoHabitat) {
        this.tipoHabitat = tipoHabitat;
    }



    public String getTiposangreCuidador() {
        return tiposangreCuidador;
    }

    public void setTiposangreCuidador(String tiposangreCuidador) {
        this.tiposangreCuidador = tiposangreCuidador;
    }

    public String getNombreCuidador() {
        return nombreCuidador;
    }

    public void setNombreCuidador(String nombreCuidador) {
        this.nombreCuidador = nombreCuidador;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getGeneroAnimal() {
        return generoAnimal;
    }

    public void setGeneroAnimal(String generoAnimal) {
        this.generoAnimal = generoAnimal;
    }

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(String especieAnimal) {
        this.especieAnimal = especieAnimal;
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

    public Date getFecha_ingresoAnimal() {
        return fecha_ingresoAnimal;
    }

    public void setFecha_ingresoAnimal(Date fecha_ingresoAnimal) {
        this.fecha_ingresoAnimal = fecha_ingresoAnimal;
    }

    public Date getFecha_nacimientoAnimal() {
        return fecha_nacimientoAnimal;
    }

    public void setFecha_nacimientoAnimal(Date fecha_nacimientoAnimal) {
        this.fecha_nacimientoAnimal = fecha_nacimientoAnimal;
    }

    public boolean isEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(boolean estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    public int getIdhabitadAnimal() {
        return idhabitadAnimal;
    }

    public void setIdhabitadAnimal(int idhabitadAnimal) {
        this.idhabitadAnimal = idhabitadAnimal;
    }

    public int getIdcuidadorAnimal() {
        return idcuidadorAnimal;
    }

    public void setIdcuidadorAnimal(int idcuidadorAnimal) {
        this.idcuidadorAnimal = idcuidadorAnimal;
    }

}
