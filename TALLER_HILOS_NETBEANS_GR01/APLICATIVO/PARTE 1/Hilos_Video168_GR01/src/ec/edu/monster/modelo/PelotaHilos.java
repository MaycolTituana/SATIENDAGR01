/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */
public class PelotaHilos implements Runnable {
    private Pelota pelota;
    private Component componente;
    public PelotaHilos(){
        
    }
    public PelotaHilos(Pelota unaPelota, Component unComponente){
        pelota= unaPelota;
        componente = unComponente;
    }
    public void run(){
        for (int i=1; i<=3000; i++){
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
    

