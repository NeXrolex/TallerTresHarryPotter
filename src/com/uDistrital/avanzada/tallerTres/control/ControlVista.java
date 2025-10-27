/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Controla las acciones de los elementos de la vista y ayuda a orquestar la
 * logica de la misma
 *
 * @author Gezz
 * @version 1.0
 */
public class ControlVista implements ActionListener {

    private VentanaPrincipal vista;
    private ControlGeneral controlGeneral;

    public ControlVista(ControlGeneral general) {
        this.controlGeneral = general;
        this.vista = new VentanaPrincipal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        File archivo = vista.SolicitarArchivoPropiedades();

        if (archivo == null) {
            vista.mostrarMensaje("Seleccin cancelada");
        }
        try{
            controlGeneral.cargarProperties(archivo);
        }catch(Exception ex){
            vista.mostrarMensaje("error al cargar" + ex.getMessage());
            
        }
    }
}
