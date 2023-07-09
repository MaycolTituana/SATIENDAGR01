/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package usothreads;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */
public class UsoThreads {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame marco = new MarcoRebote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

//Movimiento de la pelota-----------------------------------------------------

class Pelota {
    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
    private Color color;

    public Pelota(Color color) {
        this.color = color;
    }
    
    // Mueve la pelota invirtiendo posicionn si choca con los limites

    public void mueve_pelota(Rectangle2D limites) {
        x += dx;
        y += dy;

        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }

        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }
    }

    //Forma de la pelota en su posicion inicial
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

    public Color getColor() {
        return color;
    }
}
// Lamina que dibuja las pelotas--------------------------------------------
class LaminaPelota extends JPanel {
    private List<Pelota> pelotas = new ArrayList<Pelota>();

    //Anadimos pelota a la lamina
    public void add(Pelota b) {
        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota b : pelotas) {
            g2.setColor(b.getColor());
            g2.fill(b.getShape());
        }
    }
   
}

//Marco con lamina y botones---------------------------------------------------
class MarcoRebote extends JFrame {
    private LaminaPelota lamina;
    private JButton boton;

    public MarcoRebote() {
        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();
        boton = ponerBoton(laminaBotones, "Dale!", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });

        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        add(laminaBotones, BorderLayout.SOUTH);
    }

    class PelotaHilos implements Runnable {
        private Pelota pelota;
        private Component componente;

        public PelotaHilos(Pelota unaPelota, Component unComponente) {
            this.pelota = unaPelota;
            this.componente = unComponente;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3000; i++) {
                pelota.mueve_pelota(componente.getBounds());
                componente.repaint();
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Ponemos botones
    public JButton ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        c.setBackground(Color.DARK_GRAY);
        boton.setBackground(Color.GREEN.darker());
        boton.setForeground(Color.WHITE);
        boton.addActionListener(oyente);
        return boton;
    }

    //Anade pelota y la bota 1000 veces
    public void comienza_el_juego() {
        Random random = new Random();
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

        Pelota pelota = new Pelota(color);
        lamina.add(pelota);
        boton.setBackground(color);
        boton.setOpaque(true);
        boton.setBorderPainted(false);

        Runnable r = new PelotaHilos(pelota, lamina);
        Thread t = new Thread(r);
        t.start();
    }
}

