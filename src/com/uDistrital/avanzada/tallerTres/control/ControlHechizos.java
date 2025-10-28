/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.Hechizo;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de manejar los procesos de los hechizos
 * 
 * @author Alex,Jard,Stiven
 */
public class ControlHechizos {
    private ControlGeneral cGeneral;
    private List<Hechizo> hechizosDisponibles;

    /**
     * Recibe la inyeccion del control general para respetar
     * el bajo acoplamiento
     * 
     * @param cGeneral Control General
     */
    public ControlHechizos(ControlGeneral cGeneral) {
        this.cGeneral = cGeneral;
        this.hechizosDisponibles = new ArrayList<>();
    }

    /**
     * Procesa los hechizos desde la lista transformada
     * 
     * @param Lista de hechizos
     */
    public void procesarHechizos(ArrayList<Hechizo> hechizos) {
        this.hechizosDisponibles = new ArrayList<>(hechizos);
    }

    /**
     * Metodo encargado de obtener la lista de hechizos disponibles
     * 
     * @return Lista de hechizos
     */
    public List<Hechizo> obtenerListaHechizos() {
        return new ArrayList<>(hechizosDisponibles);
    }

    /**
     * Metodo encargado de generar un hechizo aleatorio 
     * 
     * @return Hechizo aleatorio
     */
    public Hechizo obtenerHechizoAleatorio() {
        if (hechizosDisponibles.isEmpty()) {
            return null;
        }
        int indice = (int) (Math.random() * hechizosDisponibles.size());
        return hechizosDisponibles.get(indice);
    }
}
