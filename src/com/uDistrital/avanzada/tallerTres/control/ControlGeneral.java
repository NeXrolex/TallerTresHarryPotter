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
        this.cMago = new ControlMago(this);
        this.cHechizos = new ControlHechizos(this);
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
            ArrayList<Mago> magos = cMago.transformarMagos(magosDatos);
            
            // Extraer datos de Hechizos
            ArrayList<String[]> hechizosDatos = cProps.extraerDatosHechizos();
            ArrayList<Hechizo> hechizos = cHechizos
                    .transformarHechizos(hechizosDatos);
            cHechizos.procesarHechizos(hechizos);
        } catch (Exception ex) {

        }

    }

    // Inicia los duelos mágicos y los muestra en la vista.
    public void iniciarDuelos() {
        try {
            //  Cargar los magos desde el archivo properties
            List<Mago> magos = cMago.transformarMagos();
            if (magos.isEmpty()) {
                cVista.notificarError("No se encontraron magos en el archivo de propiedades.");
                return;
            }

            this.listaMagos = magos;
            cVista.notificarCargaExitosa(listaMagos);

            // Iniciar la vista de duelos
            cVista.iniciarModoVisualizacionDuelos();

            // Simular duelos progresivos (el ganador sigue al siguiente)
            int numeroDuelo = 1;

            // El primer mago será el "retador inicial"
            Mago ganadorActual = listaMagos.get(0);

            for (int i = 1; i < listaMagos.size(); i++) {
                Mago retador = listaMagos.get(i);

                // Notificar inicio del duelo
                cVista.notificarInicioDuelo(numeroDuelo, ganadorActual, retador);

                // Ganador
                ganadorActual = (ganadorActual.getPuntaje() >= retador.getPuntaje())
                        ? ganadorActual
                        : retador;

                // Notificar resultado del duelo
                cVista.notificarResultadoDuelo(ganadorActual);

                numeroDuelo++;
            }

            cVista.notificarCampeonFinal(ganadorActual);

        } catch (Exception ex) {
            cVista.notificarError("Error al iniciar los duelos: " + ex.getMessage());
        }
    }
}
