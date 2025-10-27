package com.uDistrital.avanzada.tallerTres.control;

/**
 * Maneja todo el flujo de la informacion entres los controles y
 * orquesta la comunicacion entre ellos
 *
 * @author Gezz, Alex
 * @version 1.0
 */
public class ControlGeneral {

    private ControlVista cVista;
    private ControlProperties cProps;
    private ControlHechizos cHechizos;
    private ControlMago cMago;

    public ControlGeneral() {
        this.cVista = new ControlVista(this);
        this.cProps = new ControlProperties(this);
        this.cMago = new ControlMago(this);
        this.cHechizos = new ControlHechizos(this);
                
    }
}

