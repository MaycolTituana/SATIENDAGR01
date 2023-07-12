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
        HilosVarios hilo1 = new HilosVarios(); // Crea una instancia de HilosVarios
        HilosVarios2 hilo2 = new HilosVarios2(hilo1); // Crea una instancia de HilosVarios2, pasando hilo1 como argumento
        
        hilo2.start(); // Inicia la ejecución de hilo2
        hilo1.start(); // Inicia la ejecución de hilo1
        
        System.out.println("Terminadas las tareas"); // Imprime un mensaje indicando que las tareas han terminado
    }
}
