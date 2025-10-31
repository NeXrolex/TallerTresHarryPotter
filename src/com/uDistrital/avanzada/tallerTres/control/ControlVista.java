/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.Hechizo;
import com.uDistrital.avanzada.tallerTres.modelo.Mago;
import com.uDistrital.avanzada.tallerTres.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 * Clase encargada de el control para la logica de la vista
 *
 * @author Alex,Jard,Stiven
 */
public class ControlVista implements ActionListener {

    private VentanaPrincipal vista;
    private ControlGeneral controlGeneral;

    /**
     * Constructor que recibe el control general
     *
     * @param general Control General
     */
    public ControlVista(ControlGeneral general) {
        this.controlGeneral = general;
        this.vista = new VentanaPrincipal();
        this.vista.getBtnCargar().addActionListener(this);
        this.vista.getBtnIniciar().addActionListener(this);
        this.vista.getBtnSalir().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
    }

    /**
     * Solicita a la vista seleccionar un archivo
     */
    public void solicitarCargarArchivo() {
        File archivo = vista.solicitarArchivoPropiedades();

        if (archivo == null) {
            vista.mostrarMensaje("Selección cancelada");
            return;
        }
        if (!archivo.getName().toLowerCase().endsWith(".properties")) {
            vista.mostrarError("El archivo seleccionado no es un archivo .properties válido.");
            return;
        }

        if (!archivo.isFile()) {
            vista.mostrarError("El archivo seleccionado no es válido.");
            return;
        }

        controlGeneral.cargarProperties(archivo);
    }

    /**
     * Notifica el exito o no de la carga de los magos
     *
     * @param magos Lista de magos cargados
     */
    public void notificarCargaExitosa(List<Mago> magos) {
        vista.mostrarMensaje("Archivo cargado exitosamente.\nMagos cargados: "
                + magos.size());
        mostrarMagosEnVista(magos);
    }

    /**
     * Mensaje de error a la vista
     *
     * @param mensaje Mensaje de error
     */
    public void notificarError(String mensaje) {
        vista.mostrarError(mensaje);
    }

    /**
     * Metodo para escribir texto en la vista
     *
     * @param texto Texto a escribir
     */
    public void escribirEnConsola(String texto) {
        vista.agregarTexto(texto);
    }

    /**
     * Limpia la consola de la vista
     */
    public void limpiarConsola() {
        vista.limpiarTexto();
    }

    /**
     * Muestra los magos de la vista
     *
     * @param magos Lista de magos
     */
    public void mostrarMagosEnVista(List<Mago> magos) {
        limpiarConsola();
        escribirEnConsola("       MAGOS CARGADOS           \n");

        for (int i = 0; i < magos.size(); i++) {
            Mago mago = magos.get(i);
            escribirEnConsola((i + 1) + ". " + mago.getNombre()
                    + " - Casa: " + mago.getCasa() + "\n");
        }

        escribirEnConsola("\n");
    }

    /**
     * Metodo para iniciar la visualizacion de los duelos
     */
    public void iniciarModoVisualizacionDuelos() {
        limpiarConsola();

        escribirEnConsola("   INICIANDO DUELOS MÁGICOS           \n");

    }

    /**
     * Notifica el lanzamiento de un hechizo simulado (sin objeto Hechizo real)
     *
     * @param mago Mago que lanza el hechizo
     * @param nombreHechizo Nombre del hechizo
     * @param puntosHechizo Puntos obtenidos
     */
    public void notificarLanzamientoSimulado(Mago mago, String nombreHechizo,
            int puntosHechizo) {
        SwingUtilities.invokeLater(() -> {
            String mensaje = String.format(
                    " %s lanza %s (+%d pts) | Total: %d\n",
                    mago.getNombre(),
                    nombreHechizo,
                    puntosHechizo,
                    mago.getPuntaje()
            );
            vista.agregarTexto(mensaje);
        });
    }

    /**
     * Metodo para notificar el inicio de un duelo
     *
     * @param numeroDuelo Número del duelo
     * @param mago1 Primer mago
     * @param mago2 Segundo mago
     */
    public void notificarInicioDuelo(int numeroDuelo, Mago mago1, Mago mago2) {
        escribirEnConsola("\n│         DUELO #" + numeroDuelo
                + "             \n");

        escribirEnConsola(mago1.getNombre() + " (" + mago1.getCasa() + ")");
        escribirEnConsola(" VS ");
        escribirEnConsola(mago2.getNombre() + " (" + mago2.getCasa() + ")\n\n");
    }

