/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.modelo;

/**
 * Representa una persona en el sistema
 *
 * @author Alex
 */
public class Persona {
    
    private String nombre;
    
    /**
     * Constructor que asigna el nombre de una persona
     * 
     * @param nombre Nombre de la persona
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo que obtiene el nombre de la persona
     * 
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Asigna el nombre de una persona
     * 
     * @param nombre Nombre de la perosna
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
