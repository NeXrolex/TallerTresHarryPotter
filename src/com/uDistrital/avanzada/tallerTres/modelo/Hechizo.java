/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.modelo;

/**
 * Representacion de un hechizo en el sistema
 *
 * @author Alex
 */
public class Hechizo {
    
    private String nomHechizo;
    private int puntajeHechizo;

    public Hechizo() {
    }
    
    /**
     * Asigana valores de un hechizo
     * 
     * @param nomHechizo Nombre del hechizo
     * @param puntajeHechizo Puntaje del hechizo
     */
    public Hechizo(String nomHechizo, int puntajeHechizo) {
        
        this.nomHechizo = nomHechizo;
        this.puntajeHechizo = puntajeHechizo;
        
    }
    
    /**
     * Obtiene el nombre de un hechizo
     * 
     * @return nomHechizo
     */
    public String getNomHechizo() {
        return nomHechizo;
    }
    
    /**
     * Asigna el nombre de un hechizo
     * 
     * @param nomHechizo Nombre del hechizo
     */
    public void setNomHechizo(String nomHechizo) {
        this.nomHechizo = nomHechizo;
    }
    
    /**
     * Obtiene el puntaje del hechizo
     * 
     * @return puntajeHechizo
     */
    public int getPuntajeHechizo() {
        return puntajeHechizo;
    }
    
    /**
     * Asigna el puntaje del hechizo
     * 
     * @param puntajeHechizo Puntaje del hechizo
     */
    public void setPuntajeHechizo(int puntajeHechizo) {
        this.puntajeHechizo = puntajeHechizo;
    }
    
    
    
    
    
}