    /**
     * Notifica el lanzamiento de un hechizo
     *
     * @param mago Mago que lanza
     * @param hechizo Hechizo lanzado
     */
    public void notificarLanzamientoHechizo(Mago mago, Hechizo hechizo) {
        String mensaje = "" + mago.getNombre() + " lanza "
                + hechizo.getNomHechizo() + " ("
                + hechizo.getPuntajeHechizo() + " pts) | Total: "
                + mago.getPuntaje() + "\n";
        escribirEnConsola(mensaje);
    }

    /**
     * Notifica el resultado de un duelo
     *
     * @param ganador Mago ganador
     */
    public void notificarResultadoDuelo(Mago ganador) {
        escribirEnConsola("\n│     GANADOR DEL DUELO            │\n");

        escribirEnConsola(ganador.getNombre() + "\n");
        escribirEnConsola("Casa: " + ganador.getCasa() + "\n");
        escribirEnConsola("Puntaje: " + ganador.getPuntaje() + "\n");
        escribirEnConsola("Hechizos lanzados: " + ganador.getCantidadHechizos()
                + "\n");

    }

    /**
     * Metodo encargado de establecer la logica para determinar el mago
     * correspondiente
     *
     * @param gifDatos ruta de los gift
     */
    public void cargarGifs(ArrayList<String[]> gifDatos) {

        for (String[] datos : gifDatos) {
            String nombreGif = datos[0];
            String rutaGif = datos[1];

            if (nombreGif.equalsIgnoreCase("magoAzul")) {
                vista.establecerGifMagoAzul(rutaGif);
            } else if (nombreGif.equalsIgnoreCase("magoRojo")) {
                vista.establecerGifMagoRojo(rutaGif);
            }
        }

        vista.refrescarPanelGifs();
    }

    /**
     * Notifica el ganador de un duelo
     *
     * @param campeon Mago ganador
     */
    public void notificarCampeonFinal(Mago campeon) {

        escribirEnConsola("\n CAMPEÓN FINAL DEL TORNEO       \n");

        escribirEnConsola("Nombre: " + campeon.getNombre() + "\n");
        escribirEnConsola("Casa: " + campeon.getCasa() + "\n");
        escribirEnConsola("Puntaje final: " + campeon.getPuntaje() + "\n");
        escribirEnConsola("Total de hechizos: " + campeon.getCantidadHechizos()
                + "\n");

        vista.mostrarMensaje("¡Los duelos han finalizado!\nCampeón: "
                + campeon.getNombre());
    }

    /**
     * Orquesta salir de la aplicacion
     *
     */
    private void salirAplicacion() {
        System.exit(0);
    }

    /**
     * Maneja los eventos de acción generados por los distintos botones de la
     * interfaz gráfica.
     *
     * Este método se ejecuta automáticamente cuando el usuario interactúa con
     * alguno de los botones de la ventana principal. Dependiendo del botón
     * presionado, se ejecuta la acción correspondiente:
     *
     * btnCargar: Solicita al usuario cargar un archivo con los datos
     * requeridos. btnIniciar: Carga los GIFs en la vista y da inicio a los
     * duelos de forma asíncrona. btnLimpiar: Limpia la consola o área de
     * resultados en la interfaz. btnSalir: Cierra la aplicación de manera
     * controlada.
     *
     * @param e Objeto {@link ActionEvent} que contiene información sobre el
     * evento generado, incluyendo la fuente que lo originó (el botón
     * presionado).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (a == vista.getBtnCargar()) {
            solicitarCargarArchivo();
        } else if (a == vista.getBtnIniciar()) {
            cargarGifs(controlGeneral.obtenerGifsDatos());
            controlGeneral.iniciarDuelosAsincronamente();
        } else if (a == vista.getBtnLimpiar()) {
            limpiarConsola();
        } else if (a == vista.getBtnSalir()) {
            salirAplicacion();
        }
    }
}
