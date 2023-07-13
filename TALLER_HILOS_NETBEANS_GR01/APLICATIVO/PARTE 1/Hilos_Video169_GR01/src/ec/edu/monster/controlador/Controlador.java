package ec.edu.monster.controlador;

import ec.edu.monster.modelo.PelotaHilos;
import ec.edu.monster.modelo.Pelota;
import ec.edu.monster.vista.Vista;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */

public class Controlador {
   Vista vista;
    PelotaHilos modelo;
    Thread t;
   
    public Controlador(Vista v,PelotaHilos mod){
        vista=v;
        IniciarComponentes();
        vista.setVisible(true);
        modelo=mod;
        
    }
    public void IniciarComponentes(){
        
        ponerBoton(vista.laminaBotones,vista.btnIniciar, "Dale!", new ActionListener(){		
            public void actionPerformed(ActionEvent evento){
		LanzarPelota();
            }			
	});
        
        ponerBoton(vista.laminaBotones,vista.btnSalir, "Salir", new ActionListener(){		
            public void actionPerformed(ActionEvent evento){				
		System.exit(0);				
            }		
        });
        
        ponerBoton(vista.laminaBotones,vista.btnDetener, "Detener", new ActionListener(){		
            public void actionPerformed(ActionEvent evento){
		detener();
            }			
	});
 
    }
    
    public void ponerBoton(Container c,JButton btn, String titulo, ActionListener oyente){	
	btn.setText(titulo);
        c.add(btn);		
	btn.addActionListener(oyente);	
    }
    
    public void LanzarPelota (){
        Color color = getRandomColor();
        Pelota pelota=new Pelota(color);
        vista.AñadirPelota(pelota);
	Runnable r = new PelotaHilos(pelota, vista.laminaPelota);
        t = new Thread(r);
        t.start();
    }
    
    public void detener(){
        t.interrupt();
    }
    
    private Color getRandomColor() {
    // Generar un color aleatorio
    int r = (int) (Math.random() * 256);
    int g = (int) (Math.random() * 256);
    int b = (int) (Math.random() * 256);
    return new Color(r, g, b);
    }
}
