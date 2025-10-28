package com.uDistrital.avanzada.tallerTres.control;

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
     * Constructor encargado de intanciar los controles Se inyecctas a ellos
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
     * Flujo de la informacion para cargar los properties usando 
     * el JFileChooser
     * 
     * @param archivo Archivo dse propiedades
     */
    public void cargarProperties(File archivo) {
        try {
            cProps.cargarDesde(archivo);
            ArrayList hechizos = cProps.transformarHechizos();
            cHechizos.procesarHechizos(hechizos);
        } catch (Exception ex) {

        }
       
    }
    
}
