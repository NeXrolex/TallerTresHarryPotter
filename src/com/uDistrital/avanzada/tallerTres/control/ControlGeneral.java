package com.uDistrital.avanzada.tallerTres.control;

/**
 *
 * @author Gezz
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

