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
    private Lock cierreBanco = new ReentrantLock();

    public Banco() {
        this.cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
    }
    
    public double getSaldoTotal() {
        double total = 0;
        for (double a : cuentas) {
            total += a;
        }
        return total;
    }
    
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
        while (cuentas[cuentaOrigen] < cantidad) {
            wait();
        }
        System.out.println(Thread.currentThread());
        cuentas[cuentaOrigen] -= cantidad;
        System.out.printf("\n%10.2f de %d para %d.", cantidad, cuentaOrigen, cuentaDestino);
        cuentas[cuentaDestino] += cantidad;
        System.out.printf(" Saldo total: %10.2f", getSaldoTotal());
        notifyAll();
    }


}