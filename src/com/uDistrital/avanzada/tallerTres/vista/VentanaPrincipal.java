/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class VentanaPrincipal {

    JFrame ventana = new JFrame();
    public JButton btnCargarPropsMagos = new JButton("Cargar Magos (.properties)");
    public JButton btnCargarPropsHechizos = new JButton("Cargar Hechizos (.properties)");
    public JButton btnIniciar = new JButton("Iniciar Partida");
    public JButton btnSalir = new JButton("Salir");

    private GridBagConstraints gbcProp, gbcBatalla, gbcBotones, gbcVentana;
    private JPanel pnlProp, pnlBatalla, pnlBotones;
    private JPanel pnlJuego = new JPanel();

    public VentanaPrincipal() {

        ventana.setTitle("Duelo de magos– Taller 3");
        ventana.setSize(600, 400);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Config
        pnlProp = new JPanel(new GridBagLayout());
        gbcProp = new GridBagConstraints();
        gbcProp.insets = new Insets(5, 5, 5, 5);
        gbcProp.fill = GridBagConstraints.HORIZONTAL;
        gbcProp.gridx = 0;
        gbcProp.gridy = 0;
        gbcProp.gridwidth = 1;
        pnlProp.add(btnCargarPropsMagos);
        gbcProp.gridx = 1;
        gbcProp.gridy = 0;
        gbcProp.gridwidth = 1;
        pnlProp.add(btnCargarPropsHechizos);

        pnlBatalla = new JPanel(new GridBagLayout());
        gbcBatalla = new GridBagConstraints();
        gbcBatalla.insets = new Insets(25, 5, 25, 5);
        gbcBatalla.fill = GridBagConstraints.HORIZONTAL;
        gbcBatalla.gridx = 0;
        gbcBatalla.gridy = 0;
        pnlBatalla.add(new JLabel("Equipo A:"), gbcBatalla);
        gbcBatalla.gridx = 1;
        gbcBatalla.gridy = 0;
        pnlBatalla.add(new JLabel("Equipo B:"), gbcBatalla);

        pnlBotones = new JPanel(new GridBagLayout());
        gbcBotones = new GridBagConstraints();
        gbcBotones.insets = new Insets(5, 5, 5, 5);
        gbcBotones.fill = GridBagConstraints.HORIZONTAL;
        gbcBotones.gridx = 0;
        gbcBotones.gridy = 0;
        pnlBotones.add(new JButton("Iniciar"), gbcBotones);
        gbcBotones.gridx = 1;
        gbcBotones.gridy = 0;
        pnlBotones.add(new JButton("Salir"), gbcBotones);

        ventana.setLayout(new GridBagLayout());
        gbcVentana = new GridBagConstraints();
        gbcVentana.insets = new Insets(15, 10, 15, 10);
        gbcVentana.gridx = 0;
        gbcVentana.gridy = 0;
        ventana.add(pnlProp, gbcVentana);
        gbcVentana.gridx = 0;
        gbcVentana.gridy = 1;
        ventana.add(pnlBatalla, gbcVentana);
        gbcVentana.gridx = 0;
        gbcVentana.gridy = 2;
        ventana.add(pnlBotones, gbcVentana);

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

}
