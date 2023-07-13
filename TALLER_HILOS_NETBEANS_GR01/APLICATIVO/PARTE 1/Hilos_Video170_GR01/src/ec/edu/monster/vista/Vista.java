/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vista;

import ec.edu.monster.modelo.PelotaHilos;
import  ec.edu.monster.controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ec.edu.monster.modelo.Pelota;
import java.awt.Color;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */
public class Vista extends JFrame {
    public Pelota pelotaModel;
    private final LaminaPelotaVista panel;
    public Controlador pelotaController;
    private Thread hiloPelota1;
    private Thread hiloPelota2;
    private Thread hiloPelota3;
    private JButton btnDetenerPelota1;
    private JButton btnDetenerPelota2;
    private JButton btnDetenerPelota3;
    private JButton btnComenzarPelota1;
    private JButton btnComenzarPelota2;
    private JButton btnComenzarPelota3;
    

    public Vista() {
        JPanel panelBotones = new JPanel();
        panel               = new LaminaPelotaVista();
        pelotaController    = new Controlador();
        
        setBounds(800, 500, 1000, 550);
        setTitle("Parte 3");
        
        btnComenzarPelota1 = obtenerBoton("Pelota 1", event -> comenzarJuego(1));
        btnComenzarPelota1.setBackground(Color.GREEN.darker());
        btnComenzarPelota1.setForeground(Color.WHITE);
        btnComenzarPelota2 = obtenerBoton("Pelota 2", event -> comenzarJuego(2));
        btnComenzarPelota2.setBackground(Color.BLUE.darker());
        btnComenzarPelota2.setForeground(Color.WHITE);
        btnComenzarPelota3 = obtenerBoton("Pelota 3", event -> comenzarJuego(3));
        btnComenzarPelota3.setBackground(Color.MAGENTA.darker());
        btnComenzarPelota3.setForeground(Color.WHITE);
        
        //Se da las acciones al boton detener
        btnDetenerPelota1 = obtenerBoton("Detener 1", event -> detener(1));
        btnDetenerPelota1.setBackground(Color.GREEN.darker());
        btnDetenerPelota1.setForeground(Color.WHITE);
        btnDetenerPelota2 = obtenerBoton("Detener 2", event -> detener(2));
        btnDetenerPelota2.setBackground(Color.BLUE.darker());
        btnDetenerPelota2.setForeground(Color.WHITE);
        btnDetenerPelota3 = obtenerBoton("Detener 3", event -> detener(3));
        btnDetenerPelota3.setBackground(Color.MAGENTA.darker());
        btnDetenerPelota3.setForeground(Color.WHITE);

        //se agregan los botones al panel
        panelBotones.setBackground(Color.BLACK);
        panelBotones.add(btnComenzarPelota1);
        panelBotones.add(btnComenzarPelota2);
        panelBotones.add(btnComenzarPelota3);
        panelBotones.add(btnDetenerPelota1);
        panelBotones.add(btnDetenerPelota2);
        panelBotones.add(btnDetenerPelota3);

        add(panel, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private JButton obtenerBoton(String titulo, ActionListener listener) {
        JButton boton = new JButton(titulo);
        boton.addActionListener(listener);
        return boton;
    }

    private Color obtenerColor(int numBoton) {
        switch (numBoton) {
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.MAGENTA;
            default:
                return Color.BLACK; // Color por defecto en caso de que numBoton no coincida con ningún caso
        }
    }
    
    private void comenzarJuego(int numBoton) {
        pelotaModel = new Pelota();
        pelotaModel.setColor(obtenerColor(numBoton)); // Establecer el color de la pelota
        panel.agregarPelota(pelotaModel);
        Runnable runnablePelota = new PelotaHilos(pelotaModel, pelotaController, panel);
        switch (numBoton) {
            case 1:
                hiloPelota1 = new Thread(runnablePelota);
                hiloPelota1.start();
                break;
            case 2:
                hiloPelota2 = new Thread(runnablePelota);
                hiloPelota2.start();
                break;
            case 3:
                hiloPelota3 = new Thread(runnablePelota);
                hiloPelota3.start();
                break;
        }
    }

    private void detener(int numBoton) {
        switch (numBoton) {
            case 1:
                hiloPelota1.interrupt();
                break;
            case 2:
                hiloPelota2.interrupt();
                break;
            case 3:
                hiloPelota3.interrupt();
                break;
        }
    }
}
