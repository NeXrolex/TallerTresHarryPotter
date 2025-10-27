package com.uDistrital.avanzada.tallerTres.control;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

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

    /**
     * Constructor encargado de intanciar los controles Se inyecctas a ellos
     * para cumplir con el bajo acoplamiento
     *
     */
    public ControlGeneral() {
        this.cVista = new ControlVista(this);
        this.cProps = new ControlProperties(this);
        this.cMago = new ControlMago(this);
        this.cHechizos = new ControlHechizos(this);

    }

    public Properties cargarProperties(File archivo) {
        try {
            return cProps.cargarDesde(archivo);
        } catch (Exception ex) {

        }
        return null;
    }
}
