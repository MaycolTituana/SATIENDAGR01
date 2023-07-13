package ec.edu.monster.controlador;

import ec.edu.monster.modelo.PelotaHilos;
import ec.edu.monster.modelo.Pelota;
import ec.edu.monster.vista.Vista;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controlador {
     Vista vista;
    PelotaHilos modelo;
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
    }
    
    public void ponerBoton(Container c,JButton btn, String titulo, ActionListener accion){	
	btn.setText(titulo);
        c.add(btn);		
	btn.addActionListener(accion);	
    }
    public void LanzarPelota(){	
        Color color = obtenerColorAleatorio();  // Obtener un color aleatorio para la pelota
        Pelota pelota=new Pelota(color);
        vista.AñadirPelota(pelota);
	Runnable r = new PelotaHilos(pelota, vista.laminaPelota);
        Thread t = new Thread(r);
        t.start();
    }
    
     private Color obtenerColorAleatorio() {
        // Generar valores RGB aleatorios
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        return new Color(red, green, blue);
    }
}
