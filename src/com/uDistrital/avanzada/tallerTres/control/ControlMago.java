/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

/**
 * Maneja el control de los magos y ayuda al proceso de hilos 
 * para la concurrencia
 *
 * @author Alex
 * @version 1.0
 */
public class ControlMago extends Thread {
    
    private ControlGeneral cGeneral;
    
    /**
     * Recibe la inyeccion del control General para respetar el 
     * bajo acoplamiento
     * 
     * @param cGeneral Control General
     */
    public ControlMago(ControlGeneral cGeneral) {
        this.cGeneral = cGeneral;
    }
    
    
    
}
