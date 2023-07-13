/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.vista;

import ec.edu.monster.modelo.Pelota;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */
public class Vista extends JFrame{
    public LaminaPelotaVista laminaPelota;
    public JPanel laminaBotones;
    public JButton btnIniciar;
     public JButton btnSalir;

    public LaminaPelotaVista getLaminaPelota() {
        return laminaPelota;
    }

    public void setLaminaPelota(LaminaPelotaVista laminaPelota) {
        this.laminaPelota = laminaPelota;
    }
    public Vista(){
        setBounds(600,300,400,350);
	setTitle ("Parte 1");
        laminaBotones=new JPanel();
        this.laminaPelota=new LaminaPelotaVista();
        laminaBotones.setBackground(Color.BLACK);
        add(this.laminaPelota, BorderLayout.CENTER);
        btnIniciar=new JButton();
        btnIniciar.setBackground(Color.GREEN.darker());
        btnIniciar.setForeground(Color.WHITE);
        btnSalir=new JButton();
        btnSalir.setBackground(Color.red.darker());
        btnSalir.setForeground(Color.WHITE);
        add(laminaBotones, BorderLayout.SOUTH);
    }
    public void AñadirPelota(Pelota m){
        laminaPelota.add(m);
    }
}
