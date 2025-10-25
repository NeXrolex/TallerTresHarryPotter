/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.modelo;

/**
 * Hereda de persona y repressenta un mago
 *
 * @author Alex
 */
public class Mago extends Persona {
    
    private String casa;
    private int cantidadHechizos;
    private int puntaje;
    private boolean estadoAturdido;
    
    /**
     * Constructor que asigna atriutos del mago
     * 
     * @param nombre Nombre del mago
     * @param casa Casa del mago
     */
    public Mago(String nombre, String casa) {
        super(nombre);
        this.casa = casa;
        
    }
    
    /**
     * Retorna el valor de la casa
     * 
     * @return Casa
     */
    public String getCasa() {
        return casa;
    }
    
    /**
     * Asigna el valor de la casa
     * 
     * @param casa Casa del mago
     */
    public void setCasa(String casa) {
        this.casa = casa;
    }
    
    /**
     * retorna el valor del puntaje
     * 
     * @return Puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * Asigna el valor del puntaje
     * 
     * @param puntaje Puntaje del mago 
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    /**
     * Obtiene la cantidad de hechizos 
     * 
     * @return cantidad de hechizos
     */
    public int getCantidadHechizos() {
        return cantidadHechizos;
    }
    
    /**
     * Asigna la cantidad de hechizos
     * 
     * @param cantidadHechizos Cantidad de hechizos del mago
     */
    public void setCantidadHechizos(int cantidadHechizos) {
        this.cantidadHechizos = cantidadHechizos;
    }
    
    /**
     * En que estado se encuentra el jugador
     * 
     * @return True or false para los casos
     */
    public boolean isEstadoAturdido() {
        return estadoAturdido;
    }
    
    /**
     * Asigna el estado del mago
     * 
     * @param estadoAturdido Estado actual del mago
     */
    public void setEstado(boolean estadoAturdido) {
        this.estadoAturdido = estadoAturdido;
    }
    
    
    
}
