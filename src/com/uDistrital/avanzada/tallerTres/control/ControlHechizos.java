/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.Hechizo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase encargada de manejar los procesos de los hechizos
 *
 * @author Alex,Jard,Stiven
 */
public class ControlHechizos {

    private ControlGeneral cGeneral;
    private List<Hechizo> hechizosDisponibles;

    /**
     * Recibe la inyeccion del control general para respetar el bajo
     * acoplamiento
     *
     * @param cGeneral Control General
     */
    public ControlHechizos(ControlGeneral cGeneral) {
        this.cGeneral = cGeneral;
        this.hechizosDisponibles = new ArrayList<>();
    }
    
    /**
     * Transforma la lista de hechizos para que sean de tipo
     * lista de objetos 
     * @param hechizosDatos Datos de hechizos
     * @return Lista de hechizos
     */
    public void transformarHechizos(ArrayList<String[]> hechizosDatos) {
        this.hechizosDisponibles.clear();  // Limpiar la lista antes de 
        //agregar nuevos hechizos
        for (String[] datos : hechizosDatos) {
            String nombre = datos[0];
            int cantidad = Integer.parseInt(datos[1]);
            hechizosDisponibles.add(new Hechizo(nombre, cantidad)); 
            // Agregar el nuevo Hechizo
        }
    }

    /**
     * Obtiene la lista de hechizos disponibles
     * 
     * @return Lista de hechizos Disponibles
     */
    public ArrayList<Hechizo> obtenerHechizos() {
        return (ArrayList<Hechizo>) this.hechizosDisponibles;
    }

    /**
     * Metodo encargado de generar un hechizo aleatorio
     *
     * @return Hechizo aleatorio
     */
    public Hechizo obtenerHechizoAleatorio() {
        // Verifica si hay hechizos disponibles
        if (hechizosDisponibles.isEmpty()) {
            return null;// Retorna null si no hay hechizos disponibles
        }

        // Generar un índice aleatorio
        Random random = new Random();
        int indice = random.nextInt(hechizosDisponibles.size());
        // Obtener un índice aleatorio

        // Retornar el hechizo aleatorio
        return hechizosDisponibles.get(indice);
    }
}
