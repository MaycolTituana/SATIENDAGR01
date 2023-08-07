using Sincronizacion_Hilos_Dotnet_Banco.ec.edu.monster.modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Sincronizacion_Hilos_Dotnet_Banco.ec.edu.monster.controlador
{
    class EjecucionTransferencias
    {
        private Banco banco;
        private int deLaCuenta;
        private int cantidadMax;
        private Thread t;

        public EjecucionTransferencias(Banco banco, int deLaCuenta, int cantidadMax)
        {
            this.banco = banco;
            this.deLaCuenta = deLaCuenta;
            this.cantidadMax = cantidadMax;
            t = new Thread(comenzar);
        }

        public Thread getHilo() { return t; }

        public void comenzar()
        {
            int limite = cantidadMax + 1;
            var r = new Random();
            double cantidad = r.NextDouble() * (10 - (limite)) + (limite);
            int cantidadEntera = (int)Math.Round(cantidad);
            cantidad = cantidadEntera;
            deLaCuenta = r.Next(1, 11);
            int paraLaCuenta = r.Next(1, 11);
            while (true)
            {
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                deLaCuenta = r.Next(1, 11);
                paraLaCuenta = r.Next(1, 11);
                cantidad = r.NextDouble() * (10 - (limite)) + (limite);
                Thread.Sleep(500);
            }
        }

    }
}
