package com.uDistrital.avanzada.tallerTres.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Clase para leer archivos properties que contienen información de magos y hechizos
 * para el sistema de duelos mágicos.
 * Permite cargar la información necesaria desde archivos externos sin violar
 * el principio Open/Closed de SOLID.
 *
 * @author Taller 3 - Duelos Mágicos
 * @version 1.0
 */
public class ArchivoProperties {

    /**
     * Clase interna que representa los datos crudos de un mago.
     * Contiene únicamente la información básica leída del archivo properties
     * (nombre y casa mágica).
     */
    public static class MagoRaw {

        private String nombre;
        private String casa;

        /**
         * Constructor que inicializa un mago con su información básica.
         *
         * @param nombre Nombre del mago
         * @param casa Casa mágica a la que pertenece el mago
         */
        public MagoRaw(String nombre, String casa) {
            this.nombre = nombre;
            this.casa = casa;
        }

        /**
         * Obtiene el nombre del mago.
         *
         * @return Nombre del mago
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Establece el nombre del mago.
         *
         * @param nombre Nuevo nombre para el mago
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Obtiene la casa mágica del mago.
         *
         * @return Casa mágica del mago
         */
        public String getCasa() {
            return casa;
        }

        /**
         * Establece la casa mágica del mago.
         *
         * @param casa Nueva casa mágica para el mago
         */
        public void setCasa(String casa) {
            this.casa = casa;
        }
    }

    /**
     * Clase interna que representa los datos crudos de un hechizo.
     * Contiene el nombre del hechizo y su nivel de puntos.
     */
    public static class HechizoRaw {

        private String nombre;
        private int puntos;

        /**
         * Constructor que inicializa un hechizo con su información básica.
         *
         * @param nombre Nombre del hechizo
         * @param puntos Puntos de daño del hechizo (debe estar entre 5 y 25)
         */
        public HechizoRaw(String nombre, int puntos) {
            this.nombre = nombre;
            this.puntos = puntos;
        }

        /**
         * Obtiene el nombre del hechizo.
         *
         * @return Nombre del hechizo
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Establece el nombre del hechizo.
         *
         * @param nombre Nuevo nombre para el hechizo
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Obtiene los puntos de daño del hechizo.
         *
         * @return Puntos del hechizo
         */
        public int getPuntos() {
            return puntos;
        }

        /**
         * Establece los puntos de daño del hechizo.
         *
         * @param puntos Nuevos puntos para el hechizo
         */
        public void setPuntos(int puntos) {
            this.puntos = puntos;
        }
    }

    /**
     * Lee y devuelve la lista de magos desde un archivo properties
     *
     * @param archivoProps Archivo properties a leer
     * @return Lista de magos con su información básica
     * @throws IOException Si ocurre un error al leer el archivo
     * @throws IllegalArgumentException Si el archivo es null
     * @throws FileNotFoundException Si el archivo no existe en el sistema
     */
    public List<MagoRaw> leerMagos(File archivoProps) throws IOException {
        validarArchivo(archivoProps);
        
        Properties p = cargarProperties(archivoProps);
        
        int numMagos = contarElementosContiguos(p, "mago");
        if (numMagos == 0) {
            throw new IOException("No se encontraron magos en el archivo properties");
        }

        List<MagoRaw> magos = new ArrayList<>(numMagos);
        for (int i = 1; i <= numMagos; i++) {
            String prefix = "mago." + i;
            String nombre = p.getProperty(prefix + ".nombre");
            String casa = p.getProperty(prefix + ".casa");
            
            if (nombre == null || casa == null) {
                throw new IOException("Datos incompletos para el mago " + i);
            }
            
            magos.add(new MagoRaw(nombre.trim(), casa.trim()));
        }
        
        return magos;
    }

    /**
     * Valida que el archivo no sea null y exista en el sistema.
     *
     * @param archivo Archivo a validar
     * @throws IllegalArgumentException Si el archivo es null
     * @throws FileNotFoundException Si el archivo no existe
     */
    private void validarArchivo(File archivo) throws FileNotFoundException {
        if (archivo == null) {
            throw new IllegalArgumentException("El archivo .properties no puede ser null");
        }
        if (!archivo.exists()) {
            throw new FileNotFoundException("No existe el archivo: " + archivo.getAbsolutePath());
        }
    }

    /**
     * Carga un archivo properties y retorna el objeto Properties.
     *
     * @param archivo Archivo properties a cargar
     * @return Objeto Properties con los datos cargados
     * @throws IOException Si ocurre un error al leer el archivo
     */
    private Properties cargarProperties(File archivo) throws IOException {
        Properties p = new Properties();
        try (FileInputStream in = new FileInputStream(archivo)) {
            p.load(in);
        }
        return p;
    }

    /**
     * Cuenta cuántos elementos contiguos existen en el archivo properties
     * con un prefijo dado (mago o hechizo).
     * Los elementos deben estar numerados consecutivamente desde 1.
     *
     * @param p Objeto Properties a analizar
     * @param prefijo Prefijo de los elementos a contar (ej: "mago", "hechizo")
     * @return Número de elementos contiguos encontrados
     */
    private int contarElementosContiguos(Properties p, String prefijo) {
        int count = 0;
        for (int i = 1; ; i++) {
            String key = prefijo + "." + i + ".nombre";
            if (p.getProperty(key) == null) {
                break;
            }
            count = i;
        }
        return count;
    }
}
