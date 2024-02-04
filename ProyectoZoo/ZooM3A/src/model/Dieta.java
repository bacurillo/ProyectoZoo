/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ALEJO
 */
public class Dieta extends Alimento {

    private int die_id;
    private String die_horario;
    private String die_porcion;
    private int die_idAlimento;
    private int die_idAnimal;
    private boolean die_estado;
    
    private int idAnimal;
    private String nombreAnimal;
    private String especieAnimal;

    public Dieta() {
    }

    public Dieta(int die_id, String die_horario, String die_porcion, int die_idAlimento, int die_idAnimal, boolean die_estado, int idAnimal, String nombreAnimal, String especieAnimal) {
        this.die_id = die_id;
        this.die_horario = die_horario;
        this.die_porcion = die_porcion;
        this.die_idAlimento = die_idAlimento;
        this.die_idAnimal = die_idAnimal;
        this.die_estado = die_estado;
        this.idAnimal = idAnimal;
        this.nombreAnimal = nombreAnimal;
        this.especieAnimal = especieAnimal;
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

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(String especieAnimal) {
        this.especieAnimal = especieAnimal;
    }



    public int getDie_idAnimal() {
        return die_idAnimal;
    }

    public void setDie_idAnimal(int die_idAnimal) {
        this.die_idAnimal = die_idAnimal;
    }

    public int getDie_id() {
        return die_id;
    }

    public void setDie_id(int die_id) {
        this.die_id = die_id;
    }

    public String getDie_horario() {
        return die_horario;
    }

    public void setDie_horario(String die_horario) {
        this.die_horario = die_horario;
    }

    public String getDie_porcion() {
        return die_porcion;
    }

    public void setDie_porcion(String die_porcion) {
        this.die_porcion = die_porcion;
    }

    public int getDie_idAlimento() {
        return die_idAlimento;
    }

    public void setDie_idAlimento(int die_idAlimento) {
        this.die_idAlimento = die_idAlimento;
    }

    public boolean isDie_estado() {
        return die_estado;
    }

    public void setDie_estado(boolean die_estado) {
        this.die_estado = die_estado;
    }

}
