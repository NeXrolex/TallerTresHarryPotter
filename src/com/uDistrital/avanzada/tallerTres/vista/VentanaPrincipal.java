/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.vista;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Ventana principal de la aplicación Se encarga de mostrar todos los datos a
 * pedir y mostrar los resultados de los duelos magicos
 *
 * Ventana principal de la aplicación Se encarga de mostrar todos los datos a
 * pedir y mostrar los resultados de los duelos magicos
 *
 * @author Alex,Jard,Stiven
 */
public class VentanaPrincipal extends JFrame {

    private JTextArea areaTexto;
    private JButton btnCargar;
    private JButton btnIniciar;
    private JButton btnLimpiar;
    private JScrollPane scrollPane;
    private JFileChooser fileChooser;
    private JPanel panelDatos;
    private JPanel panelGif;

    /**
     * Constructor encargado de inicializar la vista
     *
     * @param listener Listener para los botones
     */
    public VentanaPrincipal(ActionListener listener) {
        configurarVentana();
        configurarFileChooser();
        inicializarComponentes(listener);
        setVisible(true);
    }

    /**
     * Metodo encargado de configurar la ventana
     */
    private void configurarVentana() {
        setTitle("Duelo de Magos - Torneo de los Tres Magos");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    /**
     * Configura el JFileChooser para seleccionar archivos properties
     */
    private void configurarFileChooser() {
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Archivos Properties (*.properties)", "properties");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    }

    /**
     * Metodo encargado de inicializar todos los elementos de la interfaz
     *
     * @param listener Listener para eventos
     */
    private void inicializarComponentes(ActionListener listener) {
        // Panel superior con título
        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(new Color(139, 0, 0));
        panelTitulo.setPreferredSize(new Dimension(900, 70));
        JLabel lblTitulo = new JLabel(" DUELO DE MAGOS - TORNEO ", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel izquierdo informativo de hechizos donde va el areaTexto
        panelDatos = new JPanel();

        // Panel derecho gif magos
        panelGif = new JPanel();
        panelGif.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(139, 0, 0), 2),
                "Duelo",
                0,
                0,
                new Font("Arial", Font.BOLD, 14),
                new Color(139, 0, 0)
        ));

        // Panel central con área de texto
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaTexto.setBackground(new Color(245, 245, 245));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setMargin(new Insets(10, 10, 10, 10));
        scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(139, 0, 0), 2),
                "Registro de Duelos",
                0,
                0,
                new Font("Arial", Font.BOLD, 14),
                new Color(139, 0, 0)
        ));

        // Panel inferior con botones
        JSplitPane panelesBatalla = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, panelGif);
        panelesBatalla.setDividerLocation(550);
        panelesBatalla.setEnabled(false);
        panelesBatalla.setDividerSize(0);
        add(panelesBatalla, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBotones.setBackground(new Color(220, 220, 220));
        panelBotones.setPreferredSize(new Dimension(900, 80));

        btnCargar = crearBoton("Cargar Properties", "CARGAR",
                new Color(34, 139, 34));
        btnIniciar = crearBoton("Iniciar Duelos", "INICIAR",
                new Color(178, 34, 34));
        btnLimpiar = crearBoton(" Limpiar", "LIMPIAR",
                new Color(70, 130, 180));

        btnCargar.addActionListener(listener);
        btnIniciar.addActionListener(listener);
        btnLimpiar.addActionListener(listener);

        panelBotones.add(btnCargar);
        panelBotones.add(btnIniciar);
        panelBotones.add(btnLimpiar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Metodo encargado de configurar la creacion de botones de manera
     * persanilzada
     *
     * Metodo encargado de configurar la creacion de botones de manera
     * persanilzada
     *
     * @param texto Texto del botón
     * @param comando Comando de acción
     * @param color Color de fondo
     * @return Botón configurado
     */
    private JButton crearBoton(String texto, String comando, Color color) {
        JButton boton = new JButton(texto);
        boton.setActionCommand(comando);
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(200, 45));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createRaisedBevelBorder());
        return boton;
    }

    /**
     * Metodo encargado de abrir la ventana de JFileChoser con el fin de buscar
     * el archivo properties y cumplir con el requisito de abierto y cerrado
     *
     * @return Archivo seleccionado o null si se cancela
     */
    public File solicitarArchivoPropiedades() {
        int resultado = fileChooser.showOpenDialog(this);
        return fileChooser.getSelectedFile();
    }

    /**
     * Metodo para mostrar mensajes informativos
     *
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Metodo para mostrar mensajes de error
     *
     * @param mensaje Mensaje de error
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo para agregar texto en el area de texto
     *
     * @param texto Texto a agregar
     */
    public void agregarTexto(String texto) {
        areaTexto.append(texto);
        areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
    }

    /**
     * Metodo para limpiar texto
     */
    public void limpiarTexto() {
        areaTexto.setText("");
    }
}
