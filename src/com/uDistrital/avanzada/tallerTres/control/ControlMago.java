/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.Mago;
import java.util.ArrayList;

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
    
    /**
     * Trasnforma los datos en una lista de objetos de tipo mago
     * 
     * @param magosDatos Datos de los magos
     * @return Lista de magos
     */
    public ArrayList<Mago> transformarMagos(ArrayList<String[]> magosDatos) {
        ArrayList<Mago> magos = new ArrayList<>();
        for (String[] datos : magosDatos) {
            String nombre = datos[0];
            String casa = datos[1];
            magos.add(new Mago(nombre, casa));
        }
        return magos;
    }
    
}
