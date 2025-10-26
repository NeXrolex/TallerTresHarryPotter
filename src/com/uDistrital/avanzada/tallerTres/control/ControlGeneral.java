package com.uDistrital.avanzada.tallerTres.control;

/**
 *
 * @author Gezz
 */
public class ControlGeneral {

    private ControlVista cVista;

    public ControlGeneral() {
        this.cVista = new ControlVista(this);
    }
}

