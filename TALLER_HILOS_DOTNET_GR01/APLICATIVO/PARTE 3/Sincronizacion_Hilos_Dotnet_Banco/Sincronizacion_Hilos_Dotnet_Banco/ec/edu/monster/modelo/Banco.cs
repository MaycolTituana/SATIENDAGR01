using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sincronizacion_Hilos_Dotnet_Banco.ec.edu.monster.modelo
{
    class Banco
    {
        private double[] cuentas;

        //Constructor inicializa 100 cuentas con saldo de 2000 dolares
        public Banco()
        {
            this.cuentas = new double[100];
            for (int i = 0; i < cuentas.Length; i++)
            {
                cuentas[i] = 2000;
            }
        }

        public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad)
        {
            while (cuentas[cuentaOrigen] < cantidad)
            {
                return;
            }
            cuentas[cuentaOrigen] -= cantidad;
            Console.WriteLine($"Transferir ${cantidad} de la cuenta {cuentaOrigen} para la cuenta {cuentaDestino}. \r\n");
            cuentas[cuentaDestino] += cantidad;
            Console.WriteLine($"Saldo total : {cuentas[cuentaDestino]}.\r\n");
        }
         //Se obtiene el saldo total de la cuenta
        public double getSaldoTotal()
        {
            double total = 0;
            foreach (double a in cuentas)
            {
                total += a;
            }
            return total;
        }
    }
}
