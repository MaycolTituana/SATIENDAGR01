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
public class HilosVarios extends Thread{
    public void run(){
        Vista vista = new Vista();
        vista.monstarHilos(getName());
    }
}
