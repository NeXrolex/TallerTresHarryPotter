/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Alex
 */
public class VentanaPrincipal extends JFrame {

    JFrame ventana = new JFrame();
    public JButton btnCargarPropsMagos = new JButton("Cargar Magos (.properties)");
    public JButton btnCargarPropsHechizos = new JButton("Cargar Hechizos (.properties)");
    public JButton btnIniciar = new JButton("Iniciar Partida");
    public JButton btnSalir = new JButton("Salir");

    private GridBagConstraints gbcProp, gbcBatalla, gbcBotones, gbcVentana;
    private JPanel pnlProp, pnlBatalla, pnlBotones;
    private JPanel pnlJuego = new JPanel();

    public VentanaPrincipal() {

        ventana.setTitle("Pelea de magos - taller3");
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

    /**
     * Para cumplir con el Open/Close usamos un JFileChooser para tener la ruta
     * donde recide el archivo de propiedades
     *
     * @return archivo
     */
    public File SolicitarArchivoPropiedades() {

        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        chooser.setDialogTitle("Seleccione archivo de configuración (.properties)");
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    /**
     * Metodo encargado de mostrar mensaje empleando JOptionPane (Profe ya
     * entendí que solo es para mensajes pequenos)
     *
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje);

    }
    
    

}
