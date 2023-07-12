/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Banco;

/**
 *
 * @author Maycol
 */
public class EjecucionTransferencias implements Runnable {

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;

    public EjecucionTransferencias(Banco banco, int deLaCuenta, double cantidadMax) {
        this.banco = banco;
        this.deLaCuenta = deLaCuenta;
        this.cantidadMax = cantidadMax;
    }
    //run() se encarga de realizar transferencias aleatorias de dinero 
    //entre cuentas en el objeto banco en un bucle infinito
    @Override
    public void run() {
        try {
            while (true) {
                int paraLaCuenta = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                //Se utiliza para introducir ese retraso aleatorio de milisegundos
                Thread.sleep((int) Math.random() * 10);
            }
        } catch (InterruptedException ex) {
            
        }

    }

}

