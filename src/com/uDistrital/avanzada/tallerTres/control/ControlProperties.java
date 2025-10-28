/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.ArchivoPropiedades;
import com.uDistrital.avanzada.tallerTres.modelo.Hechizo;
import com.uDistrital.avanzada.tallerTres.modelo.Mago;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja toda la informacion de los arhivos de propiedades
 * y aclara toda la logica del mismo
 *
 * @author Alex
 * @version 1.0
 */
public class ControlProperties {
    
    private ControlGeneral cGeneral;
    private File origenActual;
    
    public static final String prefijoMago = "mago.";
    public static final String prefijohechizo = "hechizo.";
    
    /**
     * recibe la inyeccion del control General
     * 
     * @param cGeneral Control General
     */
    public ControlProperties(ControlGeneral cGeneral) {
        this.cGeneral = cGeneral;
        
    }
    
    /**
     * Delega la apertura del archivo de propiedades gracias al JFileChooser
     * 
     * @param archivo Archivo
     * @throws IOException Error de lectura
     */
    public void cargarDesde(File archivo) throws IOException {
        if (archivo == null) {
            throw new IllegalStateException("No se recibió archivo"
                    + " para cargar.");
        }
        if (!archivo.exists() || !archivo.isFile()) {
            throw new IllegalStateException("El archivo no existe o no "
                    + "es válido: " + archivo);
        }
        
        ArchivoPropiedades ap = new ArchivoPropiedades(archivo);
        Properties props = ap.abrir();

        this.origenActual = archivo;

    }
    /**
     *  Saca los elementos del archivo y los convierte en un arreglo
     * 
     * @return Lista de magos
     * @throws IOException Error de lectura
     */
    public ArrayList<Mago> transformarMagos() throws IOException {
        if (this.origenActual == null) {
            throw new IllegalStateException();
        }

        // Abrir properties en el momento
        Properties props = new ArchivoPropiedades(this.origenActual).abrir();

        ArrayList<Mago> lista = new ArrayList<>();

        for (String key : props.stringPropertyNames()) {
            
            if (!key.startsWith("mago.") || !key.endsWith(".nombre")) {
                continue;
            }

            
            String id = key.substring("mago.".length(), key.length()
                    - ".nombre".length()).trim();
            if (id.isEmpty()) {
                continue;
            }

            String nombre = props.getProperty("mago." + id + ".nombre", "")
                    .trim();
            if (nombre.isEmpty()) {
                continue; // mínimo: sin nombre no se crea
            }
            String casa = props.getProperty("mago." + id + ".casa", "").trim();

            lista.add(new Mago(nombre, casa));
        }

        return lista;
    }
    
    /**
     * Convierte el contenido de los properties en elementos que podamos
     * trabajar(Opera properties para trabajar mas cristiano)
     * 
     * @return Lista de Hechizos
     * @throws IOException Error de lectura 
     */
    public ArrayList<Hechizo> transformarHechizos() throws IOException {
        if (this.origenActual == null) {
            throw new IllegalStateException();
        }

        // Abrir properties en el momento
        Properties props = new ArchivoPropiedades(this.origenActual).abrir();

        ArrayList<Hechizo> lista = new ArrayList<>();

        for (String key : props.stringPropertyNames()) {
            
            if (!key.startsWith("hechizo.") || !key.endsWith(".nombre")) {
                continue;
            }

            
            String id = key.substring("hechizo.".length(), key.length()
                    - ".nombre".length()).trim();
            if (id.isEmpty()) {
                continue;
            }

            String nombre = props.getProperty("hechizo." + id + ".nombre", "")
                    .trim();
            if (nombre.isEmpty()) {
                continue;
            }

            String cantStr = props.getProperty("hechizo." + id +
                    ".cantidad", "0").trim();
            int cantidad;
            try {
                int v = Integer.parseInt(cantStr);
                cantidad = (v < 0) ? 0 : v;
            } catch (Exception e) {
                cantidad = 0;
            }

            lista.add(new Hechizo(nombre, cantidad));
        }

        return lista;
    }
    
}