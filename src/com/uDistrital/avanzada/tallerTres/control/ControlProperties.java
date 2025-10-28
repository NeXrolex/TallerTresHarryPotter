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
        
        return null;
        
    }
    
    public ArrayList<Hechizo> listarHechizos(){
        
        return null;
        
    }
    
}
