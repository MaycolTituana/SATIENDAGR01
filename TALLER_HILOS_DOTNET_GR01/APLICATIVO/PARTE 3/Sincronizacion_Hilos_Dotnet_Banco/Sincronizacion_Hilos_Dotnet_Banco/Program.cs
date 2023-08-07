using Sincronizacion_Hilos_Dotnet_Banco.ec.edu.monster.controlador;
using Sincronizacion_Hilos_Dotnet_Banco.ec.edu.monster.modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Sincronizacion_Hilos_Dotnet_Banco
{
    class Progam
    {
        public static void Main(string[] args)
        {
            //Se crea una instancia del modelo banco.
            //El constructor de la clase crea 100 cuentas con 2000 dolares.
            Banco banco = new Banco();
            //El for simula las transacciones a las cuentas creadas.
            for (int i = 0; i < 1000; i++)
            {
                EjecucionTransferencias r = new EjecucionTransferencias(banco, i, 5);
                //Se crea una instancia de un hilo y se ejecuta.
                Thread t = r.getHilo();
                t.Start();
            }
        }
    }


}
