/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

import ec.edu.monster.vista.Vista;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *  @author DETPC
 */
public class HilosVarios2 extends Thread{
    
    public HilosVarios2(Thread hilo){
        this.hilo=hilo;
    }
    
    public void run(){
        try {
            hilo.join(); // Espera a que el hilo especificado termine su ejecución antes de continuar
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Vista vista = new Vista();
        vista.monstarHilos(getName()); // Muestra información sobre el hilo actual en la vista
    }
   
    private Thread hilo; // Variable que almacena el hilo especificado en el constructor
}
