/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.vista;

import ec.edu.monster.modelo.Pelota;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */
class LaminaPelotaVista extends JPanel{
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
	
        //Añadimos pelota a la lámina
	public LaminaPelotaVista(){
            
        }
        public void add(Pelota b){
            pelotas.add(b);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D) g;
            ArrayList<Pelota> copiaPelotas = new ArrayList<>(pelotas);  // Hacer una copia de la lista
            for(Pelota b: copiaPelotas){
                g2.setColor(b.getColor());  // Establecer el color de la pelota
		g2.fill(b.getShape());
            }		
	}		
}