/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

/**
 * Maneja la informacion relacionada a los hechizos del programa
 *
 * @author Alex
 * @version 1.0
 */
public class ControlHechizos {
    
    private ControlGeneral cGeneral;
    
    /**
     * Recibe la inyeccion del control general para respetar 
     * el bajo acoplamiento
     * 
     * @param cGeneral Control General
     */
    public ControlHechizos(ControlGeneral cGeneral) {
        this.cGeneral = cGeneral;
    }
    
    
    
}
