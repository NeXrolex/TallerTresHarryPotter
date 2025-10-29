package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.Hechizo;
import com.uDistrital.avanzada.tallerTres.modelo.Mago;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Maneja todo el flujo de la informacion entres los controles y orquesta la
 * comunicacion entre ellos
 *
 * @author Gezz, Alex
 * @version 1.0
 */
public class ControlGeneral {

    private ControlVista cVista;
    private ControlProperties cProps;
    private ControlHechizos cHechizos;
    private ControlMago cMago;
    private List<Mago> listaMagos;

    /**
     * Constructor encargado de instanciar los controles Se inyecetas a ellos
     * para cumplir con el bajo acoplamiento
     *
     */
    public ControlGeneral() {
        this.cVista = new ControlVista(this);
        this.cProps = new ControlProperties(this);
        this.cHechizos = new ControlHechizos(this);
        this.cMago = new ControlMago(this, new Object());
        this.listaMagos = new ArrayList<>();

    }

    /**
     * Flujo de la informacion para cargar los properties usando el JFileChooser
     *
     * @param archivo Archivo dse propiedades
     */
    public void cargarProperties(File archivo) {
        try {
            cProps.cargarDesde(archivo);
            // Extraer datos de Magos
            ArrayList<String[]> magosDatos = cProps.extraerDatosMagos();
            cMago.transformarMagos(magosDatos);  // Los magos son almacenados
            //dentro de ControlMago

            // Extraer datos de Hechizos
            ArrayList<String[]> hechizosDatos = cProps.extraerDatosHechizos();
            cHechizos.transformarHechizos(hechizosDatos);

        } catch (Exception ex) {

        }

    }

    public void notificarLanzamientoHechizo(Mago mago, String nombreHechizo, int puntos) {
    cVista.notificarLanzamientoSimulado(mago, nombreHechizo, puntos);
}

    // Inicia los duelos mágicos y los muestra en la vista.
    public void iniciarDuelos() {
        try {
            //  Cargar los magos desde el archivo properties
            List<Mago> magos = cMago.obtenerMagos();
            if (magos.isEmpty()) {
                cVista.notificarError("No se encontraron magos en el archivo de propiedades.");
                return;
            }

            this.listaMagos = magos;
            cVista.notificarCargaExitosa(listaMagos);

            // Iniciar la vista de duelos
            cVista.iniciarModoVisualizacionDuelos();

            int numeroDuelo = 1;

            // El mago que gane los duelos será el retador
            Mago ganadorActual = listaMagos.get(0);

            for (int i = 1; i < listaMagos.size(); i++) {
                Mago retador = listaMagos.get(i);

                // Notificar inicio del duelo
                Thread.sleep(2000);
                cVista.notificarInicioDuelo(numeroDuelo, ganadorActual, retador);

                ganadorActual.resetPuntaje();
                retador.resetPuntaje();

                Object lock = new Object();

                ControlMago hilo1 = new ControlMago(this, lock);
                ControlMago hilo2 = new ControlMago(this, lock);

                hilo1.setMagos(ganadorActual, retador);
                hilo2.setMagos(retador, ganadorActual);

                hilo1.start();
                hilo2.start();

                // Esperar a que ambos terminen
                hilo1.join();
                hilo2.join();

                while (ganadorActual.getPuntaje() < 250 && retador.getPuntaje() < 250) {
                    Thread.sleep(100);
                }

                // Ganador
                ganadorActual = (ganadorActual.getPuntaje() >= retador.getPuntaje())
                        ? ganadorActual
                        : retador;
                Thread.sleep(1000);
                // Notificar resultado del duelo
                cVista.notificarResultadoDuelo(ganadorActual);

                numeroDuelo++;
            }

            cVista.notificarCampeonFinal(ganadorActual);

        } catch (Exception ex) {
            cVista.notificarError("Error al iniciar los duelos: " + ex.getMessage());
        }
    }

    public Hechizo obtenerHechizoAleatorio() {
        return cHechizos.obtenerHechizoAleatorio();
    }
}
