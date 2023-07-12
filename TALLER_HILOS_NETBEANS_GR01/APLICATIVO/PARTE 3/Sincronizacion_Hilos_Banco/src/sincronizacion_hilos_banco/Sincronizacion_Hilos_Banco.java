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
        //Se crea una instancia del modelo banco.
        //El constructor de la clase crea 100 cuentas con 2000 dolares.
        Banco b=new Banco();
        //El for simula las transacciones a las cuentas creadas.
        for (int i = 0; i < 50; i++) {
            EjecucionTransferencias r=new EjecucionTransferencias(b,i,2000);
            //Se crea una instancia de un hilo y se ejecuta.
            Thread t=new Thread(r);
            t.start();
        }
    }
    
}
