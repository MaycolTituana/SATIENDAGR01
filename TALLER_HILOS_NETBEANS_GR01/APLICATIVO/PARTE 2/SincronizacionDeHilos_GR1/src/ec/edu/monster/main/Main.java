/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.main;

import ec.edu.monster.controlador.Controlador;

/**
 *
 *  @author DETPC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controlador controlador = new Controlador(); // Crea una instancia de Controlador
        controlador.ejecutarHilos(); // Ejecuta el método ejecutarHilos() de la instancia de Controlador
    }
    
}

