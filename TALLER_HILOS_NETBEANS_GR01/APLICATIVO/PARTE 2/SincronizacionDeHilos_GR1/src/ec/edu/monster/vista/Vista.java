/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.vista;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *  @author DETPC
 */
public class Vista extends Thread{
    public void monstarHilos(String nombreHilo) {
        for (int i = 0; i < 8; i++) {
            System.out.println("Ejecutando hilo " + nombreHilo); // Imprime información sobre el hilo actual
            try {
                Thread.sleep(400); // Pausa la ejecución del hilo durante 400 milisegundos
            } catch (InterruptedException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

