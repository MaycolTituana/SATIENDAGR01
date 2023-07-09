/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sincronizacion_hilos_banco;

import ec.edu.monster.controlador.EjecucionTransferencias;
import ec.edu.monster.modelo.Banco;

/**
 *
 * @author Maycol
 */
public class Sincronizacion_Hilos_Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco b=new Banco();
        for (int i = 0; i < 50; i++) {
            EjecucionTransferencias r=new EjecucionTransferencias(b,i,2000);
            Thread t=new Thread(r);
            t.start();
        }
    }
    
}
