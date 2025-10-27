/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.Properties;

/**
 * Se encarga de conectar el archivo
 *
 * @author Alex
 * @version 1.0
 */
public class ArchivoPropiedades {

    private File archivo;

    /**
     * Constructor que asocia el archivo
     *
     * @param archivo archivo referencia para abrir
     */
    public ArchivoPropiedades(File archivo) {

        this.archivo = archivo;

    }

    /**
     * Carga y abre el archivo de propiedades
     * 
     * @return
     * @throws IOException 
     */
    public Properties abrir() throws IOException {
        //Si no hay un archivo asociado
        if (archivo == null) {
            throw new IllegalStateException("No se ha asociado un"
                    + " archivo .properties.");
        }
        //Si se escoge un archivo incorrecto
        if (!archivo.exists() || !archivo.isFile()) {

            throw new IllegalStateException("El archivo .properties no "
                    + "existe o no es válido: " + archivo);
        }

        Properties props = new Properties();
        /* Usamos try para despues de su uso se cierre el archivo, 
        importante para las buenas parcticas*/
        try (FileInputStream aux = new FileInputStream(archivo)) {
            props.load(aux);
            return props;
        }
    }

}
