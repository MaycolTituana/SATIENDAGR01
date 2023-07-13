/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.main;
import ec.edu.monster.controlador.Controlador;
import ec.edu.monster.modelo.PelotaHilos;
import ec.edu.monster.vista.Vista;

/**
 *
 * @author JOHAO MORALES, MAYCOL TITUAÑA, ALEX VELASTEGUI
 */
public class Hilos_GR01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista vista=new Vista();
        PelotaHilos modelo=new PelotaHilos();
        Controlador controlador=new Controlador(vista,modelo);
    }
}
