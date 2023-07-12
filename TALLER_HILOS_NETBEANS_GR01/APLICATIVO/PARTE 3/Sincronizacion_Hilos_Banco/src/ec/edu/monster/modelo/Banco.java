/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Maycol
 */

public class Banco {

    private final double[] cuentas;
    //LOCK para proporcionar capacidades de bloqueo en un contexto multihilo
    //ReeentrantLocck bloque que permite adquirir y liberar el bloqueo múltiples veces por el mismo hilo
    private Lock cierreBanco = new ReentrantLock();

    //Constructor inicializa 100 cuentas con saldo de 2000 dolares
    public Banco() {
        this.cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
    }
    
    //Se obtiene el saldo total de la cuenta
    public double getSaldoTotal() {
        double total = 0;
        for (double a : cuentas) {
            total += a;
        }
        return total;
    }
    
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
        while (cuentas[cuentaOrigen] < cantidad) {
            //Hace esperar hasta que haya suficientes fondos en la cuenta de origen
            wait();
        }
        //Imprime información sobre el hilo actual en la consola
        System.out.println(Thread.currentThread());
    
        //Se realiza la transferencia y se muestra la informacion de las cuentas.
        cuentas[cuentaOrigen] -= cantidad;
        System.out.printf("\n%10.2f de %d para %d.", cantidad, cuentaOrigen, cuentaDestino);
        cuentas[cuentaDestino] += cantidad;
        System.out.printf(" Saldo total: %10.2f",cuentas[cuentaDestino]);
        //Para notificar a todos los hilos en espera que se ha realizado una transferencia.
        //Permite que los hilos verifiquen nuevamente sus condiciones para determinar si pueden continuar con sus tareas.
        notifyAll();
    }

}