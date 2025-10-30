/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.ArchivoPropiedades;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja toda la informacion de los arhivos de propiedades y aclara toda la
 * logica del mismo
 *
 * @author Alex
 * @version 1.0
 */
public class ControlProperties {

    private ControlGeneral cGeneral;
    private File origenActual;

    public static final String prefijoMago = "mago.";
    public static final String prefijohechizo = "hechizo.";
    public static final String prefijoGif = "gif";

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
     * Extrae los datos de los magos del archivo y los devuelve como un listado
     * de datos. Cada Mago tiene: nombre, casa.
     *
     * @return Lista de magos con sus datos.
     * @throws IOException si hay un error de lectura del archivo.
     */
    public ArrayList<String[]> extraerDatosMagos() throws IOException {
        if (this.origenActual == null) {
            throw new IllegalStateException("No hay archivo asociado. "
                    + "Use cargarDesde(File) primero.");
        }

        // Abrir archivo .properties
        Properties props = new ArchivoPropiedades(this.origenActual).abrir();

        ArrayList<String[]> magosDatos = new ArrayList<>();

        for (String key : props.stringPropertyNames()) {
            if (!key.startsWith("mago.") || !key.endsWith(".nombre")) {
                continue;
            }

            // Extraer ID de mago
            String id = key.substring("mago.".length(), key.length()
                    - ".nombre".length()).trim();
            if (id.isEmpty()) {
                continue;
            }

            String nombre = props.getProperty("mago." + id + ".nombre", "")
                    .trim();
            String casa = props.getProperty("mago." + id + ".casa", "").trim();

            if (!nombre.isEmpty()) {
                // Guardar los datos como un arreglo [nombre, casa]
                magosDatos.add(new String[]{nombre, casa});
            }
        }
        return magosDatos;
    }

    /**
     * Extrae los datos de los hechizos del archivo y los devuelve como un
     * listado de datos. Cada Hechizo tiene: nombre, cantidad.
     *
     * @return Lista de hechizos con sus datos.
     * @throws IOException si hay un error de lectura del archivo.
     */
    public ArrayList<String[]> extraerDatosHechizos() throws IOException {
        if (this.origenActual == null) {
            throw new IllegalStateException("No hay archivo asociado."
                    + " Use cargarDesde(File) primero.");
        }

        // Abrir archivo .properties
        Properties props = new ArchivoPropiedades(this.origenActual).abrir();

        ArrayList<String[]> hechizosDatos = new ArrayList<>();

        for (String key : props.stringPropertyNames()) {
            if (!key.startsWith("hechizo.") || !key.endsWith(".nombre")) {
                continue;
            }

            // Extraer ID de hechizo
            String id = key.substring("hechizo.".length(), key.length()
                    - ".nombre".length()).trim();
            if (id.isEmpty()) {
                continue;
            }

            String nombre = props.getProperty("hechizo." + id + ".nombre", "")
                    .trim();
            String cantidadStr = props.getProperty("hechizo." + id
                    + ".cantidad", "0").trim();

            if (!nombre.isEmpty()) {
                hechizosDatos.add(new String[]{nombre, cantidadStr});
            }
        }
        return hechizosDatos;
    }

    public ArrayList<String[]> extraerGif() throws IOException {
        if (this.origenActual == null) {
            throw new IllegalStateException("No hay archivo asociado. "
                    + "Use cargarDesde(File) primero.");
        }

        // Abrir archivo .properties
        Properties props = new ArchivoPropiedades(this.origenActual).abrir();

        ArrayList<String[]> gifDatos = new ArrayList<>();

        for (String key : props.stringPropertyNames()) {
            if (!key.startsWith("gif.")) {
                continue;
            }

            // Extraer la ruta y el nombre del mago y agregarlos a la lista
            String nombreGif = key.substring("gif.".length()).trim();
            String ruta = props.getProperty(key, "").trim();
            if (nombreGif.isEmpty()) {
                continue;
            } else if (!nombreGif.isEmpty() && !ruta.isEmpty()) {
                gifDatos.add(new String[]{nombreGif, ruta});
            }
        }
        return gifDatos;
    }
}
