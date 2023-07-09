/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.HilosVarios;
import ec.edu.monster.modelo.HilosVarios2;

/**
 *
 *  @author DETPC
 */
public class Controlador {

    public void ejecutarHilos(){
        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);
        
        hilo2.start();
        hilo1.start();
        
        System.out.println("Terminadas las tareas");
    }
}
