/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ALEJO
 */
public class Habitat extends Zoologo{

    private int id_habitat;
    private String tipohab;
    private int capacidadhap;
    private int idZoologohab;
    private String ubicacionhab;
    private boolean estadohab;

    public Habitat() {
    }

    public Habitat(int id_habitat, String tipohab, int capacidadhap, int idZoologohab, String ubicacionhab, boolean estadohab) {
        this.id_habitat = id_habitat;
        this.tipohab = tipohab;
        this.capacidadhap = capacidadhap;
        this.idZoologohab = idZoologohab;
        this.ubicacionhab = ubicacionhab;
        this.estadohab = estadohab;
    }

    public int getId_habitat() {
        return id_habitat;
    }

    public void setId_habitat(int id_habitat) {
        this.id_habitat = id_habitat;
    }

    public String getTipohab() {
        return tipohab;
    }

    public void setTipohab(String tipohab) {
        this.tipohab = tipohab;
    }

    public int getCapacidadhap() {
        return capacidadhap;
    }

    public void setCapacidadhap(int capacidadhap) {
        this.capacidadhap = capacidadhap;
    }

    public int getIdZoologohab() {
        return idZoologohab;
    }

    public void setIdZoologohab(int idZoologohab) {
        this.idZoologohab = idZoologohab;
    }

    public String getUbicacionhab() {
        return ubicacionhab;
    }

    public void setUbicacionhab(String ubicacionhab) {
        this.ubicacionhab = ubicacionhab;
    }

    public boolean isEstadohab() {
        return estadohab;
    }

    public void setEstadohab(boolean estadohab) {
        this.estadohab = estadohab;
    }

}
